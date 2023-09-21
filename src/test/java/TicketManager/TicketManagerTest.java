package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.Callable;

class TicketManagerTest {
    @Test
    public void testSortTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("IKT", "BKK", 200, 10, 12);
        Ticket ticket2 = new Ticket("IKT", "BKK", 100, 11, 14);
        Ticket ticket3 = new Ticket("IKT", "NHA", 200, 10, 16);
        Ticket ticket4 = new Ticket("IKT", "BKK", 400, 7, 17);
        Ticket ticket5 = new Ticket("NHA", "DXB", 800, 4, 9);
        Ticket ticket6 = new Ticket("IKT", "BKK", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "SFO", 300, 15, 18);
        Ticket ticket8 = new Ticket("IKT", "BKK", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Ticket[] actual = manager.search("IKT", "BKK");
    }

    @Test
    public void testNoTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("IKT", "BKK", 200, 10, 12);
        Ticket ticket2 = new Ticket("IKT", "BKK", 100, 11, 14);
        Ticket ticket3 = new Ticket("IKT", "NHA", 200, 10, 16);
        Ticket ticket4 = new Ticket("IKT", "BKK", 400, 7, 17);
        Ticket ticket5 = new Ticket("NHA", "DXB", 800, 4, 9);
        Ticket ticket6 = new Ticket("IKT", "BKK", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "SFO", 300, 15, 18);
        Ticket ticket8 = new Ticket("IKT", "BKK", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("IKT", "NEW");
    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("IKT", "BKK", 200, 10, 12);
        Ticket ticket2 = new Ticket("IKT", "BKK", 100, 11, 14);
        Ticket ticket3 = new Ticket("IKT", "NHA", 200, 10, 16);
        Ticket ticket4 = new Ticket("IKT", "BKK", 400, 7, 17);
        Ticket ticket5 = new Ticket("NHA", "DXB", 800, 4, 9);
        Ticket ticket6 = new Ticket("IKT", "BKK", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "SFO", 300, 15, 18);
        Ticket ticket8 = new Ticket("IKT", "BKK", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.search("NEW", "SFO");
    }

    @Test
    public void testSortTicketsTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("IKT", "BKK", 200, 10, 12);
        Ticket ticket2 = new Ticket("IKT", "BKK", 100, 11, 14);
        Ticket ticket3 = new Ticket("IKT", "NHA", 200, 10, 16);
        Ticket ticket4 = new Ticket("IKT", "BKK", 400, 7, 17);
        Ticket ticket5 = new Ticket("NHA", "DXB", 800, 4, 9);
        Ticket ticket6 = new Ticket("IKT", "BKK", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "SFO", 300, 15, 18);
        Ticket ticket8 = new Ticket("IKT", "BKK", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};
        Ticket[] actual = manager.search("IKT", "BKK", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("IKT", "BKK", 200, 10, 12);
        Ticket ticket2 = new Ticket("IKT", "BKK", 100, 11, 14);
        Ticket ticket3 = new Ticket("IKT", "NHA", 200, 10, 16);
        Ticket ticket4 = new Ticket("IKT", "BKK", 400, 7, 17);
        Ticket ticket5 = new Ticket("NHA", "DXB", 800, 4, 9);
        Ticket ticket6 = new Ticket("IKT", "BKK", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "SFO", 300, 15, 18);
        Ticket ticket8 = new Ticket("IKT", "BKK", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {ticket7,};
        Ticket[] actual = manager.search("NEW", "SFO", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortNoTicketTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("IKT", "BKK", 200, 10, 12);
        Ticket ticket2 = new Ticket("IKT", "BKK", 100, 11, 14);
        Ticket ticket3 = new Ticket("IKT", "NHA", 200, 10, 16);
        Ticket ticket4 = new Ticket("IKT", "BKK", 400, 7, 17);
        Ticket ticket5 = new Ticket("NHA", "DXB", 800, 4, 9);
        Ticket ticket6 = new Ticket("IKT", "BKK", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "SFO", 300, 15, 18);
        Ticket ticket8 = new Ticket("IKT", "BKK", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {};
        Ticket[] actual = manager.search("IKT", "NEW", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
