package com.andersonolisilva.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.andersonolisilva.domains.dtos.TecnicoDTO;
import com.andersonolisilva.domains.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa{

    
	private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(){
        super();
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico(TecnicoDTO objDTO) {
        super();
        this.id = objDTO.getId();
        this.nome = objDTO.getNome();
        this.cpf = objDTO.getCpf();
        this.email = objDTO.getEmail();
        this.senha = objDTO.getSenha();
        this.perfis = objDTO.getPerfis().stream().map( x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = objDTO.getDataCriacao();
    }

    public Tecnico (Integer id, String nome, String cpf, String email, String senha){
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }
    
    public List<Chamado> getChamados(){
        return chamados;
    }

    public void setChamados(List<Chamado> chamados){
        this.chamados = chamados;
    }
}
