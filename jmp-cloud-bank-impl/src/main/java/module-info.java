module jmp.cloud.bank.impl {
	requires transitive jmp.bank.api;
	requires jmp.dto;

	uses com.example.bank.api.Bank;

	exports com.example.cloud.bank.impl;
}