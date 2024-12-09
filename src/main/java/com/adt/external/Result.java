package com.adt.external;

public sealed interface Result {
//    record Success(Map<String, List<String>> response) implements Result {}
    record Success<T>(T payload) implements Result {}
    record Failure(String error) implements Result {}
}
