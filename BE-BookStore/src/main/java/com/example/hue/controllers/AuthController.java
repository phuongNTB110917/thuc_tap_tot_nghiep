package com.example.hue.controllers;

import com.example.hue.common.enums.ERole;
import com.example.hue.common.enums.SocialProvider;
import com.example.hue.common.request.LoginRequest;
import com.example.hue.common.request.ResetPassRequest;
import com.example.hue.common.request.SignupRequest;
import com.example.hue.common.request.VerifyRequest;
import com.example.hue.common.response.JwtResponse;
import com.example.hue.common.response.MessageResponse;
import com.example.hue.models.entity.Role;
import com.example.hue.models.entity.User;
import com.example.hue.repositories.RoleRepository;
import com.example.hue.repositories.UserRepository;
import com.example.hue.sercurity.jwt.JwtUtils;
import com.example.hue.services.UserService;
import com.example.hue.services.impl.SendMail;
import com.example.hue.services.impl.UserServiceImpl;
import net.bytebuddy.utility.RandomString;
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
import java.util.List;
import java.util.Optional;
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
    SendMail sendMail;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserServiceImpl userService = (UserServiceImpl) authentication.getPrincipal();
//        LocalUser localUser = (LocalUser) authentication.getPrincipal();
        List<String> roles =  userService.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userService.getId(), userService.getUsername(), userService.getEmail(), roles));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
        if (userRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity.
                    badRequest().
                    body(new MessageResponse("Error: Tên người dùng đã được sử dụng!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email đã được sử dụng!"));
        }

        User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

//        Set<String> strRoles = signupRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null){
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Không tìm thấy vai trò."));
//            roles.add(userRole);
//        }
//
//        user.setRoles(roles);

//        sendMail.sendMail(user.getEmail(), "Đăng kí thành công", "Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi");

        user.setProvider(String.valueOf(SocialProvider.LOCAL));
        user.setActive(true);
        User _user = userRepository.save(user);
        System.out.println("dang ki thanh cong");
        return ResponseEntity.ok(new MessageResponse("Người dùng đã đăng ký thành công!"));
    }

    @PostMapping("/verify-password")
    public ResponseEntity<?> VerifyPassword(@RequestBody VerifyRequest code) {
        System.out.println("ss");
        User isVerified = userRepository.findUserByVerificationCode(code.getCode());
        System.out.println(isVerified.getVerificationCode());
        if (isVerified.getVerificationCode().equals(code.getCode())) {
            return ResponseEntity.ok(new MessageResponse("accepted"));
        } else {
            return ResponseEntity.ok(new MessageResponse("error"));
        }
    }

    @PostMapping("/do-forget-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        userRepository.saveNewPassword(passwordEncoder.encode(resetPassRequest.getPassword()), resetPassRequest.getCode());
        return ResponseEntity.ok(new MessageResponse("success"));
    }


}
