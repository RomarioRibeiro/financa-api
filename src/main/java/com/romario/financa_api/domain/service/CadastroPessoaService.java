package com.romario.financa_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romario.financa_api.domain.model.Pessoa;
import com.romario.financa_api.domain.repository.PessoaRepository;

@Service
public class CadastroPessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa  pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
}
