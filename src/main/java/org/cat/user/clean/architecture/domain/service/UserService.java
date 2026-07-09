package org.cat.user.clean.architecture.domain.service;

import org.cat.user.clean.architecture.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> filterByLastName(List <User> users, String lastName){
        return users.stream()
                .filter(user -> user.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }
}
