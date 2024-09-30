package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordGeneratorTest {

    @Test
    public void testPasswordLength() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, true, true, true);
        assertEquals(12, password.length());
    }

    @Test
    public void testPasswordContainsUppercase() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, true, false, false);
        assertTrue(password.matches(".*[A-Z].*"));
    }

    @Test
    public void testPasswordContainsDigits() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, false, true, false);
        assertTrue(password.matches(".*[0-9].*"));
    }

    @Test
    public void testPasswordContainsSpecialCharacters() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, false, false, true);
        assertTrue(password.matches(".*[!@#$%^&*()-_=+{}\\[\\]:;,.<>?].*"));
    }

    @Test
    public void testPasswordWithoutUppercase() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, false, true, true);
        assertFalse(password.matches(".*[A-Z].*"));
    }

    @Test
    public void testPasswordWithoutDigits() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, true, false, true);
        assertFalse(password.matches(".*[0-9].*"));
    }

    @Test
    public void testPasswordWithoutSpecialCharacters() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(12, true, true, false);
        assertFalse(password.matches(".*[!@#$%^&*()\\-_=+{}\\[\\]:;,.<>?].*"));
    }
}
