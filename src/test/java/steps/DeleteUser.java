package steps;

import models.CreateUserResponseModel;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static specs.RequestSpec.requestSpec;
import static specs.RequestSpec.successfulResponseSpec;

public class DeleteUser {

    CreateUser createUser = new CreateUser();

    public Map<String, String> deleteUser () {

        Map<String, String> values = createUser.createUser();
        Map<String, String> responseServer = new HashMap<>();

        String userName = values.get("login");

        String requestEndPoint = format("/user/%s", userName);

        CreateUserResponseModel response = step("Отправляю запрос об удалении пользователя", () ->
                given(requestSpec)
                        .when()
                        .delete(requestEndPoint)
                        .then()
                        .spec(successfulResponseSpec)
                        .extract().as(CreateUserResponseModel.class)
        );

        responseServer.put("userName",userName);
        responseServer.put("code",response.getCode());
        responseServer.put("message",response.getMessage());

        return responseServer;
    }
}
