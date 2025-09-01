package com.example.Day12_Form.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotEmpty
    @Size(min = 3)
    private String surname;

    @NotEmpty
    @Email
    private String email;

    @Min(3)
    private int age;
}
