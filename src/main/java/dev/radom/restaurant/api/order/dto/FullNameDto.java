package dev.radom.restaurant.api.order.dto;

public record FullNameDto(String fist, String last) {
    public String getFullName() {
        return fist + " " + last;
    }
}
