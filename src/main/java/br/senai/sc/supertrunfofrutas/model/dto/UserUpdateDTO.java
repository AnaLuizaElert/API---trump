package br.senai.sc.supertrunfofrutas.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    @NotNull
    private Integer points;
    @NotNull
    private int qtyLoses;
    @NotNull
    private int qtyVitories;
}
