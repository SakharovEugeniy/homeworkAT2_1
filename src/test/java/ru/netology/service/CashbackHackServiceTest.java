package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/CashbackHackServiceData.csv", numLinesToSkip = 1)
    void shouldCalculateCashbackHack(int amount, int expected, String message) {
        CashbackHackService cashbackHackService = new CashbackHackService();
        int actual = cashbackHackService.remain(amount);
        assertEquals(expected,actual,message);
    }

//    @Test
//    void shouldReturn1IfAmountIs999() {
//        CashbackHackService cashbackHackService = new CashbackHackService();
//        int amount = 999;
//        int actual = cashbackHackService.remain(amount);
//        int expected =1;
//        assertEquals(expected,actual);
//    }
//    @Test
//    void shouldReturn0IfAmountIs1000() {
//        CashbackHackService cashbackHackService = new CashbackHackService();
//        int amount = 1000;
//        int actual = cashbackHackService.remain(amount);
//        int expected =0;
//        assertEquals(expected,actual);
//    }
//    @Test
//    void shouldReturn999IfAmountIs1001() {
//        CashbackHackService cashbackHackService = new CashbackHackService();
//        int amount = 1001;
//        int actual = cashbackHackService.remain(amount);
//        int expected =999;
//        assertEquals(expected,actual);
//    }
    @Test
    void shouldReturnIllegalArgumentExceptionIfAmountIs0OrLess() {
        CashbackHackService cashbackHackService = new CashbackHackService();
        int amount = 0;
        assertThrows(IllegalArgumentException.class, () -> cashbackHackService.remain(amount));
    }
}