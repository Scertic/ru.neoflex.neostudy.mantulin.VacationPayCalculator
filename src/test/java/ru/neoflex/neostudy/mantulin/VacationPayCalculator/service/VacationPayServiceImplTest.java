package ru.neoflex.neostudy.mantulin.VacationPayCalculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.entity.VacationPay;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.util.VacationPayCalculator;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

class VacationPayServiceImplTest {
    private VacationPayCalculator vacationPayCalculator;
    private VacationPay vacationPay;
    private VacationPayService vacationPayService;

    @BeforeEach
    public void init() {
        vacationPayCalculator = mock(VacationPayCalculator.class);
        vacationPay = mock(VacationPay.class);
        vacationPayService = new VacationPayServiceImpl(vacationPayCalculator);
    }
    @Test
    void calculateVacationPay_withoutDate() {
        when(vacationPay.getStartDate()).thenReturn(null);
        when(vacationPay.getAvgSalary()).thenReturn(BigDecimal.valueOf(100_000));
        when(vacationPay.getDaysOfVacation()).thenReturn(10);

        vacationPayService.calculateVacationPay(vacationPay);

        verify(vacationPayCalculator).calculateWithoutStartDate(BigDecimal.valueOf(100_000), 10);

    }

    @Test
    void calculateVacationPay_withDate() {
        when(vacationPay.getStartDate()).thenReturn(LocalDate.of(2025,1,1));
        when(vacationPay.getAvgSalary()).thenReturn(BigDecimal.valueOf(100_000));
        when(vacationPay.getDaysOfVacation()).thenReturn(10);

        vacationPayService.calculateVacationPay(vacationPay);

        verify(vacationPayCalculator).calculateWithStartDate(BigDecimal.valueOf(100_000), 10, LocalDate.of(2025,1,1));

    }
}