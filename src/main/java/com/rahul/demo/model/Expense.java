package com.rahul.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
    @Column(nullable = false)
    private String title;

    @NotNull(message = "Amount cannot be empty")
    @Positive(message = "Amount must be positive")
    @Column(nullable = false)
    private BigDecimal amount;

    @NotBlank(message = "Category cannot be empty")
    @Column(nullable = false)
    private String category;

    @NotNull(message = "Date cannot be empty")
    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String description;
}