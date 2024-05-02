package data;

import utils.GenUserData;

public class TestData {

    public String firstName = GenUserData.getRandomFirstName(),
            lastName = GenUserData.getRandomLastName(),
            emailAddress = GenUserData.getRandomEmailAddress(),
            phoneNumber = GenUserData.getRandomPhoneNumber(),
            loginName = GenUserData.getRandomLoginName(),
            password = GenUserData.getRandomPassword(),
            id = GenUserData.getRandomId().toString();

}
