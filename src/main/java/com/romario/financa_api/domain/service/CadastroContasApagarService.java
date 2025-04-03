package com.romario.financa_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.romario.financa_api.domain.exception.EntidadeEmUsoException;
import com.romario.financa_api.domain.exception.EntidadeNaoEncontradaException;
import com.romario.financa_api.domain.model.ContasApagar;
import com.romario.financa_api.domain.repository.ContasApagarRepository;

@Service
public class CadastroContasApagarService {

	@Autowired
	private ContasApagarRepository contasApagarRepository;

	public ContasApagar salvar(ContasApagar contasApagar) {

		return contasApagarRepository.save(contasApagar);
	}

	public void excluir(Long contasId) {
		try {
			contasApagarRepository.deleteById(contasId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de Conta a Pagar com código %d", contasId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Conta a Paga de código %d não pode ser removida, pois esta em uso", contasId));
		}
	}
}
