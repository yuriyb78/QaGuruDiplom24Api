package tests;


import io.qameta.allure.Feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.CheckCreateUser;


public class UserAccountTest extends BaseTest {

    @Test
    @Tag("User tests")
    @Feature("Тесты для API на сайте https://petstore.swagger.io/")
    @DisplayName("Проверка успешного создания пользователя")
    void successfulCreateUser2Test () {
        new CheckCreateUser().checkCreateUser();

    }


}
