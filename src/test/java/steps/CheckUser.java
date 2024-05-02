package steps;

import models.GetUserInfoModel;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static specs.RequestSpec.requestSpec;
import static specs.RequestSpec.successfulResponseSpec;

public class CheckUser {
    CreateUser createUser = new CreateUser();

    public void getUserInfo () {

        Map<String, String> values = createUser.createUser();

        String id = values.get("id"),
             userName =  values.get("login"),
             firstName = values.get("firstName"),
             lastName = values.get("lastName"),
             email =  values.get("email"),
             phone = values.get("phone");

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

        step("Проверяю идентификатор пользователя", () -> assertThat(response.getId(), is(id)));
        step("Проверяю имя пользователя", () -> assertThat(response.getFirstName(), is(firstName)));
        step("Проверяю фамилию пользователя", () -> assertThat(response.getLastName(), is(lastName)));
        step("Проверяю электронную почту пользователя", () -> assertThat(response.getEmail(), is(email)));
        step("Проверяю номер телефона пользователя", () -> assertThat(response.getPhone(), is(phone)));
    }
}
