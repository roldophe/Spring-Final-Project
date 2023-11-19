package dev.radom.restaurant.api.user.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record UserDto(String uuid,
                      String username,
                      String email,
                      String avatar,
                      LocalDateTime creationAt,
                      LocalDateTime updatedAt,
                      List<String> roles) {
}
