package com.zpo.elibrary.db.repository;

import java.util.List;

import com.zpo.elibrary.db.entity.User;

public interface UserRepository {

    User createUser(User user);

    User getUser(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getUserByName(String name);
}
