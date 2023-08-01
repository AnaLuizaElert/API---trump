package br.senai.sc.supertrunfofrutas.business.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
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
