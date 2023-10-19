package br.senai.sc.supertrunfofrutas.business.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Double qtyCalories;
    private Double qtyGlucose;
    private Double ranking;
    private Double qtyProteins;
    private String url;

}
