
package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

    private Long id;

    @NotNull(message = "Username is required field")
    private String username;
}
