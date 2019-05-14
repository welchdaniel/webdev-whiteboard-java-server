package com.example.whiteboard.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.whiteboard.models.User;

@RestController
public class UserController {
  List<User> usersList = new ArrayList<User>();

  @GetMapping("/users")
  public List<User> findAllUsers() {
    return usersList;
  }

  @DeleteMapping("/users/{userId}")
  public User[] deleteUser(@PathVariable("userId") int userId) {
    return null;
  }

  @PostMapping("/users")
  public List<User> createUser(@RequestBody User user) {
    usersList.add(user);
    return usersList;
  }


}
