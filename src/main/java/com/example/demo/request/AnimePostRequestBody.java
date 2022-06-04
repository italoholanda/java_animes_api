package com.example.demo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {
    @NotNull
    @NotEmpty(message = "Name field cannot be empty")
    private String name;
}
