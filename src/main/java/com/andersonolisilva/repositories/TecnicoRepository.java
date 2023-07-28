package com.andersonolisilva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonolisilva.domains.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
    
}
