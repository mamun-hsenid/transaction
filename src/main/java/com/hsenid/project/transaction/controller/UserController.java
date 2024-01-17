package com.hsenid.project.transaction.controller;

import com.hsenid.project.transaction.model.UserInfo;
import com.hsenid.project.transaction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @PostMapping(value = "/add-user")
    public ResponseEntity<? extends UserInfo> addUser(@RequestBody UserInfo user) {
        logger.info("User rewuest data");
        logger.info(user.toString());
        userService.addUser(user);

        return ResponseEntity.ok().body(user);
    }
}
