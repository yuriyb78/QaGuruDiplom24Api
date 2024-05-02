package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckUpdateUser {

    UpdateUserInfo updateUserInfo = new UpdateUserInfo();

    public void checkUpdateUserInfo () {

        Map<String, String> values = updateUserInfo.checkUpdateUserInfo();

        String id = values.get("id");
        String code = values.get("code");
        String message =  values.get("message");

        step("Проверка получения кода 200", () -> assertThat(code, is("200")));
        step("Проверка получения идентификатора пользователя", () -> assertThat(message, is(id)));
    }
}
