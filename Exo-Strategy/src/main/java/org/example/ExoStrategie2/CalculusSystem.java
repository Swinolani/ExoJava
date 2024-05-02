package org.example.ExoStrategie2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculusSystem {
    private double tax;
    public void conversionTax(TaxStrategy taxStrategy){
        taxStrategy.calculateTax(tax);
    };
}
