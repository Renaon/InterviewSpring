package com.geekbrains.Interview.dto;

import lombok.Data;

@Data
public class StudentDTO implements CommonDTO{
    private final Long id;
    private final String name;
    private final Integer mark;
}
