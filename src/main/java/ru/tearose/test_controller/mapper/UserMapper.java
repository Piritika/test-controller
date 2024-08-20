package ru.tearose.test_controller.mapper;

import ru.tearose.test_controller.model.dto.UserDto;
import ru.tearose.test_controller.model.entity.User;

public interface UserMapper {

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
