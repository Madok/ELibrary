package com.zpo.elibrary.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.zpo.elibrary.db.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    @Override
    public User createUser(final User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return cassandraTemplate.create(user);
    }

    @Override
    public User getUser(final Long id) {
        return cassandraTemplate.findById(id, User.class);
    }

    @Override
    public User updateUser(final User user) {
        return cassandraTemplate.update(user);
    }

    @Override
    public void deleteUser(final Long id) {
        cassandraTemplate.deleteById(id, User.class);
    }

    @Override
    public List<User> getAllUsers() {
        return cassandraTemplate.findAll(User.class);
    }

    @Override
    public User getUserByName(final String name) {
        return cassandraTemplate.findBy("name", name, User.class);
    }
}
