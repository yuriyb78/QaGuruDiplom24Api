package steps;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckUserInfo {

    UserInfo userInfo = new UserInfo();

    public void checkUserInfo () {

        Map<String, String> values = userInfo.getUserInfo();

        step("Проверяю идентификатор пользователя", () -> assertThat(values.get("responseId"), is(values.get("id"))));
        step("Проверяю имя пользователя", () -> assertThat(values.get("responseFirstName"), is(values.get("firstName"))));
        step("Проверяю фамилию пользователя", () -> assertThat(values.get("responseLastName"), is(values.get("lastName"))));
        step("Проверяю электронную почту пользователя", () -> assertThat(values.get("responseEmail"), is(values.get("email"))));
        step("Проверяю номер телефона пользователя", () -> assertThat(values.get("responsePhone"), is(values.get("phone"))));
    }

    public void checkErrorMessage (String userName) {
        step("Проверяю сообщение об ошибке 'User not Found'",
                () -> assertThat(userInfo.getErrorMessage(userName), is("User not found")));
    }
}
