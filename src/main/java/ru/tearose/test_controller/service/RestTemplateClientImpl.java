package ru.tearose.test_controller.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.tearose.test_controller.exception.IncorrectUserDataException;
import ru.tearose.test_controller.exception.InternalServiceException;
import ru.tearose.test_controller.model.dto.UserInfoDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestTemplateClientImpl implements RestTemplateClient {

    private final RestTemplate restTemplateHttpClient;

    @Override
    public void sendPersonalData(UserInfoDto userInfoDto) {
        try {
            restTemplateHttpClient
                    .postForEntity("http://localhost:8082/personal-data/check", userInfoDto, Void.class);
        } catch (HttpClientErrorException e) {
            throw new IncorrectUserDataException(e.getResponseBodyAsString());
        } catch (Exception e) {
            throw new InternalServiceException();
        }
    }
}
