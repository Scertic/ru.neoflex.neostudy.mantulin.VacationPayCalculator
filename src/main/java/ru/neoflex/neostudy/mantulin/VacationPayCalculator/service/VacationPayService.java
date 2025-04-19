package ru.neoflex.neostudy.mantulin.VacationPayCalculator.service;


import ru.neoflex.neostudy.mantulin.VacationPayCalculator.entity.VacationPay;

import java.math.BigDecimal;

public interface VacationPayService {
    BigDecimal calculateVacationPay(VacationPay vacationPay);
}

