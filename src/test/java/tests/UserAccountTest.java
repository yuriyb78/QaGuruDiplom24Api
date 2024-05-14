package tests;


import config.LoginConfig;
import io.qameta.allure.Feature;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.*;

@Feature("Тесты для API на сайте https://petstore.swagger.io/")
public class UserAccountTest extends BaseTest {

    CheckingUserInfo checkingUserInfo = new CheckingUserInfo();
    LoginConfig loginConfig = ConfigFactory.create(LoginConfig.class);

    @Test
    @DisplayName("Проверка успешного создания пользователя")
    @Tag("CreateUser")
    void checkCreateUserTest() {
        new CheckingCreateUser().checkCreateUser();

    }

    @Test
    @DisplayName("Проверка получения информации о пользователе")
    @Tag("CheckUserInfo")
    void checkGetUserInfoTest() {
        checkingUserInfo.checkUserInfo();

    }

    @Test
    @DisplayName("Проверка обновления информации о пользователе")
    @Tag("UpdateUserInfo")
    void checkUpdateUserInfo() {
        new CheckingUpdateUser().checkUpdateUserInfo();

    }

    @Test
    @DisplayName("Проверка удаления пользователя")
    @Tag("DeleteUser")
    void checkDeleteUser() {
        new CheckingDeleteUser().checkDeleteUser();

    }

    @Test
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Негативный тест. Проверка сообщения об ошибке при поиске несуществующего пользователя")
    @Tag("CheckErrorMessage")
    void checkMessageUserNotFound() {
        checkingUserInfo.checkErrorMessage(loginConfig.userName());

    }

}
