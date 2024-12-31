package com.Blockchain.blockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Blockchain.blockchain.dto.ReqRes;
import com.Blockchain.blockchain.entity.OurUsers;
import com.Blockchain.blockchain.repository.OurUserRepo;

@Service
public class AuthService {

    @Autowired
    private OurUserRepo ourUserRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    public ReqRes signUp(ReqRes registrationRequest) {
        ReqRes resp = new ReqRes();
        try {
            // Vérification si l'email existe déjà
            if (ourUserRepo.findByEmail(registrationRequest.getEmail()).isPresent()) {
                resp.setStatusCode(400); // Code HTTP 400 : Requête invalide
                resp.setMessage("Un utilisateur avec cet email existe déjà.");
                return resp;
            }
    
            // Création d'un nouvel utilisateur
            OurUsers ourUsers = new OurUsers();
            ourUsers.setEmail(registrationRequest.getEmail());
            ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            ourUsers.setRole(registrationRequest.getRole());
            
            // Enregistrement de l'utilisateur en base
            OurUsers ourUserResult = ourUserRepo.save(ourUsers);
            if (ourUserResult != null && ourUserResult.getId() > 0) {
                resp.setOurUsers(ourUserResult);
                resp.setMessage("Utilisateur enregistré avec succès.");
                resp.setStatusCode(200);
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
    
    public ReqRes signIn(ReqRes signinRequest) {
        ReqRes response = new ReqRes();
    
        try {
            // Authentification avec AuthenticationManager
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    signinRequest.getEmail(),
                    signinRequest.getPassword()
                )
            );
    
            // Vérification si l'utilisateur existe
            var user = ourUserRepo.findByEmail(signinRequest.getEmail())
                                  .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable."));
            
            response.setStatusCode(200);
            response.setOurUsers(user);
            response.setMessage("Connexion réussie.");
        } catch (IllegalArgumentException e) {
            response.setStatusCode(404); // Code HTTP 404 : Non trouvé
            response.setError(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError("Échec de l'authentification : " + e.getMessage());
        }
        return response;
    }
    
}


// import com.Blockchain.blockchain.dto.ReqRes;
// import com.Blockchain.blockchain.entity.OurUsers;
// import com.Blockchain.blockchain.repository.OurUserRepo;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.HashMap;

// @Service
// public class AuthService {

//     @Autowired
//     private OurUserRepo ourUserRepo;
//     @Autowired
//     private JWTUtils jwtUtils;
//     @Autowired
//     private PasswordEncoder passwordEncoder;
//     @Autowired
//     private AuthenticationManager authenticationManager;
    
  

   

    
//     public ReqRes signUp(ReqRes registrationRequest){
//         ReqRes resp = new ReqRes();
//         try {
//             OurUsers ourUsers = new OurUsers();
//             ourUsers.setEmail(registrationRequest.getEmail());
//             ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
//             ourUsers.setRole(registrationRequest.getRole());

//             // Save the user in the database
//             OurUsers ourUserResult = ourUserRepo.save(ourUsers);


//             if (ourUserResult != null && ourUserResult.getId()>0) {

               

//                 resp.setOurUsers(ourUserResult);
//                 resp.setMessage("User registered successfully. ");
//                 resp.setStatusCode(200);
                
//             }
//         }catch (Exception e){
//             resp.setStatusCode(500);
//             resp.setError("Authentication failed: " + e.getMessage());
//             e.printStackTrace(); // or use a logging framework

//         }
//         return resp;
//     }

//     public ReqRes signIn(ReqRes signinRequest){
//         ReqRes response = new ReqRes();

//         try {
//             // Authenticate the user
//             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
//             // Load the user from the database
//             var user = ourUserRepo.findByEmail(signinRequest.getEmail()).orElseThrow();
//             System.out.println("USER IS: "+ user);

//              // Check if the user is enabled (email verified)
//             if (!user.isEnabled()) {
//                 response.setStatusCode(403);
//                 response.setMessage("Account is not verified. Please check your email.");
//                 return response;
//             }
//             // Generate JWT and refresh token
//             var jwt = jwtUtils.generateToken(user);
//             var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
//             response.setStatusCode(200);
//             response.setToken(jwt);
//             response.setRefreshToken(refreshToken);
//             response.setExpirationTime("24Hr");
//             response.setMessage("Successfully Signed In");
//         }catch (Exception e){
//             response.setStatusCode(500);
//             response.setError("Authentication failed: " + e.getMessage());
//         }
//         return response;
//     }

//     public ReqRes refreshToken(ReqRes refreshTokenReqiest){
//         ReqRes response = new ReqRes();
//         String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
//         OurUsers users = ourUserRepo.findByEmail(ourEmail).orElseThrow();
//         if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
//             var jwt = jwtUtils.generateToken(users);
//             response.setStatusCode(200);
//             response.setToken(jwt);
//             response.setRefreshToken(refreshTokenReqiest.getToken());
//             response.setExpirationTime("24Hr");
//             response.setMessage("Successfully Refreshed Token");
//         }
//         response.setStatusCode(500);
//         return response;
//     }


   
// }
