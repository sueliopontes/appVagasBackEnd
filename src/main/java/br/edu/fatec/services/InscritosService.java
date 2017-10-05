package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Inscritos;

public interface InscritosService {
	public Inscritos save(Inscritos inscrito);

	public void deleteById(Integer id);

	public void deleteByAll();

	public void deleteList(List<Inscritos> inscritos);

	public Inscritos findById(Integer id);

	public List<Inscritos> findByAll();

}
