package br.senai.sc.supertrunfofrutas.business.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    @NotEmpty(message = "Field name is empty")
    @Size(max = 255, message = "Field name has more than 255 characters")
    private String name;
    @NotNull(message = "Field ranking is empty")
    private Double ranking;
    @NotNull(message = "Field qtyCalories is empty")
    private Double qtyCalories;
    @NotNull(message = "Field qtyGlucose is empty")
    private Double qtyGlucose;
    @NotNull(message = "Field qtyProteins is empty")
    private Double qtyProteins;
    @NotEmpty(message = "Field url is empty")
    @Size(max = 255, message = "Field url has more than 255 characters")
    private String url;

}
