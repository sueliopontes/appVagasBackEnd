package br.edu.fatec.services;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import br.edu.fatec.model.Turma;

public interface TurmaService {
	public Turma save(Turma turma);

	public void deleteById(Integer id);

	public void deleteByAll();

	public void deleteList(List<Turma> turmas);

	public Turma findById(Integer id);

	public List<Turma> findByAll();

}
