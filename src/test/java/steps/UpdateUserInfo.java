package steps;

import data.TestData;
import models.UserModel;
import models.CreateUserResponseModel;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static specs.RequestSpec.requestSpec;
import static specs.RequestSpec.successfulResponseSpec;

public class UpdateUserInfo {

    TestData testData = new TestData();
    UserModel userData = new UserModel();
    CreateUser createUser = new CreateUser();

    public Map<String, String> checkUpdateUserInfo () {

        Map<String, String> values = createUser.createUser();
        Map<String, String> responseServer = new HashMap<>();

        userData.setId(values.get("id"));
        userData.setUsername(values.get("login"));
        userData.setFirstName(values.get("firstName"));
        userData.setLastName(values.get("lastName"));
        userData.setPassword(values.get("password"));
        userData.setUserStatus(values.get("userStatus"));


        String requestEndPoint =  format("/user/%s",userData.getUsername());

        step("Генерирую новый адрес электронной почты пользователя", () -> userData.setEmail(testData.emailAddress));
        step("Генерирую новый телефон пользователя", () -> userData.setPhone(testData.phoneNumber));

        CreateUserResponseModel response = step("Отправляю обновленные данные пользователя", () ->
                given(requestSpec)
                        .body(userData)
                        .when()
                        .put(requestEndPoint)
                        .then()
                        .spec(successfulResponseSpec)
                        .extract().as(CreateUserResponseModel.class)
        );

        responseServer.put("id",values.get("id"));
        responseServer.put("code",response.getCode());
        responseServer.put("message",response.getMessage());

        return responseServer;

    }
}

