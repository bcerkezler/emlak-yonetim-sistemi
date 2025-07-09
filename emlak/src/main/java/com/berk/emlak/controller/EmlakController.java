package com.berk.emlak.controller;

import com.berk.emlak.dto.EmlakAramaForm;
import com.berk.emlak.model.Emlak;
import com.berk.emlak.repository.EmlakRepository;
import com.berk.emlak.repository.MusteriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static com.berk.emlak.specification.EmlakSpecifications.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class EmlakController {

    private final EmlakRepository emlakRepository;
    private final MusteriRepository musteriRepository;

    @GetMapping("/arama")
    public String aramaForm(Model model) {
        model.addAttribute("aramaKriteri", new EmlakAramaForm());
        return "arama";
    }

    @PostMapping("/arama")
    public String aramaSonuc(@ModelAttribute EmlakAramaForm kriter, Model model) {
        Specification<Emlak> spec = hasTur(kriter.getTur())
                .and(hasDurum(kriter.getDurum()))
                .and(hasOdaSayisi(kriter.getOdaSayisi()))
                .and(hasIsinma(kriter.getIsinma()))
                .and(metrekareGreaterThanOrEqual(kriter.getMetrekareMin()))
                .and(metrekareLessThanOrEqual(kriter.getMetrekareMax()))
                .and(hasKat(kriter.getKat()))
                .and(hasBinaKat(kriter.getBinaKat()));

        List<Emlak> sonuc = emlakRepository.findAll(spec);
        model.addAttribute("sonuclar", sonuc);
        return "arama-sonuc";
    }

    @GetMapping("/emlak/ekle")
    public String emlakForm(Model model) {
        model.addAttribute("emlak", new Emlak());
        model.addAttribute("musteriler", musteriRepository.findAll());
        return "emlak-ekle";
    }

    @PostMapping("/emlak/ekle")
    public String emlakKaydet(@ModelAttribute Emlak emlak) {
        emlakRepository.save(emlak);
        return "redirect:/arama";
    }
}
