package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PasswordController {

    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/generate")
    @ResponseBody
    public String generatePassword(@RequestParam("length") int length,
                                   @RequestParam(value = "includeUppercase", required = false) boolean includeUppercase,
                                   @RequestParam(value = "includeDigits", required = false) boolean includeDigits,
                                   @RequestParam(value = "includeSpecialChars", required = false) boolean includeSpecialChars) {
        return passwordGenerator.generatePassword(length, includeUppercase, includeDigits, includeSpecialChars);
    }
}
