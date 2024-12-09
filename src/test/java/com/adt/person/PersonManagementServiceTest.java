package com.adt.person;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonManagementServiceTest {

    private PersonManagementService personManagementService;

    @BeforeEach
    public void setUp() {
        personManagementService = new PersonManagementService();
    }

    @Test
    public void getPersonInfoShouldReturnAUser() {

        //Given
        Person user = new User(1, "Jon Doe", "jon.doe@whatever.com");

        //When
        String personInfo = personManagementService.getPersonInfo(user);

        //Then
        assertEquals("The user name is Jon Doe", personInfo);
    }

    @Test
    public void getPersonInfoShouldReturnAnUserAdmin() {

        //Given
        Person admin = new Admin(1, "Jane Doe", "jane.doe@whatever.com", "ADMIN");

        //When
        String personInfo = personManagementService.getPersonInfo(admin);

        //Then
        assertEquals("The admin name is Jane Doe", personInfo);
    }

    @Test
    public void shouldUpdateEmailAddressForAnAdmin() {

        //Given
        Person admin = new Admin(1, "Jane Doe", "jane.doe@whatever.com", "ADMIN");

        //When
        Person adminPerson = personManagementService.updateEmailAddress(admin, "new.email@whatever.com");

        //Then
        assertEquals(Admin.class, adminPerson.getClass());
        assertEquals("new.email@whatever.com", ((Admin) adminPerson).email());
    }

    @Test
    public void shouldUpdateEmailAddressForAUser() {

        //Given
        Person user = new User(1, "Jane Doe", "jon.doe@whatever.com");

        //When
        Person adminPerson = personManagementService.updateEmailAddress(user, "new.email@whatever.com");

        //Then
        assertEquals(User.class, adminPerson.getClass());
        assertEquals("new.email@whatever.com", ((User) adminPerson).email());
    }
}