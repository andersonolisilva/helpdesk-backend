package com.andersonolisilva.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andersonolisilva.domains.Chamado;
import com.andersonolisilva.domains.Cliente;
import com.andersonolisilva.domains.Tecnico;
import com.andersonolisilva.domains.enums.Perfil;
import com.andersonolisilva.domains.enums.Prioridade;
import com.andersonolisilva.domains.enums.Status;
import com.andersonolisilva.repositories.ChamadoRepository;
import com.andersonolisilva.repositories.ClienteRepository;
import com.andersonolisilva.repositories.TecnicoRepository;

@Service
public class DBService {

    
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

    public void instaciaDB(){
        Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "63653230268", "valdir@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "80527954780", "linus@mail.com", encoder.encode("123"));

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
    }
    
}
