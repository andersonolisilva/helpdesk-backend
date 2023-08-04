package com.andersonolisilva.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonolisilva.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
