package steps;

import models.CreateUserResponseModel;
import models.GetUserInfoModel;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.lang.String.format;
import static specs.RequestSpec.*;

public class UserInfo {
    CreateUser createUser = new CreateUser();

    public Map<String, String> getUserInfo () {

        Map<String, String> values = createUser.createUser();

        String userName =  values.get("login");

        String requestEndPoint =  format("/user/%s",userName);

        GetUserInfoModel response = step("Отправляю запроса информации о пользователе", () ->
                given(requestSpec)
                        .when()
                        .get(requestEndPoint)
                        .then()
                        .spec(successfulResponseSpec)
                        .body(matchesJsonSchemaInClasspath("schemas/getUserInfoSchema.json"))
                        .extract().as(GetUserInfoModel.class)
        );

        values.put("responseId", response.getId());
        values.put("responseFirstName", response.getFirstName());
        values.put("responseLastName",response.getLastName());
        values.put("responseEmail",response.getEmail());
        values.put("responsePhone",response.getPhone());

        return values;
    }

    public String getErrorMessage (String userName) {

        String requestEndPoint =  format("/user/%s",userName);

        CreateUserResponseModel response = step("Отправляю запроса информации о пользователе", () ->
                given(requestSpec)
                        .when()
                        .get(requestEndPoint)
                        .then()
                        .spec(errorResponseSpec)
                        .extract().as(CreateUserResponseModel.class));

        return response.getMessage();
    }
}
