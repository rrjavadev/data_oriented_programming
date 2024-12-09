package com.adt.person;

public class PersonManagementService {

    public String getPersonInfo(Person person) {

       return switch (person){
            case User user -> "The user name is %s".formatted(user.name());
            case Admin admin -> "The admin name is %s".formatted(admin.name());
        };
    }

    public Person updateEmailAddress(Person person, String email) {

        return switch (person){
            case User user -> new User(user.id(), user.name(), email);
            case Admin admin -> new Admin(admin.id(), admin.name(), email, admin.permissions());
        };
    }
}
