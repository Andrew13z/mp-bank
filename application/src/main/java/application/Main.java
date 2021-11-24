package src.main.java.com.example.application;

import com.example.bank.api.Bank;
import com.example.service.api.Service;

import java.util.ServiceLoader;

public class Main {

	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Main.class.getName());

	private static Bank bank;

	private static Service service;

	static {
		initServices();
	}

	public static void main(String[] args) {

	}

	private static void initServices() {
		var bankServiceLoader = ServiceLoader.load(Bank.class);
		log.info("Bank is present: " + bankServiceLoader.findFirst().isPresent());
		bank = bankServiceLoader.findFirst().orElseThrow();

		var serviceServiceLoader = ServiceLoader.load(Service.class);
		log.info("Service is present: " + serviceServiceLoader.findFirst().isPresent());
		service = serviceServiceLoader.findFirst().orElseThrow();
	}

	private static void generateData() {

	}
}
