package ru.tearose.test_controller.service.domain;

import ru.tearose.test_controller.model.entity.User;

import java.util.Optional;

public interface UserDomainService {

    Optional<User> getUserById(Long userId);

    User save(User user);

    boolean delete (Long userId);
}
