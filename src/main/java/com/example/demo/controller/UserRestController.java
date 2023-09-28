package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import com.example.demo.model.User;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "list")
  public List<User> userList() {
    return userService.findAll();
  }

  @PostMapping(value = "add")
  public UserDto add(@RequestBody @Valid UserDto userDto) throws Exception {
    User user = new User(userDto);
    userService.save(user);

    return userDto;
  }

  @GetMapping(value = "user")
  public UserDto getUser(@RequestParam int userNumber) throws UserNotFoundException {
    User user = new User();
    try {
      user = userService.findById(userNumber);
    } catch (UserNotFoundException e) {
      throw e;
    }

    UserDto userDto = new UserDto(user);
    return userDto;

  }

  @DeleteMapping(value = "user")
  public void getDeleteuser(@RequestParam int deleteUserNumber) {
    userService.deleteById(deleteUserNumber);
  }

}
