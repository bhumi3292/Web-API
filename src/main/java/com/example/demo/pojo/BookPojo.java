package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookPojo {

    private Long id;

    @NotNull(message = "Book name is required field")
    private String bookName;
}