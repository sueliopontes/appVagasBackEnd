package br.edu.fatec.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.fatec.model.Autorizacao;

public interface AutorizacaoRepository extends CrudRepository<Autorizacao, Long> {

	public List<Autorizacao> findByNomeContainsIgnoreCase(String nome);
	
}
