package com.example.kavach.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "personnel")
@Getter
@Setter
@NoArgsConstructor
public class Personnel {
    @Id
    public String id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @UniqueElements
    private String phone;

    private String profilePic;

    private LocalDateTime joining;

    @NotBlank
    private String position;

    @NotBlank
    private boolean available;
}