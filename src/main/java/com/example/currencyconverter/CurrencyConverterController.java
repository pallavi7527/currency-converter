package com.example.currencyconverter;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverterController {

    private static final double EXCHANGE_RATE = 82.75; // Example rate: 1 USD = 82.75 INR

    @GetMapping("/convert")
    public ConversionResult convert(@RequestParam double amount) {
        double inrAmount = amount * EXCHANGE_RATE;
        return new ConversionResult(amount, inrAmount);
    }

    public static class ConversionResult {
        private double originalAmount;
        private double convertedAmount;

        public ConversionResult(double originalAmount, double convertedAmount) {
            this.originalAmount = originalAmount;
            this.convertedAmount = convertedAmount;
        }

        public double getOriginalAmount() {
            return originalAmount;
        }

        public double getConvertedAmount() {
            return convertedAmount;
        }
    }
}