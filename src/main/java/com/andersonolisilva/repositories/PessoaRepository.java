package com.andersonolisilva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonolisilva.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
