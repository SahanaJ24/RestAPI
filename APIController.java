package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
@RestController

public class APIController {
	@Value("${greeting.message}")
    private String message;

    @RequestMapping("/message")
	public String getName(){
        return message;
	}
}