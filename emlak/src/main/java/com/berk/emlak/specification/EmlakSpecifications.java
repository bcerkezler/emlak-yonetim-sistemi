package com.berk.emlak.specification;

import com.berk.emlak.model.Emlak;
import org.springframework.data.jpa.domain.Specification;

public class EmlakSpecifications {

    public static Specification<Emlak> hasTur(String tur) {
        return (root, query, cb) -> (tur == null || tur.isBlank()) ? null : cb.equal(root.get("tur"), tur);
    }

    public static Specification<Emlak> hasDurum(String durum) {
        return (root, query, cb) -> (durum == null || durum.isBlank()) ? null : cb.equal(root.get("durum"), durum);
    }

    public static Specification<Emlak> hasIsinma(String isinma) {
        return (root, query, cb) -> (isinma == null || isinma.isBlank()) ? null : cb.equal(root.get("isinma"), isinma);
    }

    public static Specification<Emlak> hasOdaSayisi(Integer odaSayisi) {
        return (odaSayisi == null || odaSayisi <= 0) ? null :
                (root, query, cb) -> cb.equal(root.get("odaSayisi"), odaSayisi);
    }

    public static Specification<Emlak> metrekareGreaterThanOrEqual(Double min) {
        return (root, query, cb) -> (min == null) ? null : cb.greaterThanOrEqualTo(root.get("metrekare"), min);
    }

    public static Specification<Emlak> metrekareLessThanOrEqual(Double max) {
        return (root, query, cb) -> (max == null) ? null : cb.lessThanOrEqualTo(root.get("metrekare"), max);
    }

    public static Specification<Emlak> hasKat(Integer kat) {
        return (kat == null) ? null : (root, query, cb) -> cb.equal(root.get("kat"), kat);
    }

    public static Specification<Emlak> hasBinaKat(Integer binaKat) {
        return (binaKat == null) ? null : (root, query, cb) -> cb.equal(root.get("binaKat"), binaKat);
    }
}
