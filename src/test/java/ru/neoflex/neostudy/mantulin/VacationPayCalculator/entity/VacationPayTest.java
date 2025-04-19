package ru.neoflex.neostudy.mantulin.VacationPayCalculator.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacationPayTest {
    private VacationPay vacationPay;
    @BeforeEach
    public void init() {
        vacationPay = new VacationPay(new BigDecimal(100_000),10, LocalDate.of(2025,1,1));
    }

    @Test
    public void getters() {
        BigDecimal bigDecimal = new BigDecimal(100_000);
        int i = 10;
        LocalDate localDate = LocalDate.of(2025, 1, 1);
        assertEquals(bigDecimal, vacationPay.getAvgSalary());
        assertEquals(i, vacationPay.getDaysOfVacation());
        assertEquals(localDate, vacationPay.getStartDate());
    }
}