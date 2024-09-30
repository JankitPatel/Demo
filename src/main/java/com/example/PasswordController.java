package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    private PasswordGenerator passwordGenerator = new PasswordGenerator();

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/generate")
    public String generatePassword(@RequestParam("length") int length,
                                   @RequestParam(value = "includeUppercase", required = false) boolean includeUppercase,
                                   @RequestParam(value = "includeDigits", required = false) boolean includeDigits,
                                   @RequestParam(value = "includeSpecialChars", required = false) boolean includeSpecialChars,
                                   Model model) {
        String password = passwordGenerator.generatePassword(length, includeUppercase, includeDigits, includeSpecialChars);
        model.addAttribute("password", password);
        return "index";
    }
}
