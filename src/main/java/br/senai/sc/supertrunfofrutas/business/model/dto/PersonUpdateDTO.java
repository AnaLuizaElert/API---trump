package br.senai.sc.supertrunfofrutas.business.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateDTO {

    @NotNull
    private Integer points;
    @NotNull
    private int qtyLoses;
    @NotNull
    private int qtyVitories;
}
