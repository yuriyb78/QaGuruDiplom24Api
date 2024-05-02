package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckCreateUser {

    CreateUser createUser = new CreateUser();

    public void checkCreateUser () {

        Map<String, String> values = createUser.createUser();

        String id = values.get("id");
        String code = values.get("code");
        String message =  values.get("message");

        step("Проверка получения кода 200", () -> assertThat(code, is("200")));
        step("Проверка получения идентификатора пользователя", () -> assertThat(message, is(id)));
    }
}
