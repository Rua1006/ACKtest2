package com.jpa.restful.controller;

import com.jpa.restful.dao.LanguageRepository;
import com.jpa.restful.entity.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageRepository languageRepository;

    @GetMapping("")
    public List<Language> all() {
        return languageRepository.findAll();
    }

    @GetMapping("/{language_id}")
    public Language getLanguage(@PathVariable("language_id") Integer language_id) {
        return languageRepository.findById(language_id)
                .orElseThrow(() -> new IllegalArgumentException("illegal argument :" + language_id));
    }

    @PostMapping("")
    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        Language addLanguage = languageRepository.save(language);
        return ResponseEntity.ok(addLanguage);
    }

    @PutMapping("/{language_id}")
    public void updateLanguage(@PathVariable Integer language_id, @RequestBody Language newlanguage) {
        languageRepository.findById(language_id)
                .map(language -> {
                    language.setName(newlanguage.getName());
                    return languageRepository.save(language);
                })
                .orElseGet(() -> {
                    newlanguage.setLanguage_id(language_id);
                    return languageRepository.save(newlanguage);
                });
    }

    @DeleteMapping("/{language_id}")
    public void deleteLanguage(@PathVariable Integer language_id ) {
        languageRepository.deleteById(language_id);
    }
}
