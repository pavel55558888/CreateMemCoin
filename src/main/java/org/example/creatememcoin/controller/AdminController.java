package org.example.creatememcoin.controller;

import org.example.creatememcoin.hibernate.service.GetUsernameToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private GetUsernameToken getUsernameToken;

    @GetMapping("/admin/token/{username}")
    public ResponseEntity<?> getUserTokenAdmin(@PathVariable String username) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getUsernameToken.getUsernameToken(username));
    }
}
