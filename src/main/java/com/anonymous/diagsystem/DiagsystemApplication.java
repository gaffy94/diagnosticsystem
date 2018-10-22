package com.anonymous.diagsystem;

import com.anonymous.diagsystem.Utilities.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DiagsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagsystemApplication.class, args);
	}
	@Autowired
	Util util;
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("hello world, I have just started up");
		util.writeToJSON();
	}
}
