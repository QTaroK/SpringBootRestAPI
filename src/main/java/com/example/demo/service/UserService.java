package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

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

  // ファイルアップロード
  // MultipartFile
  // localの指定の場所に保存
  public void upload(MultipartFile file) {
    try {
      // 指定の場所にuuidのフォルダを作成してその場所に画像を保存
      String path = "/Users/kiuchi_tarou/MENTA/一弥/demo/sample/";
      String uuid = java.util.UUID.randomUUID().toString();
      String file_name = uuid + "_" + file.getOriginalFilename();
      File uploadFile = new File(path + file_name);
      FileOutputStream fos = new FileOutputStream(uploadFile);
      fos.write(file.getBytes());
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
