package ru.neoflex.neostudy.mantulin.VacationPayCalculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.repository.HolidayRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacationPayCalculatorTest {
    private VacationPayCalculator vacationPayCalculator;
    @BeforeEach
    public void init() {
        vacationPayCalculator = new VacationPayCalculator(BigDecimal.valueOf(29.3), new HolidayRepositoryImpl());
    }

    @Test
    void calculateWithoutStartDate() {
        assertEquals(new BigDecimal("34129.70"), vacationPayCalculator.calculateWithoutStartDate(BigDecimal.valueOf(100_000),10));
    }

    @Test
    void calculateWithStartDate() {
        assertEquals(new BigDecimal("3412.97"), vacationPayCalculator.calculateWithStartDate(BigDecimal.valueOf(100_000),2, LocalDate.of(2025,1,1)));
    }
}