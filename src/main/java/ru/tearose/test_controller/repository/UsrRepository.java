package ru.tearose.test_controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tearose.test_controller.model.entity.User;

public interface UsrRepository extends JpaRepository<User, Long> {
}
