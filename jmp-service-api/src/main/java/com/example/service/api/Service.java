package com.example.service.api;

import com.example.dto.BankCard;
import com.example.dto.Subscription;
import com.example.dto.User;

import java.util.List;
import java.util.Optional;

public interface Service {

	void subscribe(BankCard card);

	Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

	List<User> getAllUsers();
}
