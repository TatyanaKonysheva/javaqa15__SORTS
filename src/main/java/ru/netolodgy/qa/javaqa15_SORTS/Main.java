package ru.netolodgy.qa.javaqa15_SORTS;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Moscow", "Tyumen", 10_000, 6, 8, 2);
        Ticket ticket2 = new Ticket("Moscow", "Surgut", 20_000, 7, 10, 3);

        System.out.println(ticket1.compareTo(ticket2));
        System.out.println(ticket2.compareTo(ticket1));
        Ticket[] tickets = {ticket1, ticket2};
        Arrays.sort(tickets);


    }
}