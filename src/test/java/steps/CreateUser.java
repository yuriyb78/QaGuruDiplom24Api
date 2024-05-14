package steps;

import data.TestData;
import models.UserModel;
import models.CreateUserResponseModel;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.RequestSpec.*;

public class CreateUser {

    TestData testData = new TestData();
    UserModel userData = new UserModel();

    public Map<String, String> createUser() {

        Map<String, String> responseServer = new HashMap<>();

        step("Сгенерировать идентификатор пользователя", () -> userData.setId(testData.id));
        step("Сгенерировать логин пользователя", () -> userData.setUsername(testData.loginName));
        step("Сгенерировать имя пользователя", () -> userData.setFirstName(testData.firstName));
        step("Сгенерировать фамилию пользователя", () -> userData.setLastName(testData.lastName));
        step("Сгенерировать адрес электронной почты пользователя", () -> userData.setEmail(testData.emailAddress));
        step("Сгенерировать телефон пользователя", () -> userData.setPhone(testData.phoneNumber));
        step("Сгенерировать пароль пользователя", () -> userData.setPassword(testData.password));
        step("Установить статус пользователя", () -> userData.setUserStatus("0"));


        CreateUserResponseModel response = step("Отправить данные пользователя для регистрации", () ->
                given(requestSpec)
                        .body(userData)
                        .when()
                        .post("/user")
                        .then()
                        .spec(successfulResponseCode200Spec)
                        .extract().as(CreateUserResponseModel.class)
        );

        responseServer.put("id", userData.getId());
        responseServer.put("login", userData.getUsername());
        responseServer.put("firstName", userData.getFirstName());
        responseServer.put("lastName", userData.getLastName());
        responseServer.put("email", userData.getEmail());
        responseServer.put("phone", userData.getPhone());
        responseServer.put("password", userData.getPassword());
        responseServer.put("userStatus", userData.getUserStatus());

        responseServer.put("code", response.getCode());
        responseServer.put("message", response.getMessage());

        return responseServer;

    }
}
