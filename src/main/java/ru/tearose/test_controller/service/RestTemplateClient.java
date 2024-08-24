package ru.tearose.test_controller.service;

import ru.tearose.test_controller.model.dto.UserInfoDto;

public interface RestTemplateClient {

    void sendPersonalData(UserInfoDto userInfoDto);
}
