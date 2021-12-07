package com.melons.financemanager.api.controller;

import com.melons.financemanager.service.IncomeService;
import com.melons.financemanager.service.dto.IncomeDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/incomes")
@AllArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public IncomeDto create(@RequestBody IncomeDto incomeDto, Principal principal) {
        return incomeService.create(incomeDto, principal.getName());
    }

    @GetMapping
    public List<IncomeDto> getByUser(Principal principal) {
        return incomeService.getByUser(principal.getName());
    }

    @GetMapping("/converts")
    public List<IncomeDto> get(Principal principal) {
        return incomeService.get(principal.getName());
    }
}
