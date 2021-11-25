package com.example.service.api;

import com.example.dto.BankCard;
import com.example.dto.Subscription;
import com.example.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface Service {

	void subscribe(BankCard card);

	Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

	List<Subscription> getAllSubscriptions();

	List<User> getAllUsers();

	void addUser(User user);

	default double getAverageUserAge() {
		return getAllUsers().stream()
				.mapToLong(Service::getAge)
				.average()
				.orElse(0);
	}

	static boolean isPayableUser(User user){
		return Double.compare(getAge(user), 18) >= 0;
	}

	private static long getAge(User user) {
		return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now());
	}


}
