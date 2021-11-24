package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Subscription {

	private String bankCard;

	private LocalDate startDate;
}
