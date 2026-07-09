package org.cat.user.clean.architecture.infrastructure.adapters.input;

import org.cat.user.clean.architecture.application.ports.input.IUserUseCase;
import org.cat.user.clean.architecture.domain.model.User;
import org.cat.user.clean.architecture.infrastructure.adapters.input.dto.UserRequest;
import org.cat.user.clean.architecture.infrastructure.adapters.input.dto.UserResponse;
import org.cat.user.clean.architecture.infrastructure.adapters.input.mapper.UserRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final IUserUseCase userUseCase;

    public UserController(IUserUseCase userUseCase){
        this.userUseCase= userUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request){
        User user = userUseCase.create(
                UserRequestMapper.INSTANCE.toUser(request)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(UserRequestMapper.INSTANCE.toUserResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> filterByLastName(@RequestParam String lastName){
        List<User> users = userUseCase.filterByLastName(lastName);
        List<UserResponse> usersResponse = users.stream()
                .map(UserRequestMapper.INSTANCE::toUserResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(usersResponse);
    }
}
