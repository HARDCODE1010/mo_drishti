package com.example.kavach.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "admin_input")
@Getter
@Setter
@NoArgsConstructor
public class SiteLocation{
    @Id
    String id;

    List<Coordinates> coordinatesList;
}
