package com.discerneded.grene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@SpringBootApplication
public class GreneApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreneApplication.class, args);
	}

	@GetMapping("/")
	public String home(Model model) {
		String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = upperCaseLetters.toLowerCase();
		String numbers = "1234567890";
		String specialCharacters = "!@#$%^&*()_-+=";
		String combinedString = upperCaseLetters+lowerCaseLetters+numbers+specialCharacters;
		int passwordLength = 15;
		char[] password = new char[passwordLength];
		Random random = new Random();

		for (int i = 0; i < passwordLength; i++) {
			password[i] = combinedString.charAt(random.nextInt(combinedString.length()));
		}
		model.addAttribute("password", new String(password));
		return "index.html";
	}

}
