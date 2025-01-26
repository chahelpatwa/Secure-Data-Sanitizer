package com.example.inputsanitizer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InputSanitizerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testInputSanitization() {
        String input = "<script>alert('test');</script>";
        String sanitizedInput = InputSanitizer.sanitizeInput(input);
        assertEquals("Your input was sanitized. Sanitized input: _script_alert('test');_/script_", sanitizedInput);
    }
}