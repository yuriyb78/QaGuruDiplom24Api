package steps;

import data.TestData;
import models.CreateUserModel;
import models.CreateUserResponseModel;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.RequestSpec.requestSpec;
import static specs.RequestSpec.successfulResponseSpec;

public class CreateUser {

    public Map<String, String> createUser () {

        TestData testData = new TestData();
        CreateUserModel userData = new CreateUserModel();
        Map<String, String> responseServer = new HashMap<>();

        step("Генерирую идентификатор пользователя", () -> userData.setId(testData.id));
        step("Генерирую логин пользователя", () -> userData.setUsername(testData.firstName));
        step("Генерирую имя пользователя", () -> userData.setFirstName(testData.firstName));
        step("Генерирую фамилию пользователя", () -> userData.setLastName(testData.lastName));
        step("Генерирую адрес электронной почты пользователя", () -> userData.setEmail(testData.emailAddress));
        step("Генерирую телефон пользователя", () -> userData.setPhone(testData.phoneNumber));
        step("Генерирую пароль пользователя", () -> userData.setPassword(testData.password));
        step("Устанавливаю статус пользователя", () -> userData.setUserStatus("0"));


        CreateUserResponseModel response = step("Отправка данных пользователя для регистрации", () ->
                given(requestSpec)
                        .body(userData)
                        .when()
                        .post("/user")
                        .then()
                        .spec(successfulResponseSpec)
                        .extract().as(CreateUserResponseModel.class)
        );

        responseServer.put("code",response.getCode());
        responseServer.put("message",response.getMessage());

        return responseServer;

    }
}
