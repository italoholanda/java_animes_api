package com.example.demo.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AnimePostRequestBody {
    @NotNull
    @NotEmpty(message = "Name field cannot be empty")
    private String name;
}
