package com.torukobyte.kodlama_io_dev.repository.abstracts;

import com.torukobyte.kodlama_io_dev.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
    boolean existsByName(String name);
}
