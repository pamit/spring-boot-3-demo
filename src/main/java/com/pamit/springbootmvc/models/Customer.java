package com.pamit.springbootmvc.models;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "must be valid")
    private String firstName = "";

    @NotNull(message = "is required")
    @Size(min = 1, message = "must be valid")
    private String lastName = "";

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;
}
