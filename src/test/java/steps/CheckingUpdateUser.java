package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CheckingUpdateUser {

    UpdateUserInfo updateUserInfo = new UpdateUserInfo();

    public void checkUpdateUserInfo() {

        Map<String, String> values = updateUserInfo.checkUpdateUserInfo();

        String id = values.get("id");
        String code = values.get("code");
        String message = values.get("message");

        step("Проверить получения кода 200", () -> assertThat(code).isEqualTo("200"));
        step("Проверить получения идентификатора пользователя", () -> assertThat(message).isEqualTo(id));
    }
}
