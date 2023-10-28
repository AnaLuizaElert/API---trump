package br.senai.sc.supertrunfofrutas.business.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private Integer points = 0;
    private Integer qtyLosses = 0;
    private Integer qtyVictories = 0;

    @Enumerated(EnumType.STRING)
    private List<Profile> authorities;

    public void setQtyLosses() {
        this.qtyLosses ++;
    }

    public void setQtyVictories() {
        this.qtyVictories++;
    }
}
