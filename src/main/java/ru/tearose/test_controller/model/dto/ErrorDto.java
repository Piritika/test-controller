package ru.tearose.test_controller.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ErrorDto {

    private String errorMessage;
}
