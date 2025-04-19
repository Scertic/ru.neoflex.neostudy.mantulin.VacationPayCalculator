package ru.neoflex.neostudy.mantulin.VacationPayCalculator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.repository.HolidayRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Component
public class VacationPayCalculator {

    private final BigDecimal AVG_MONTH_DAYS;
    private final HolidayRepository holidayRepository;

    public VacationPayCalculator( @Value("${avg_month_days:29.3}") BigDecimal AVG_MONTH_DAYS,
                                  HolidayRepository holidayRepository) {
        this.AVG_MONTH_DAYS = AVG_MONTH_DAYS;
        this.holidayRepository = holidayRepository;
    }

    public BigDecimal calculateWithoutStartDate(BigDecimal avgSalary, int daysOfVacation) {
        BigDecimal dailySalary = avgSalary.divide(AVG_MONTH_DAYS, 2, RoundingMode.HALF_UP);
        return  dailySalary.multiply(BigDecimal.valueOf(daysOfVacation));
    }

    public BigDecimal calculateWithStartDate(BigDecimal avgSalary, int daysOfVacation, LocalDate startDate) {
        int workDaysCount = daysOfVacation;
        for (int i = 0; i < daysOfVacation; i++) {
            if (holidayRepository.isHoliday(startDate)) {
                workDaysCount--;
            }
            startDate = startDate.plusDays(1);
        }
        BigDecimal dailySalary = avgSalary.divide(AVG_MONTH_DAYS, 2, RoundingMode.HALF_UP);
        return  dailySalary.multiply(BigDecimal.valueOf(workDaysCount));
    }
}
