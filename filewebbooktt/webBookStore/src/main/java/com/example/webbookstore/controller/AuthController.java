package com.example.webbookstore.controller;

import com.example.webbookstore.model.Role;
import com.example.webbookstore.model.User;
import com.example.webbookstore.payload.request.LoginRequest;
import com.example.webbookstore.payload.request.RegisterRequest;
import com.example.webbookstore.payload.response.JwtResponse;
import com.example.webbookstore.payload.response.ResponseMessage;
import com.example.webbookstore.repository.RoleRepository;
import com.example.webbookstore.repository.UserRepository;
import com.example.webbookstore.security.jwt.JwtUtils;
import com.example.webbookstore.service.UserService;
import com.example.webbookstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserServiceImpl userService = (UserServiceImpl) authentication.getPrincipal();
//        LocalUser localUser = (LocalUser) authentication.getPrincipal();
        Set<String> roles = (Set<String>) userService.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

//        LocalUser localUser = null;
//        try {
//            localUser = (LocalUser) authentication.getPrincipal();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, GeneralUtils.buildUserInfo(localUser)));
        return ResponseEntity.ok(new JwtResponse(jwt, userService.getId(), userService.getUsername(), userService.getEmail(), roles));
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest signupRequest){
//        if (userRepository.existsUserByName(signupRequest.getName())){
//            return ResponseEntity.
//                    badRequest().
//                    body(new ResponseMessage("Error: Username is already taken!"));
//        }
//
//        if (userRepository.existsByEmail(signupRequest.getEmail())){
//            return ResponseEntity
//                    .badRequest()
//                    .body(new ResponseMessage("Error: Email is already in use!"));
//        }
//
//        User user = new User(signupRequest.getName(), signupRequest.getEmail(),
//                passwordEncoder.encode(signupRequest.getPassword()));
//
//        Set<String> strRoles = signupRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
////        if (strRoles == null){
////            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
////                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
////            roles.add(userRole);
////        }
//
//        user.setRoles(roles);
//
////        sendMail.sendMail(user.getEmail(), "Đăng kí thành công", "Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi");
////
////        user.setProvider(String.valueOf(SocialProvider.LOCAL));
////        user.setActive(true);
////        User _user = userRepository.save(user);
////        Cart cart = new Cart(new BigDecimal(0.0), _user);
////        cartRepository.save(cart);
//        return ResponseEntity.ok(new ResponseMessage("User registered successfully!"));
//    }


}
