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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

  public static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Autowired
  private UserService userService;

  @GetMapping(value = "list")
  public List<User> userList() {
    return userService.findAll();
  }

  @PostMapping(value = "add")
  public UserDto add(@RequestBody @Valid UserDto userDto) throws Exception {
    User user = new User(userDto);

    logger.error("OK");
    logger.warn("OK");
    logger.info("OK");

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
