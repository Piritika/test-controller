package ru.tearose.test_controller.service.domain;

import ru.tearose.test_controller.model.entity.User;

import java.util.Optional;

public interface UserDomainService {

    User save(User user);

    boolean delete(Long userId);

    Optional<User> getUserById(Long userId);
}
