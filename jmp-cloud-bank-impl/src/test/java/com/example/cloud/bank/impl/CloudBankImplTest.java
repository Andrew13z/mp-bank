package com.example.cloud.bank.impl;

import com.example.bank.api.Bank;
import com.example.dto.BankCard;
import com.example.dto.BankCardType;
import com.example.dto.CreditBankCard;
import com.example.dto.DebitBankCard;
import com.example.dto.User;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class CloudBankImplTest {

	private static final String USER_NAME = "Name";
	private static final String USER_SURNAME = "Surname";
	private static final LocalDate USER_BIRTHDAY = LocalDate.now();
	public static final int CARD_NUMBER_LENGTH = 16;

	private Bank bank = new CloudBankImpl();//todo

	@Test
	public void testCreateBankCard_withDebitCardType() {
		BankCard card = bank.createBankCard(createUser(), BankCardType.DEBIT);

		assertEquals(DebitBankCard.class, card.getClass());
		assertEquals(USER_NAME, card.getUser().getName());
		assertEquals(CARD_NUMBER_LENGTH, card.getNumber().length());
	}

	@Test
	public void testCreateBankCard_withCreditCardType() {
		BankCard card = bank.createBankCard(createUser(), BankCardType.CREDIT);

		assertEquals(CreditBankCard.class, card.getClass());
		assertEquals(USER_NAME, card.getUser().getName());
		assertEquals(CARD_NUMBER_LENGTH, card.getNumber().length());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateBankCard_withInvalidCardType() {
		BankCard card = bank.createBankCard(createUser(), null);
	}

	private User createUser() {
		User user = new User();
		user.setName(USER_NAME);
		user.setSurname(USER_SURNAME);
		user.setBirthday(USER_BIRTHDAY);

		return user;
	}

}
