package com.berk.emlak.controller;

import com.berk.emlak.model.Musteri;
import com.berk.emlak.repository.MusteriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MusteriController {

    private final MusteriRepository musteriRepository;

    @GetMapping("/musteri/ekle")
    public String musteriForm(Model model) {
        model.addAttribute("musteri", new Musteri());
        return "musteri-ekle";
    }

    @PostMapping("/musteri/ekle")
    public String musteriKaydet(@ModelAttribute Musteri musteri) {
        musteriRepository.save(musteri);
        return "redirect:/musteri/liste";
    }

    @GetMapping("/musteri/liste")
    public String musteriListe(Model model) {
        List<Musteri> musteriler = musteriRepository.findAll();
        model.addAttribute("musteriler", musteriler);
        return "musteri-liste";
    }
}
