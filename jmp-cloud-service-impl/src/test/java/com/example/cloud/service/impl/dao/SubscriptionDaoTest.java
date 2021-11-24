package com.example.cloud.service.impl.dao;

import com.example.cloud.service.impl.dao.impl.MemorySubscriptionDaoImpl;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubscriptionDaoTest {

	private static final String CARD_NUMBER1 = "0123456789012345";
	private static final String CARD_NUMBER2 = "9876543210987654";
	private final SubscriptionDao dao = new MemorySubscriptionDaoImpl();

	@Test
	public void subscribeTest_withNewCardNumber() {
		dao.subscribe(CARD_NUMBER1);

		var subscriptions = dao.getAllSubscriptions();
		assertEquals(1, subscriptions.size());
		assertEquals(CARD_NUMBER1, subscriptions.get(0).getBankCard());
	}

	@Test
	public void subscribeTest_withExistingCardNumber() {
		dao.subscribe(CARD_NUMBER1);

		var subscriptionsBefore = dao.getAllSubscriptions();
		assertEquals(1, subscriptionsBefore.size());
		assertEquals(CARD_NUMBER1, subscriptionsBefore.get(0).getBankCard());

		dao.subscribe(CARD_NUMBER1);

		var subscriptionsAfter = dao.getAllSubscriptions();
		assertEquals(1, subscriptionsAfter.size());
		assertEquals(CARD_NUMBER1, subscriptionsAfter.get(0).getBankCard());

	}

	@Test
	public void getSubscriptionByBankCardNumber_withExistingNumber() {
		dao.subscribe(CARD_NUMBER1);
		var optionalSubscription = dao.getSubscriptionByBankCardNumber(CARD_NUMBER1);
		assertNotNull(optionalSubscription.get());
	}

	@Test(expected = NoSuchElementException.class)
	public void getSubscriptionByBankCardNumber_withNonExistingNumber() {
		dao.subscribe(CARD_NUMBER1);
		var optionalSubscription = dao.getSubscriptionByBankCardNumber(CARD_NUMBER2);
		optionalSubscription.get();
	}

	@Test
	public void getAllSubscriptionsTest() {
		dao.subscribe(CARD_NUMBER1);
		dao.subscribe(CARD_NUMBER2);

		assertEquals(CARD_NUMBER1, dao.getAllSubscriptions().get(0).getBankCard());
		assertEquals(CARD_NUMBER2, dao.getAllSubscriptions().get(1).getBankCard());
	}
}
