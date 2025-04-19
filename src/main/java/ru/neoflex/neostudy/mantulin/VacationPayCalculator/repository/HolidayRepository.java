package ru.neoflex.neostudy.mantulin.VacationPayCalculator.repository;

import java.time.LocalDate;

public interface HolidayRepository {
    boolean isHoliday(LocalDate date);
}
