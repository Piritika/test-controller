package ru.tearose.test_controller.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tearose.test_controller.exception.UserNotFoundException;
import ru.tearose.test_controller.mapper.UserMapper;
import ru.tearose.test_controller.model.dto.UserDto;
import ru.tearose.test_controller.model.entity.User;
import ru.tearose.test_controller.service.domain.UserDomainService;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDomainService domainService;
    private final UserMapper mapper;
    private final RestTemplateClient restTemplateClient;

    @Override
    public UserDto getUserByID(Long userId) {
        log.info("start getUserByID");

        Optional<User> optionalUser = domainService.getUserById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(String.format("User %s not found.", userId));
        }
        return mapper.mapToUserDto(optionalUser.get());
    }


    @Override
    public UserDto addNewUser(UserDto userDto) {
        log.info("start addNewUser");

        checkUser(userDto);

        User user = saveUser(userDto);

        return mapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateOldUser(UserDto userDto) {
        log.info("start updateOldUser");

        Optional<User> optionalUser = domainService.getUserById(userDto.getUserId());

        if (optionalUser.isEmpty()) {
            return addNewUser(userDto);
        }
        User user = optionalUser.get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());

        User entity = domainService.save(user);

        return mapper.mapToUserDto(entity);
    }

    @Override
    public void deleteOldUser(UserDto userDto) {
        log.info("start deleteOldUser");

        if (!domainService.delete(userDto.getUserId())) {
            throw new UserNotFoundException(String.format("User %s not found.", userDto));
        }
    }

    @Override
    public UserDto updateDetailsUser(Long userId, Integer age) {
        log.info("start updateDetailsUser");

        Optional<User> optionalUser = domainService.getUserById(userId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException(String.format("User %s not found.", userId));
        }
        User user = optionalUser.get();
        user.setAge(age);

        User entity = domainService.save(user);

        return mapper.mapToUserDto(entity);
    }

    private void checkUser(UserDto userDto) {
        log.info("start checkUser");

        restTemplateClient.sendPersonalData(mapper.mapToUserInfoDto(userDto));
    }

    private User saveUser(UserDto userDto) {
        log.info("start saveUser");

        User user = mapper.mapToUser(userDto);
        return domainService.save(user);
    }

}
