package com.melons.financemanager.api.controller;

import com.melons.financemanager.service.ExpenseService;
import com.melons.financemanager.service.dto.ExpenseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public List<ExpenseDto> getByUser(Principal principal) {
        return expenseService.getByUser(principal.getName());
    }

    @PostMapping
    public ExpenseDto create(@RequestBody ExpenseDto expenseDto, Principal principal) {
        return expenseService.create(expenseDto, principal.getName());
    }
}
