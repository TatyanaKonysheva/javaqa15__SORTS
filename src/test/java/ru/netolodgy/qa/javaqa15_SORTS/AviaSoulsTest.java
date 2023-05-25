package ru.netolodgy.qa.javaqa15_SORTS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    private AviaSouls aviaSouls;

    @BeforeEach
    public void setup() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(new Ticket("Moscow", "Tyumen", 10_000, 6, 8, 2));
        aviaSouls.add(new Ticket("Moscow", "Surgut", 20_000, 7, 10, 3));
    }

    @Test
    public void shouldToSortInAscendingOrder() {
        Ticket ticket1 = new Ticket("Moscow", "Tyumen", 10_000, 6, 8, 2);
        Ticket ticket2 = new Ticket("Moscow", "Surgut", 20_000, 7, 10, 3);

        Assertions.assertTrue(ticket1.compareTo(ticket2) == -1);
        Assertions.assertFalse(ticket1.compareTo(ticket2) == 0);
    }

    @Test
    public void shouldToSearchTicket() {
        Ticket ticket1 = new Ticket("Moscow", "Tyumen", 10_000, 6, 8, 2);
        Ticket ticket2 = new Ticket("Moscow", "Surgut", 20_000, 7, 10, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected1 = {ticket1};
        Ticket[] actual1 = aviaSouls.search("Moscow", "Tyumen");
        Assertions.assertArrayEquals(expected1, actual1);

        Ticket[] expected2 = {ticket2};
        Ticket[] actual2 = aviaSouls.search("Moscow", "Surgut");
        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void shouldToSearchInAscendingOrder() {
        Ticket ticket1 = new Ticket("Moscow", "Tyumen", 10_000, 6, 8, 2);
        Ticket ticket2 = new Ticket("Moscow", "Surgut", 40_000, 7, 10, 3);
        Ticket ticket3 = new Ticket("Moscow", "Surgut", 30_000, 7, 10, 3);

        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        Ticket[] expected = {
                new Ticket("Moscow", "Surgut", 30_000, 7, 10, 3),
                new Ticket("Moscow", "Surgut", 40_000, 7, 10, 3)
        };
        Ticket[] actual = aviaSouls.search("Moscow", "Surgut");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldToSearchAndSortByTicket() {
        Ticket t1 = new Ticket("Moscow", "Tyumen", 10_000, 6, 8, 2);
        Ticket t2 = new Ticket("Moscow", "Surgut", 20_000, 7, 10, 3);
        Ticket t3 = new Ticket("Kazan", "Surgut", 20_000, 5, 7, 2);
        Ticket t4 = new Ticket("Moscow", "Kazan", 15_000, 8, 9, 1);
        Ticket t5 = new Ticket("Moscow", "Vladivostok", 20_000, 10, 17, 7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        int expected1 = -1;
        int actual1 = comparator.compare(t1, t2);
        Assertions.assertEquals(expected1, actual1);

        int expected2 = 1;
        int actual2 = comparator.compare(t5, t4);
        Assertions.assertEquals(expected2, actual2);

        int expected3 = 0;
        int actual3 = comparator.compare(t1, t3);
        Assertions.assertEquals(expected3, actual3);
    }
}
