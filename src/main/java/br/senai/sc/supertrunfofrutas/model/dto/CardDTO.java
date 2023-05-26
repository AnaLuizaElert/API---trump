package br.senai.sc.supertrunfofrutas.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    @NotNull
    private String name;
    @NotNull
    private Double ranking;
    @NotNull
    private Double qtyCalories;
    @NotNull
    private Double qtyGlucose;
    @NotNull
    private Double qtyProteins;
    @NotNull
    private String url;

}
