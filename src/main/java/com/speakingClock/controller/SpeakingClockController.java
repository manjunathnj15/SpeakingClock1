package com.speakingClock.controller;


import com.speakingClock.service.SpeakingClockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api")
    public class SpeakingClockController {
        private final SpeakingClockService speakingClockService;

        public SpeakingClockController(SpeakingClockService speakingClockService) {
            this.speakingClockService = speakingClockService;
        }

        @GetMapping("/convert/{time}")
        public ResponseEntity<String> convertTimeToWords(@PathVariable String time) {
            try {
                String result = speakingClockService.convertTimeToWords(time);
                return ResponseEntity.ok(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

