package com.adt.person;

public record Admin(int id, String name, String email, String permissions) implements Person {
}
