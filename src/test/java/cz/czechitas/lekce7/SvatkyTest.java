package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Karel", MonthDay.of(11, 4));
        svatky.pridejSvatek("Havel", 16,10);

        assertTrue(svatky.jeVSeznamu("Karel"));
        assertTrue(svatky.jeVSeznamu("Havel"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        int originalCount = svatky.getPocetJmen();
        svatky.pridejSvatek("Zuzana", 11,8);
        int newCount = svatky.getPocetJmen();

        assertTrue(newCount == originalCount + 1);
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        int smartCount = svatky.getPocetJmen();
        int count = 0;
        for (String jmeno : svatky.getSeznamJmen()) {
            count += 1; // nebo: pocet++;
        }

        assertEquals(smartCount, count);
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Hana", 15, 8);

        MonthDay datum = svatky.vratKdyMaSvatek("Hana");

        assertEquals(MonthDay.of(8, 15), datum);
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Lenka", 5, Month.MARCH);
        MonthDay datum = svatky.vratKdyMaSvatek("Lenka");

        assertTrue(svatky.jeVSeznamu("Lenka"));
        assertEquals(MonthDay.of(Month.MARCH, 5), datum);
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        Svatky svatky = new Svatky();
        MonthDay datum = MonthDay.of(Month.APRIL, 10);
        svatky.pridejSvatek("Iveta", datum);
        MonthDay ulozenyDatum = svatky.vratKdyMaSvatek("Iveta");

        assertTrue(svatky.jeVSeznamu("Iveta"));
        assertEquals(datum, ulozenyDatum);
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Lenka", 5, Month.MARCH);
        int originalCount = svatky.getPocetJmen();
        svatky.smazSvatek("Lenka");
        int newCount = svatky.getPocetJmen();

        assertTrue(newCount == originalCount - 1);
        }
}
