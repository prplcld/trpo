package com.melons.financemanager.service.dto;

import com.melons.financemanager.model.Income;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto {
    private Integer id;
    private BigDecimal amount;
    private LocalDateTime date;
    private String currency;

    public static IncomeDto fromIncome(Income income) {
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setId(income.getId());
        incomeDto.setAmount(income.getAmount());
        incomeDto.setDate(income.getDate());
        incomeDto.setCurrency(income.getCurrency().getName());
        return incomeDto;
    }

    public Income toIncome() {
        Income income = new Income();
        income.setAmount(amount);
        income.setDate(date);
        return income;
    }
}
