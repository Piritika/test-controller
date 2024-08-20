package ru.tearose.test_controller.service.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tearose.test_controller.model.entity.User;
import ru.tearose.test_controller.repository.UsrRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements UserDomainService {

    private final UsrRepository repository;

    @Override
    public Optional<User> getUserById(Long userId) {
        log.info("start domain service getUserById");

        return repository.findById(userId);
    }

    @Override
    public User save(User user) {
        log.info("start domain service save");

        return repository.save(user);
    }

    @Override
    public boolean delete(Long userId) {
        log.info("start domain service delete");

        Optional<User> optionalUser = getUserById(userId);

        if (optionalUser.isEmpty()) {
            return false;
        }

        repository.delete(optionalUser.get());
        return true;
    }
}
