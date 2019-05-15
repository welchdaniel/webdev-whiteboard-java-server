package com.example.whiteboard.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.whiteboard.models.User;

@RestController
public class UserController {
  ArrayList<User> usersList = new ArrayList<User>();

  @GetMapping("/users/find")
  public ArrayList<User> findAllUsers() {
    return usersList;
  }

  @GetMapping("/users/find/{userId}")
  public User findUserById(@PathVariable("userId") long userId) {
    for (User user : usersList) {
      if(userId == user.getId()) {
        return user;
      }
    }
    return null;
  }

  @DeleteMapping("/users/{userId}")
  public ArrayList<User> deleteUser(@PathVariable("userId") long userId) {
    ArrayList<User> temp = new ArrayList<>();
    for (User user : usersList) {
      if(userId != user.getId()) {
        temp.add(user);
      }
    }
    usersList = temp;
    return usersList;
  }

  @PostMapping("/users/create")
  public List<User> createUser(@RequestBody User user) {
    usersList.add(user);
    return usersList;
  }

  @PutMapping("/users/put/{userId}")
  public List<User> editUser(@PathVariable("userId") long userId, @RequestBody User user) {
    ArrayList<User> temp = new ArrayList<>();
    for (User u : usersList) {
      if (userId == u.getId()) {
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
      }
      temp.add(u);
    }
    usersList = temp;
    return usersList;
  }


}
