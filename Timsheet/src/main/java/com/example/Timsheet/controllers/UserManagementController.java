package com.example.Timsheet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Timsheet.DTO.LoginDTO;
import com.example.Timsheet.DTO.RegisterDTO;
import com.example.Timsheet.services.UserService;

@RestController
@RequestMapping("/api/userM")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserManagementController {


    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/registerDTO")
    public ResponseEntity<?>  submitRegisterasi(@RequestBody RegisterDTO dto){
        System.out.println(dto.getEmail() + "dsgvhadas");
         userService.save(dto);
        return  ResponseEntity.ok().body("Registerasi Sukses");
    }

    // @PostMapping("/registerDTO")
    // public boolean submitRegisterasi(@RequestBody RegisterDTO dto){
    //     Boolean result;
    //   result =  userService.save(dto);
    //     return  result;
    // }

    // @PostMapping("/login")
    //     public Boolean submitLogin(@RequestBody LoginDTO loginDTO){
    //         Boolean result;
    //         result = userService.LoginEmp(loginDTO);
    //     return result;
    // }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody(required = false) LoginDTO login) {
        org.springframework.security.core.Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated() == true) {
            return ResponseEntity.ok().body("Login Sukses");
        } else {
            return ResponseEntity.badRequest().body("Login Gagal");
        }
    }

    // @GetMapping("/info")
    // @ResponseBody
    // public ResponseEntity<List<RegisterDTO>>
    // getEmployeeInfo(Authentication authentication) {
    //     String email = authentication.getName();
    //     User user = userService.getIdByEmail(email);
    //     return ResponseEntity.ok().body(userService.getById(user.getId()));
    // }
    
}
