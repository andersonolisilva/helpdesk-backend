package com.andersonolisilva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonolisilva.domains.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
    
}
