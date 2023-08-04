package br.senai.sc.supertrunfofrutas.business.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    private Integer id;
    private String username;
    private Integer points = 0;
    private int qtyLosses = 0;
    private int qtyVitories = 0;

    public void setQtyLosses() {
        this.qtyLosses ++;
    }

    public void setQtyVitories() {
        this.qtyVitories ++;
    }
}
