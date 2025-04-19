package ru.neoflex.neostudy.mantulin.VacationPayCalculator.entity;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class VacationPay {
    private final BigDecimal avgSalary;
    private final int daysOfVacation;
    private final LocalDate startDate;

    public VacationPay(BigDecimal avgSalary, int daysOfVacation, LocalDate startDate) {
        this.avgSalary = avgSalary;
        this.daysOfVacation = daysOfVacation;
        this.startDate = startDate;
    }
}
