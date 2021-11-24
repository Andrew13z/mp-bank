package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {

	private String name;

	private String surname;

	private LocalDate birthday;
}
