package com.atos.starter.services;

import com.atos.starter.dao.UserRepository;
import com.atos.starter.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepository user_repository;

    public List<User> findAll() {
        return (List<User>) user_repository.findAll();
    }

    public Optional<User> findById(String _id) {
        return user_repository.findById(_id);
    }

    public void deleteById(String _id) {
        user_repository.deleteById(_id);
    }

    public User add(User _user) {
        return user_repository.save(_user);
    }

    public User update(String _id_to_update, User _user) {
        return user_repository.findById(_id_to_update)
                .map(user -> {
                    user.setName(_user.getName());
                    user.setEmail(_user.getEmail());
                    user.setAvatar(_user.getAvatar());
                    return user_repository.save(user);
                })
                .orElseGet(() -> {
                    _user.setId(_id_to_update);
                    return user_repository.save(_user);
                });
    }



}
