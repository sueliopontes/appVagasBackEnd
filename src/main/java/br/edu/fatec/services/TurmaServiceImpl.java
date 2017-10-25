package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Turma;
import br.edu.fatec.repositories.TurmaRepository;

@Transactional
@Service("turma")
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	@Override
	public Turma save(Turma turma) {
		// TODO Auto-generated method stub
		return turmaRepository.save(turma);		
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.turmaRepository.delete(id);
		
	}
	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		this.turmaRepository.deleteAll();
		
	}
	@Override
	public Turma findById(Integer id) {
		// TODO Auto-generated method stub
		return turmaRepository.findOne(id);
		
	}

	@Override
	public List<Turma> findByAll() {
		// TODO Auto-generated method stub
		List<Turma> turmaList=new ArrayList<Turma>();
		for (Turma turma:this.turmaRepository.findAll()){
			turmaList.add(turma);
		}
		return turmaList;
		
		
	}
	@Override
	public void deleteList(List<Turma>turmas) {
		// TODO Auto-generated method stub		
		for (Turma turma:turmas){
			turmaRepository.delete(turma);
		}		
		
	}
	
	

}
