package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CheckingCreateUser {

    CreateUser createUser = new CreateUser();

    public void checkCreateUser() {

        Map<String, String> values = createUser.createUser();

        String id = values.get("id");
        String code = values.get("code");
        String message = values.get("message");

        step("Проверить получения кода 200", () -> assertThat(code).isEqualTo("200"));
        step("Проверить получения идентификатора пользователя", () -> assertThat(message).isEqualTo(id));
    }
}
