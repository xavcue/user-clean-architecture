package org.cat.user.clean.architecture.infrastructure.adapters.output;

import org.cat.user.clean.architecture.application.ports.output.UserPort;
import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.output.mapper.UserEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAdapter implements UserPort {

    private final UserEntityRepository repository;

    public UserAdapter(UserEntityRepository repository){
        this.repository = repository;
    }

    @Override
    public User create(User user) {
         UserEntity userEntity = repository.save(
                UserEntityMapper.INSTANCE.toUserEntity(user)
        );
        return UserEntityMapper.INSTANCE.toUser(userEntity);
    }

    public List<User> findAll(){
        List<UserEntity> userEntities = repository.findAll();
        return userEntities.stream()
                .map(UserEntityMapper.INSTANCE ::toUser)
                .toList();
    }

    @Override
    public List<User> filterByLastName(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserEntityMapper.INSTANCE::toUser)
                .toList();
    }
}
