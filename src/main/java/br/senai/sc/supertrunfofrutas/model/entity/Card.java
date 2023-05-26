package br.senai.sc.supertrunfofrutas.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double qtyCalories;
    private Double qtyGlucose;
    private Double ranking;
    private Double qtyProteins;
    private String url;

    public static boolean compareAttributes(int attribute){
        Card cardPlayer = Deck.getCardPlayer().get(0);
        Card cardComputer = Deck.getCardComputer().get(0);

        double attributeUser = 0;
        double attributeComputer = 0;

        switch (attribute){
            case 1 -> {
                attributeUser = cardPlayer.getQtyProteins();
                attributeComputer = cardComputer.getQtyProteins();
            }
            case 2 -> {
                attributeUser = cardPlayer.getQtyCalories();
                attributeComputer = cardComputer.getQtyCalories();
            }
            case 3 -> {
                attributeUser = cardPlayer.getQtyGlucose();
                attributeComputer = cardComputer.getQtyGlucose();
            }
            case 4 -> {
                attributeUser = cardPlayer.getRanking();
                attributeComputer = cardComputer.getRanking();
            }
        }

        if(attributeUser > attributeComputer){
            return true;
        } else if (attributeUser < attributeComputer){
            return false;
        } else {
            return Game.getPlayer() == 0;
        }
    }
}
