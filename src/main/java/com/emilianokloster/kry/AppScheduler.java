package com.emilianokloster.kry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.emilianokloster.kry.domain.ApiPoller;

@Component
@EnableScheduling
public class AppScheduler {
	
	@Autowired
	private ApiPoller apiPoller;
	
	/*
	 * This is the method that executes the polling service.
	 * Time is currently set in miliseconds.
	 * The client will need 10 seconds before data is updated
	 */
	@Scheduled(fixedRate = 10000)
	public void polling() {
		apiPoller.poll();
	}
}
