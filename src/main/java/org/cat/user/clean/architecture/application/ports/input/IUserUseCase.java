package org.cat.user.clean.architecture.application.ports.input;

import org.cat.user.clean.architecture.domain.model.User;

import java.util.List;

public interface IUserUseCase {
    User create (User user);

    List<User> filterByLastName(String lastName);
}
