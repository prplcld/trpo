package com.melons.financemanager.service.dto;

import com.melons.financemanager.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto {
    private Integer id;
    private String name;

    public static CurrencyDto fromCurrency(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        return currencyDto;
    }

    public Currency toCurrency() {
        Currency currency = new Currency();
        currency.setId(id);
        currency.setName(name);
        return currency;
    }
}
