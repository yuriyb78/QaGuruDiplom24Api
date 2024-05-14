package utils;

import com.github.javafaker.Faker;


public class GenUserData {

    static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmailAddress() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return faker.number().digits(10);
    }

    public static String getRandomLoginName() {
        return faker.name().username();
    }

    public static String getRandomPassword() {
        return faker.number().digits(8);
    }

    public static Integer getRandomId() {
        int min = 10000000;
        int max = 99999999;
        int randomId = faker.number().numberBetween(min, max);
        return randomId;
    }

}
