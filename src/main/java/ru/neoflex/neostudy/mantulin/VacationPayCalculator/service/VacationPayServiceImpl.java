package ru.neoflex.neostudy.mantulin.VacationPayCalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.entity.VacationPay;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.util.VacationPayCalculator;

import java.math.BigDecimal;

@Service
public class VacationPayServiceImpl implements VacationPayService {
    private VacationPayCalculator vacationPayCalculator;

    public VacationPayServiceImpl(VacationPayCalculator vacationPayCalculator) {
        this.vacationPayCalculator = vacationPayCalculator;
    }

    @Override
    public BigDecimal calculateVacationPay(VacationPay vacationPay) {
        if(vacationPay.getStartDate() == null) {
            return vacationPayCalculator.calculateWithoutStartDate(vacationPay.getAvgSalary(),
                    vacationPay.getDaysOfVacation());
        } else {
            return vacationPayCalculator.calculateWithStartDate(vacationPay.getAvgSalary(),
                    vacationPay.getDaysOfVacation(),
                    vacationPay.getStartDate());
        }
    }
}
