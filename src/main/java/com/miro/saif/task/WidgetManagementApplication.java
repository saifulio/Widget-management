package com.miro.saif.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WidgetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WidgetManagementApplication.class, args);
	}

	@GetMapping("/widgets/{id}")
	public String getWidget(@PathVariable Integer id) {
		System.out.println(id);
		return "Widget id: " + id;
	}

}
