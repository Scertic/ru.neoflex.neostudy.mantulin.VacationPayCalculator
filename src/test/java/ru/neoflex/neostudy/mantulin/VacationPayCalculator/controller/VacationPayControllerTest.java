package ru.neoflex.neostudy.mantulin.VacationPayCalculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.service.VacationPayService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VacationPayControllerTest {
    private VacationPayService vacationPayService;
    private VacationPayController controller;

    @BeforeEach
    void setUp() {
        vacationPayService = mock(VacationPayService.class);
        controller = new VacationPayController(vacationPayService);
    }

    @Test
    void testCalculateVacationPayWithoutDate_statusOk() {
        when(vacationPayService.calculateVacationPay(any())).thenReturn(BigDecimal.valueOf(34129.7));

        ResponseEntity<BigDecimal> response = controller.calculateVacationPay(
                BigDecimal.valueOf(100_000), 10, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(BigDecimal.valueOf(34129.7), response.getBody());
    }

    @Test
    void testCalculateVacationPayWithoutDate_statusNotOk() {
        when(vacationPayService.calculateVacationPay(any()))
                .thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () ->
                controller.calculateVacationPay(BigDecimal.valueOf(100_000), 10, null));
    }
}