package com.andersonolisilva.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonolisilva.domains.Chamado;
import com.andersonolisilva.domains.Cliente;
import com.andersonolisilva.domains.Tecnico;
import com.andersonolisilva.domains.dtos.ChamadoDTO;
import com.andersonolisilva.domains.enums.Prioridade;
import com.andersonolisilva.domains.enums.Status;
import com.andersonolisilva.repositories.ChamadoRepository;
import com.andersonolisilva.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
    
    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;


    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: "+id));
    }

    public List<Chamado> findAll(){
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO objDTO){
        return repository.save(newChamado(objDTO));
    }

    private Chamado newChamado(ChamadoDTO obj){
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if(obj.getId() != null){
            chamado.setId(obj.getId());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }
}
