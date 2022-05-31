package com.example.demo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "Name field cannot be empty")
    private String name;
}
