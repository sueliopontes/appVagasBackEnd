package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Aluno;
import br.edu.fatec.repositories.AlunoRepository;

@Transactional
@Service("aluno")
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Aluno save(Aluno aluno) {
		// TODO Auto-generated method stub
		return alunoRepository.save(aluno);		
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.alunoRepository.delete(id);
		
	}
	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		this.alunoRepository.deleteAll();
		
	}
	@Override
	public Aluno findById(Integer id) {
		// TODO Auto-generated method stub
		return alunoRepository.findOne(id);
		
	}

	@Override
	public List<Aluno> findByAll() {
		// TODO Auto-generated method stub
		List<Aluno> alunoList=new ArrayList<Aluno>();
		for (Aluno aluno:this.alunoRepository.findAll()){
			alunoList.add(aluno);
		}
		return alunoList;
		
		
	}
	@Override
	public void deleteList(List<Aluno>alunos) {
		// TODO Auto-generated method stub		
		for (Aluno aluno:alunos){
			alunoRepository.delete(aluno);
		}		
		
	}
	
	

}
