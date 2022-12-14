package com.torukobyte.kodlama_io_dev.repository.abstracts;

import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
    boolean existsByName(String name);
}