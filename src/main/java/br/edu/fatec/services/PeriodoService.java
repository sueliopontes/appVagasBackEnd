package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Periodo;

public interface PeriodoService {
	public Periodo save(Periodo periodo);

	public void deleteById(Integer id);

	public void deleteByAll();

	public void deleteList(List<Periodo> periodos);

	public Periodo findById(Integer id);

	public List<Periodo> findByAll();

}
