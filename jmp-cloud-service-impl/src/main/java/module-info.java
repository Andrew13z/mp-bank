module jmp.cloud.service.impl {
	uses com.example.cloud.service.impl.dao.UserDao;
	uses com.example.cloud.service.impl.dao.SubscriptionDao;

	requires transitive jmp.service.api;
	requires jmp.dto;
	requires lombok;

	exports com.example.cloud.service.impl;
}