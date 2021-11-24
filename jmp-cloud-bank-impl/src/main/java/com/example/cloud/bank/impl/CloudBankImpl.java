package com.example.cloud.bank.impl;

import com.example.bank.api.Bank;
import com.example.dto.BankCard;
import com.example.dto.BankCardType;
import com.example.dto.CreditBankCard;
import com.example.dto.DebitBankCard;
import com.example.dto.User;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class CloudBankImpl implements Bank {

	@Override
	public BankCard createBankCard(User user, BankCardType cardType) {
		BankCard card = createEmptyBankCardFotType(cardType)
				.orElseThrow(() -> new IllegalArgumentException("Invalid card type provided."));
		card.setNumber(generateCardNumber());
		card.setUser(user);
		return card;
	}

	private Optional<BankCard> createEmptyBankCardFotType(BankCardType cardType) {
		BankCard card = null;
		if (BankCardType.DEBIT.equals(cardType)) {
			card = new DebitBankCard();
		} else if (BankCardType.CREDIT.equals(cardType)) {
			card = new CreditBankCard();
		}
		return Optional.ofNullable(card);
	}

	private String generateCardNumber() {
		StringBuilder cardNumber = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			cardNumber.append(ThreadLocalRandom.current().nextInt(10));
		}
		return cardNumber.toString();
	}

}
