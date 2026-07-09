package org.cat.user.clean.architecture.infrastructure.adapters.input.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String firstName;
    private String lastName;
}
