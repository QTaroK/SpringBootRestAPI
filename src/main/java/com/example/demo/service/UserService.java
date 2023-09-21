package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> findAll() {
    List<User> list = userRepository.findAll();

    return list;
  }

  public void save(User user) {
    userRepository.save(user);

  }

  public User findById(int id) throws UserNotFoundException {
    User user = new User();
    if (userRepository.existsById(id)) {
      user = userRepository.findById(id).get();

    } else {
      throw new UserNotFoundException("User Id noft found!");
    }
    // Exception Exceptionハンドラー
    return user;
  }

  public void deleteById(int id) {
    userRepository.deleteById(id);
  }

}
