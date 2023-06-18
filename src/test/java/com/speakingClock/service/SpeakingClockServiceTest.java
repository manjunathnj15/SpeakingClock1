package com.speakingClock.service;



import com.speakingClock.service.impl.SpeakingClockServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpeakingClockServiceTest {
    private SpeakingClockService speakingClockService;

    @BeforeEach
    void setup() {
        speakingClockService = new SpeakingClockServiceImpl();
    }

    @Test
    void testConvertTimeToWords() {
        String time = "08:34";
        String expected = "eight thirty four";
        String result = speakingClockService.convertTimeToWords(time);
        assertEquals(expected, result);
    }
}
