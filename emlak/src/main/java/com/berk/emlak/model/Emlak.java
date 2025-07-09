package com.berk.emlak.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emlak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musteri_id")
    private Musteri musteri;

    private String tur;
    private Double metrekare;
    private int odaSayisi;
    private int kat;
    private int binaKat;
    private String isinma;
    private String durum;
}
