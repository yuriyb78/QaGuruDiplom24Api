package models;

import lombok.Data;

@Data
public class CreateUserModel {

    String id, username, firstName, lastName, email, password, phone, userStatus;

}