package data;

import utils.GenUserData;

public class TestData {

    public String firstName = GenUserData.getRandomFirstName(),
            lastName = GenUserData.getRandomLastName(),
            emailAddress = GenUserData.getRandomEmailAddress(),
            genderValue = GenUserData.getRandomGenderValue(),
            phoneNumber = GenUserData.getRandomPhoneNumber(),
            dayOfBirthDay = String.valueOf(GenUserData.getRandomDayOfBirthDay()),
            monthOfBirthDay = GenUserData.getRandomMonthOfBirthDay(dayOfBirthDay),
            yearOfBirthDay = String.valueOf(GenUserData.getRandomYearOfBirthDay()),
            subjectChar = GenUserData.getRandomGetRandomSubject(),
            hobbieValue = GenUserData.getRandomHobbies(),
            namePicture = "01.jpg",
            fullAddress = GenUserData.getRandomFullAddress(),
            nameState = GenUserData.getRandomNameState(),
            nameCity = GenUserData.getRandomNameCity(nameState);
}
