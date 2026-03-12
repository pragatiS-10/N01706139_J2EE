package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingPrinter printer = context.getBean(GreetingPrinter.class);
        printer.printGreeting();

        GreetingService s1 = context.getBean(GreetingService.class);
        GreetingService s2 = context.getBean(GreetingService.class);

        System.out.println("Are both beans same? " + (s1 == s2));

        context.close();
    }
}