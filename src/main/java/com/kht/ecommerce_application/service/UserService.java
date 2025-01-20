package com.kht.ecommerce_application.service;

import com.kht.ecommerce_application.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void insertUser(User user);

    Boolean existByEmail(String email);

    User getUserId(int id);
}
