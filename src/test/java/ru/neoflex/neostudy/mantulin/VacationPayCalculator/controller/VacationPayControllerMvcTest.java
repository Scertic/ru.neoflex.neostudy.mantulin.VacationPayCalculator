package ru.neoflex.neostudy.mantulin.VacationPayCalculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.neoflex.neostudy.mantulin.VacationPayCalculator.service.VacationPayService;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VacationPayController.class)
class VacationPayControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacationPayService vacationPayService;

    @Test
    void testCalculateVacationPay_statusOK() throws Exception {
        BigDecimal expectedResult = BigDecimal.valueOf(1000);
        when(vacationPayService.calculateVacationPay(any()))
                .thenReturn(expectedResult);

        mockMvc.perform(get("/calculate")
                        .param("avgSalary", "100000")
                        .param("daysOfVacation", "10"))
                .andExpect(status().isOk()) // Ожидаем 200 OK
                .andExpect(content().string(expectedResult.toString()));
    }

}
