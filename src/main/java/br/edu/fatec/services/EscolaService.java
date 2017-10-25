package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Escola;

public interface EscolaService {
	public Escola save(Escola escola);
	public void deleteById (Integer id);
	public void deleteByAll();
	public void deleteList(List<Escola> escolas);
	public Escola findById(Integer id);
	public List<Escola> findByAll();

}
