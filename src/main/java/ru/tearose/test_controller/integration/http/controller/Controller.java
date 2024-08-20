package ru.tearose.test_controller.integration.http.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tearose.test_controller.model.dto.UserDto;
import ru.tearose.test_controller.service.UserService;

import static ru.tearose.test_controller.Utils.Constant.HEADER_REQUEST_ID;
import static ru.tearose.test_controller.Utils.Constant.REQUEST_ID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService service;

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<UserDto> getUser(@RequestHeader(name = HEADER_REQUEST_ID) String requestId,
                                           @PathVariable Long userId) {
        log.info("start getUser. UserId = {}", userId);
        log.info("HEADER_REQUEST_ID: {}", requestId);

        MDC.put(REQUEST_ID, requestId);

        UserDto userDto = service.getUserByID(userId);

        log.info("response User: {}", userDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@RequestHeader(name = HEADER_REQUEST_ID) String requestId,
                                           @Valid @RequestBody UserDto userDto) {
        log.info("start addUser");
        log.info("HEADER_REQUEST_ID: {}", requestId);

        MDC.put(REQUEST_ID, requestId);

        UserDto resultUserDto = service.addNewUser(userDto);

        return new ResponseEntity<>(resultUserDto, HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<UserDto> updateUser(@RequestHeader(name = HEADER_REQUEST_ID) String requestId,
                                              @Valid @RequestBody UserDto userDto) {
        log.info("start updateUser");
        log.info("HEADER_REQUEST_ID: {}", requestId);

        MDC.put(REQUEST_ID, requestId);

        UserDto resultUserDto = service.updateOldUser(userDto);

        return new ResponseEntity<>(resultUserDto, HttpStatus.OK);
    }

    @PatchMapping(value = "/user/{userId}")
    public ResponseEntity<UserDto> updateDetailsUser(@RequestHeader(name = HEADER_REQUEST_ID) String requestId,
                                                     @PathVariable Long userId,
                                                     @RequestParam Integer age) {
        log.info("start getUser. UserId = {}", userId);
        log.info("HEADER_REQUEST_ID: {}", requestId);

        MDC.put(REQUEST_ID, requestId);

        UserDto resultUserDto = service.updateDetailsUser(userId, age);

        return new ResponseEntity<>(resultUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser(@RequestHeader(name = HEADER_REQUEST_ID) String requestId,
                                           @Valid @RequestBody UserDto userDto) {
        log.info("start deleteUser");
        log.info("HEADER_REQUEST_ID: {}", requestId);

        MDC.put(REQUEST_ID, requestId);

        service.deleteOldUser(userDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

