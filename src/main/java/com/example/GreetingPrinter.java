package com.example;

public class GreetingPrinter {

    private GreetingService greetingService;

    public GreetingPrinter(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void printGreeting() {
        System.out.println(greetingService.getGreeting());
    }
}