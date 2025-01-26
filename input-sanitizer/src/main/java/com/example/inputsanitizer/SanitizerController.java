package com.example.inputsanitizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sanitize")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Allow requests from your frontend URL
public class SanitizerController {

    private static final Logger logger = LoggerFactory.getLogger(SanitizerController.class);

    @PostMapping
    public ResponseEntity<Map<String, String>> sanitize(@RequestBody Map<String, String> input) {
        try {
            logger.info("Received input for sanitization: {}", input.get("input"));
            String sanitizedInput = InputSanitizer.sanitizeInput(input.get("input"));
            Map<String, String> response = new HashMap<>();
            response.put("sanitizedInput", sanitizedInput);
            logger.info("Sanitized input: {}", sanitizedInput);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error during sanitization", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}