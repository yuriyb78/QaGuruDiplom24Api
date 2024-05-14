package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CheckingUserInfo {

    UserInfo userInfo = new UserInfo();

    public void checkUserInfo() {

        Map<String, String> values = userInfo.getUserInfo();

        step("Проверить идентификатор пользователя", () -> assertThat(values.get("responseId")).isEqualTo(values.get("id")));
        step("Проверить имя пользователя", () -> assertThat(values.get("responseFirstName")).isEqualTo(values.get("firstName")));
        step("Проверить фамилию пользователя", () -> assertThat(values.get("responseLastName")).isEqualTo(values.get("lastName")));
        step("Проверить электронную почту пользователя", () -> assertThat(values.get("responseEmail")).isEqualTo(values.get("email")));
        step("Проверить номер телефона пользователя", () -> assertThat(values.get("responsePhone")).isEqualTo(values.get("phone")));
    }

    public void checkErrorMessage(String userName) {
        step("Проверить сообщение об ошибке 'User not Found'",
                () -> assertThat(userInfo.getErrorMessage(userName)).isEqualTo("User not found"));
    }
}
