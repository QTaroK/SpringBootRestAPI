package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "user")
  public List<User> userList() {
    return userService.findAll();
  }
}
