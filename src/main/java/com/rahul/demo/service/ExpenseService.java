package com.rahul.demo.service;

import com.rahul.demo.exception.ResourceNotFoundException;
import com.rahul.demo.model.Expense;
import com.rahul.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get expense by ID
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
    }

    // Add new expense
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Update existing expense
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense existing = getExpenseById(id);
        existing.setTitle(updatedExpense.getTitle());
        existing.setAmount(updatedExpense.getAmount());
        existing.setCategory(updatedExpense.getCategory());
        existing.setDate(updatedExpense.getDate());
        existing.setDescription(updatedExpense.getDescription());
        return expenseRepository.save(existing);
    }

    // Delete expense
    public void deleteExpense(Long id) {
        getExpenseById(id);
        expenseRepository.deleteById(id);
    }
}