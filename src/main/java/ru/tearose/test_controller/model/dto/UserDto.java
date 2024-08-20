package ru.tearose.test_controller.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {

    private Long userId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Integer age;

}
