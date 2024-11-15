package com.kienluu.demo.controller;

import com.kienluu.demo.dto.UserDTO;
import com.kienluu.demo.entity.UserEntity;
import com.kienluu.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("")
    public ResponseEntity<Object> createUser(@RequestBody UserEntity user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.status(201).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username) {
        try {
            UserEntity user = userService.getUserByUsername(username);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



    @GetMapping("/home")
    public ResponseEntity<Object> getHome(@RequestParam String location) {
        return ResponseEntity.ok("nga");
    }

//    @PostMapping("/user")
//    public ResponseEntity<Object> postUser(@RequestBody UserDTO userDTO) {
//        try {
//            UserDTO userDTO1 = UserDTO.builder()
//                    .username("Nga")
//                    .password("123456")
//                    .email("lac@gmail.com")
//                    .build();
//            return ResponseEntity.status(201).body(userDTO1);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
//        }
//    }
}
