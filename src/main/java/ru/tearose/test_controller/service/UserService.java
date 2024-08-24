package ru.tearose.test_controller.service;

import ru.tearose.test_controller.model.dto.UserDto;

public interface UserService {

    UserDto addNewUser(UserDto userDto);

    UserDto updateOldUser(UserDto userDto);

    void deleteOldUser(UserDto userDto);

    UserDto updateDetailsUser(Long userId, Integer age);

    UserDto getUserByID(Long userId);
}
