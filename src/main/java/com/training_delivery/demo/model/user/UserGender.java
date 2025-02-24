package com.training_delivery.demo.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserGender {
    MALE(1),
    FEMALE(2);

    private final int number;

    public static UserGender fromNumber(int number) {
        for (UserGender gender : values()) {
            if (gender.getNumber() == number) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid number: " + number);
    }
}
