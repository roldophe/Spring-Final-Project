package dev.radom.restaurant.api.payment.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record InvoiceRequest(@NotBlank
                             @NotNull
                             String paymentMethod,
                             BigDecimal other,
                             @Min(value = 0, message = "Discount percentage must be greater than or equal to 0")
                             @Max(value = 100, message = "Discount percentage must be less than or equal to 100")
                             @Digits(integer = 3, fraction = 0, message = "Discount percentage must be a whole number with up to 3 digits")
                             Integer discPct,
                             @NotBlank
                             @NotNull
                             String status) {
}
