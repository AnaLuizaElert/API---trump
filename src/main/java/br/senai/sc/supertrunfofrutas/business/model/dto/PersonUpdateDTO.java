package br.senai.sc.supertrunfofrutas.business.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateDTO {

    @NotNull(message = "Field points is empty")
    private Integer points;
    @NotNull(message = "Field qtyLoses is empty")
    private int qtyLoses;
    @NotNull(message = "Field qtyVitories is empty")
    private int qtyVitories;
}
