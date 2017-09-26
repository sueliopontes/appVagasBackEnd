package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Ano;

public interface AnoLetivoService {
	public Ano save(Ano anoLetivo);

	public void deleteById(Integer id);

	public void deleteByAll();

	public void deleteList(List<Ano> anoLetivos);

	public Ano findById(Integer id);

	public List<Ano> findByAll();

}
