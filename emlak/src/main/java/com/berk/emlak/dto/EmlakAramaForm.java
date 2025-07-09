package com.berk.emlak.dto;

import lombok.Data;

@Data
public class EmlakAramaForm {
    private String tur;
    private String durum;
    private String isinma;
    private Integer odaSayisi;
    private Double metrekareMin;
    private Double metrekareMax;
    private Integer kat;
    private Integer binaKat;
}
