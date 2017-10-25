package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Aluno;

public interface AlunoService {
	public Aluno save(Aluno aluno);
	public void deleteById (Integer id);
	public void deleteByAll();
	public void deleteList(List<Aluno> alunos);
	public Aluno findById(Integer id);
	public List<Aluno> findByAll();

}
