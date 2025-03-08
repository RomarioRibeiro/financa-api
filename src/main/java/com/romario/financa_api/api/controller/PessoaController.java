package com.romario.financa_api.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romario.financa_api.domain.model.Pessoa;
import com.romario.financa_api.domain.repository.PessoaRepository;
import com.romario.financa_api.domain.service.CadastroPessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CadastroPessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listar() {
		
		return pessoaRepository.findAll(); 
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long pessoaId) {
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
		
		if(pessoa.isPresent()) {
			return ResponseEntity.ok().body(pessoa.get());
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public Pessoa criar(@RequestBody Pessoa pessoa) {
		
		return pessoaService.salvar(pessoa);
	}
	
	@PutMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId,@RequestBody Pessoa pessoa){
		
		Optional<Pessoa> pessoaAtual = pessoaRepository.findById(pessoaId);
		
		if(pessoaAtual.isPresent()) {
			BeanUtils.copyProperties(pessoa, pessoaAtual.get(), "id");
			
			Pessoa pessoaSalva = pessoaService.salvar(pessoaAtual.get());
			
			return ResponseEntity.ok(pessoaSalva);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> deletar(@PathVariable Long pessoaId) {
		 
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
		
		if(pessoa.isPresent()) {
			
			pessoaRepository.deleteById(pessoaId);
			
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
}
