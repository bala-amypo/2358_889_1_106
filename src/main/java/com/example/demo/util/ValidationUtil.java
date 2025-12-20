package com.example.demo.util;

import java.time.LocalDateTime;

public class ValidationUtil {

    public static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
    }

    public static void validatePositive(Double value, String fieldName) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be positive");
        }
    }

    // Validate that a min < max
    public static void validateMinLessThanMax(Double min, Double max, String fieldName) {
        if (min == null || max == null || min >= max) {
            throw new IllegalArgumentException("Invalid " + fieldName + ": minvalue must be less than maxvalue");
        }
    }

    // Validate latitude
    public static void validateLatitude(Double latitude) {
        if (latitude == null || latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
    }

    // Validate longitude
    public static void validateLongitude(Double longitude) {
        if (longitude == null || longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Invalid longitude value");
        }
    }

    // Validate date is not in the past
    public static void validateNotPastDate(LocalDateTime dateTime, String fieldName) {
        if (dateTime == null) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(fieldName + " cannot be in the past");
        }
    }

    // Validate a boolean is true
    public static void validateTrue(Boolean condition, String message) {
        if (condition == null || !condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
