package com.adt.person;

public record User(int id, String name, String email) implements Person {
}
