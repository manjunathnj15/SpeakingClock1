package com.speakingClock.service.impl;

import com.speakingClock.service.SpeakingClockService;
import org.springframework.stereotype.Service;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {
    @Override
    public String convertTimeToWords(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid time format");
        }

        StringBuilder sb = new StringBuilder();

        if (hour == 0 && minute == 0) {
            sb.append("Midnight");
        } else if (hour == 12 && minute == 0) {
            sb.append("Midday");
        } else {
            sb.append(convertToWords(hour));
            sb.append(" ");
            sb.append(convertToWords(minute));
        }

        return sb.toString();
    }

    private String convertToWords(int number) {
        String[] digits = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = {
                "", "", "twenty", "thirty", "forty", "fifty"
        };

        if (number < 20) {
            return digits[number];
        }

        int tensDigit = number / 10;
        int onesDigit = number % 10;

        return tens[tensDigit] + (onesDigit > 0 ? " " + digits[onesDigit] : "");
    }
}