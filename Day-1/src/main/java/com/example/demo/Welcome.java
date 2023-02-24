package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController

public class Welcome {
	@GetMapping("/Display1")
	public String    welcome() {
		return "Welcome String Boot!";
	}
	@RequestMapping("/Display2")
	public String getName(){
        String studentName ="IamNeo";
        return "Welcome "+studentName+"!";
	}
	@RequestMapping("/Display3")
	public String getMyFav(){
        String yourFavColor ="Green";
        return "My favorite color is" + yourFavColor;
	}
}



