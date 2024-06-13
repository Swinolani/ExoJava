package com.swino.exercice6.classe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String mark,reference;
    private LocalDate dateOfPurchase;
    private Double price;
    private int stock;

}
