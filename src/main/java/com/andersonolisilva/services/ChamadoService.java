package com.andersonolisilva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonolisilva.domains.Chamado;
import com.andersonolisilva.repositories.ChamadoRepository;
import com.andersonolisilva.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: "+id));
    }

    public List<Chamado> findAll(){
        return repository.findAll();
    }
}
