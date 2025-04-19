package ru.neoflex.neostudy.mantulin.VacationPayCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.entity.VacationPay;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.service.VacationPayService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class VacationPayController {
    private final VacationPayService vacationPayService;

    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateVacationPay(@RequestParam BigDecimal avgSalary,
                                                           @RequestParam int daysOfVacation,
                                                           @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        VacationPay vacationPay = new VacationPay(avgSalary, daysOfVacation, startDate);
        BigDecimal result = vacationPayService.calculateVacationPay(vacationPay);
        return ResponseEntity.ok(result);
    }
}