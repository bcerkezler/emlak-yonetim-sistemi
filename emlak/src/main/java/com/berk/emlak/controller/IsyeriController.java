package com.berk.emlak.controller;

import com.berk.emlak.model.Isyeri;
import com.berk.emlak.repository.IsyeriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IsyeriController {

    private final IsyeriRepository isyeriRepository;

    @GetMapping("/isyeri")
    public String isyeriForm(Model model) {
        List<Isyeri> isyerleri = isyeriRepository.findAll();
        Isyeri isyeri = isyerleri.isEmpty() ? new Isyeri() : isyerleri.get(0);
        model.addAttribute("isyeri", isyeri);
        return "isyeri";
    }

    @PostMapping("/isyeri")
    public String isyeriKaydet(@ModelAttribute Isyeri isyeri) {
        if (isyeri.getId() != null) {
            isyeriRepository.save(isyeri);
        } else {
            isyeriRepository.save(isyeri);
        }
        return "redirect:/isyeri";
    }
}
