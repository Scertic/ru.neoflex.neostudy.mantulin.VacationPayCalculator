package ru.neoflex.neostudy.mantulin.VacationPayCalculator.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HolidayRepositoryImplTest {
    private HolidayRepository holidayRepository;
    @BeforeEach
    public void init() {
        holidayRepository = new HolidayRepositoryImpl();
    }
    @Test
    void isHoliday() {
        assertTrue(holidayRepository.isHoliday(LocalDate.of(2025,1,1)));
        assertFalse(holidayRepository.isHoliday(LocalDate.of(2025,1,30)));
    }
}