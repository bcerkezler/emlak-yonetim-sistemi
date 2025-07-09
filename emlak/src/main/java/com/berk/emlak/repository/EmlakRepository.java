package com.berk.emlak.repository;

import com.berk.emlak.model.Emlak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

public interface EmlakRepository extends JpaRepository<Emlak, Long>, JpaSpecificationExecutor<Emlak> {
    List<Emlak> findByTurAndDurumAndOdaSayisiAndIsinma(String tur, String durum, int odaSayisi, String isinma);
}
