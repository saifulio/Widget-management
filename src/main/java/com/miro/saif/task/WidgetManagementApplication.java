package com.miro.saif.task;

import com.miro.saif.task.model.Widget;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@PostMapping("/widgets")
	public Widget createWidget(@RequestBody Widget widget) {
		System.out.println(widget.getX());
		return widget;
	}

	@PatchMapping(value = "/widgets/{id}")
	public Widget updateWidget(
			@RequestBody Map<String, Object> updates,
			@PathVariable Integer id) {
		Widget widget = new Widget();
		return widget;
	}

	@DeleteMapping("/widgets/{id}")
	public HttpStatus deleteWidget(@PathVariable Integer id) {
		System.out.println(id);
		return HttpStatus.OK;
	}

	@GetMapping("/widgets")
	public List<Widget> getWidgets() {
		List<Widget> widgets= new ArrayList<>();
		return widgets;
	}

}
