package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckDeleteUser {

    DeleteUser deleteUser = new DeleteUser();
    UserInfo userInfo = new UserInfo();

    public void checkDeleteUser () {

        Map<String, String> values = deleteUser.deleteUser();

        String userName = values.get("userName");
        String code = values.get("code");
        String message =  values.get("message");

        step("Проверка получения кода 200", () -> assertThat(code, is("200")));
        step("Проверка получения идентификатора пользователя", () -> assertThat(message, is(userName)));

        userInfo.getErrorMessage(userName);
    }
}
