package models;

import lombok.Data;

@Data
public class GetUserInfoModel {

    String id, username, firstName, lastName, email, password, phone, userStatus;

}