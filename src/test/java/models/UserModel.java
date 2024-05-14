package models;

import lombok.Data;

@Data
public class UserModel {

    String id, username, firstName, lastName, email, password, phone, userStatus;

}