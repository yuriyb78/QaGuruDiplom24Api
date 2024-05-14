package steps;

import models.CreateUserResponseModel;
import models.UserModel;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.lang.String.format;
import static specs.RequestSpec.*;

public class UserInfo {
    CreateUser createUser = new CreateUser();

    public Map<String, String> getUserInfo() {

        Map<String, String> values = createUser.createUser();

        String userName = values.get("login");

        String requestEndPoint = format("/user/%s", userName);

        UserModel response = step("Отправить запрос информации о пользователе", () ->
                given(requestSpec)
                        .when()
                        .get(requestEndPoint)
                        .then()
                        .spec(successfulResponseCode200Spec)
                        .body(matchesJsonSchemaInClasspath("schemas/getUserInfoSchema.json"))
                        .extract().as(UserModel.class)
        );

        values.put("responseId", response.getId());
        values.put("responseFirstName", response.getFirstName());
        values.put("responseLastName", response.getLastName());
        values.put("responseEmail", response.getEmail());
        values.put("responsePhone", response.getPhone());

        return values;
    }

    public String getErrorMessage(String userName) {

        String requestEndPoint = format("/user/%s", userName);

        CreateUserResponseModel response = step("Отправить запрос информации о пользователе", () ->
                given(requestSpec)
                        .when()
                        .get(requestEndPoint)
                        .then()
                        .spec(errorResponseCode404Spec)
                        .extract().as(CreateUserResponseModel.class));

        return response.getMessage();
    }
}
