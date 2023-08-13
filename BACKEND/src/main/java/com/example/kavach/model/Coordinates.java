package com.example.kavach.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coordinates")
@Getter
@Setter
@NoArgsConstructor
public class Coordinates {

    @NotBlank
    Float latitude;

    @NotBlank
    Float longitude;

}
