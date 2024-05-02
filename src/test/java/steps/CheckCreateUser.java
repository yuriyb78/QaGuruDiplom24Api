package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CheckCreateUser {

    CreateUser createUser = new CreateUser();

    public void checkCreateUser () {

        Map<String, String> values = createUser.createUser();

        String code = values.get("code");
        String message =  values.get("message");

        step("Проверка получения кода 200", () -> assertThat(code, is("200")));
        step("Проверка получения идентификатора пользователя", () -> assertThat(message, is(notNullValue())));
    }
}
