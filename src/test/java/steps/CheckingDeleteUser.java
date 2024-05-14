package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckingDeleteUser {

    DeleteUser deleteUser = new DeleteUser();
    CheckingUserInfo checkingUserInfo = new CheckingUserInfo();

    public void checkDeleteUser() {

        Map<String, String> values = deleteUser.deleteUser();

        String userName = values.get("userName");
        String code = values.get("code");
        String message = values.get("message");

        step("Проверить получение кода 200", () -> assertThat(code).isEqualTo("200"));
        step("Проверить получение идентификатора пользователя", () -> assertThat(message).isEqualTo(userName));

        checkingUserInfo.checkErrorMessage(userName);
    }
}
