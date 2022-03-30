package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoogueRachelTestTask3 {

    CarParkKind Kind = CarParkKind.STAFF;
    BigDecimal normalRate = new BigDecimal(5);
    BigDecimal reducedRate = new BigDecimal(2);
    ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(10,12), new Period(7,10)));
    ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(1,7), new Period(12,24)));
    Rate rate = new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
    Period period = new Period(2,17);


    //Testing that the calculated rate is correct
    @Test
    public void test1() {
        assertEquals(new BigDecimal(45), rate.calculate(period));
    }

    //Tests that an IllegalArgumentException is thrown when normalPeriod is null. Lines 16 + 17 covered.
    @Test
    public void test2() {
        ArrayList<Period> normalPeriod = null;

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when reducedPeriod is null. Lines 16 + 17 covered.
    @Test
    public void test3() {
        ArrayList<Period> reducedPeriod = null;

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when normalRate is null. Lines 19 + 20 covered.
    @Test
    public void test4(){
        BigDecimal normalRate = null;

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when reducedRate is null. Lines 19 + 20 covered.
    @Test
    public void test5(){
        BigDecimal reducedRate = null;

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when normalRate invalid i.e. -1 or less. Lines 22 + 23 covered.
    @Test
    public void test6(){
        BigDecimal normalRate = new BigDecimal(-1);

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when reducedRate is invalid i.e. -1 or less. Lines 22 + 23 covered.
    @Test
    public void test7(){
        BigDecimal reducedRate = new BigDecimal(-1);

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when normalRate invalid i.e. -1 or less. Lines 25 + 26 covered.
    @Test
    public void test8(){
        BigDecimal normalRate = new BigDecimal(0);

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when normalPeriod is invalid i.e. overlap. Lines 28 + 29 covered.
    @Test
    public void test9(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(7, 10), new Period(8,12)));

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when reducedPeriod is invalid i.e. overlap. Lines 28 + 29 covered.
    @Test
    public void test10(){
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(7, 10), new Period(8,12)));

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //Tests that an IllegalArgumentException is thrown when reducedPeriod and normalPeriod overlap one another. Line 31 + 32 covered.
    @Test
    public void test11(){
        ArrayList<Period> normalPeriod = new ArrayList<>(Arrays.asList(new Period(10,12), new Period(7,10)));
        ArrayList<Period> reducedPeriod = new ArrayList<>(Arrays.asList(new Period(10,12), new Period(7,10)));

        assertThrows(IllegalArgumentException.class, () -> new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod));
    }

    //All tests from Task 3

    //Testing that the calculated rate when CarParkKind is "VISITOR"
    @Test
    public void test12() {
        CarParkKind Kind = CarParkKind.VISITOR;
        Rate rate = new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
        Period period = new Period(2,12);

        assertEquals(new BigDecimal(0), rate.calculate(period));
    }

    //Testing that the calculated rate when CarParkKind is "MANAGEMENT"
    @Test
    public void test13() {
        CarParkKind Kind = CarParkKind.MANAGEMENT;
        Rate rate = new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod);
        Period period = new Period(2,6);

        assertEquals(new BigDecimal(4), rate.calculate(period));
    }

    //Testing that the calculated rate when CarParkKind is "STUDENT"
    @Test
    public void test14() {
        CarParkKind Kind = CarParkKind.STUDENT;
        Rate rate = new Rate(Kind, normalRate, reducedRate, reducedPeriod, normalPeriod);

        assertEquals(new BigDecimal(35.125), rate.calculate(period));
    }
}