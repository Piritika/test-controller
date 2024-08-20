package ru.tearose.test_controller.mapper;

import org.springframework.stereotype.Component;
import ru.tearose.test_controller.model.dto.UserDto;
import ru.tearose.test_controller.model.entity.User;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto mapToUserDto(User user) {

        return new UserDto()
                .setUserId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAge(user.getAge());
    }

    @Override
    public User mapToUser(UserDto userDto) {

        return new User()
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setAge(userDto.getAge());
    }
}
