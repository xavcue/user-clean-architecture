package org.cat.user.clean.architecture.application.ports.output;

import org.cat.user.clean.architecture.domain.model.User;

import java.util.List;

public interface UserPort {

    User create(User user);
    List<User> findAll();
    List<User> filterByLastName(String lastName);
}
