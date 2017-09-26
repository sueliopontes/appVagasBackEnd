package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Turma;

public interface TurmaService {
	public Turma save(Turma turma);

	public void deleteById(Integer id);

	public void deleteByAll();

	public void deleteList(List<Turma> turmas);

	public Turma findById(Integer id);

	public List<Turma> findByAll();

}
