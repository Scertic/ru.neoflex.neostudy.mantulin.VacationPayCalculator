package ru.neoflex.neostudy.mantulin.VacationPayCalculator.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class HolidayRepositoryImpl implements HolidayRepository {
    private static final List<LocalDate> holidays = new CopyOnWriteArrayList<>() {
        {
            add(LocalDate.of(2025, 1, 1));
        }
    };

    @Override
    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
}
