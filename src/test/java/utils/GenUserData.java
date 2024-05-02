package utils;

import com.github.javafaker.Faker;


public class GenUserData {

    static Faker faker = new Faker();
    public static String getRandomFirstName () {
        return faker.name().firstName();
    }

    public static String getRandomLastName () {
        return faker.name().lastName();
    }

    public static String getRandomEmailAddress () {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return faker.number().digits(10);
    }

    public static String getRandomLoginName () { return faker.name().name();
    }

    public static String getRandomPassword () {
        return faker.number().digits(8);
    }

    public static String getRandomId () {
        return faker.number().digits(8);
    }

}
