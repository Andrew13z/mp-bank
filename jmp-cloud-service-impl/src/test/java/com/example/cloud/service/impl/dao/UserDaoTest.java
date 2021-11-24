package com.example.cloud.service.impl.dao;

import com.example.cloud.service.impl.dao.impl.MemoryUserDaoImpl;
import com.example.dto.User;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {

	private static final String NAME = "Name";
	private static final String SURNAME = "Surname";
	private static final LocalDate BIRTHDAY = LocalDate.now();

	private final UserDao dao = new MemoryUserDaoImpl();//TODO

	@Test
	public void addUserTest() {
		dao.addUser(createUser(NAME, SURNAME, BIRTHDAY));
		assertEquals(NAME, dao.getAllUsers().get(0).getName());
	}

	@Test
	public void getAllUsersTest() {
		dao.addUser(createUser(NAME, SURNAME, BIRTHDAY));
		dao.addUser(createUser("Name2", "Surname2", BIRTHDAY));
		var allUsers = dao.getAllUsers();

		assertEquals(2, allUsers.size());
		assertEquals(NAME, allUsers.get(0).getName());
		assertEquals("Name2", allUsers.get(1).getName());
	}

	private User createUser(String name, String surname, LocalDate birthday) {
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setBirthday(birthday);
		return user;
	}

}
