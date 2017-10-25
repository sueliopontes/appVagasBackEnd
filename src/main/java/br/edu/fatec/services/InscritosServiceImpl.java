package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Inscritos;
import br.edu.fatec.model.Turma;
import br.edu.fatec.repositories.InscritosRepository;
import br.edu.fatec.repositories.TurmaRepository;

@Transactional
@Service("inscritos")
public class InscritosServiceImpl implements InscritosService{

	@Autowired
	private InscritosRepository inscritosRepository;
	
	@Override
	public Inscritos save(Inscritos inscrito) {
		// TODO Auto-generated method stub
		return inscritosRepository.save(inscrito);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		inscritosRepository.delete(id);
		
	}

	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		inscritosRepository.deleteAll();
		
	}

	@Override
	public void deleteList(List<Inscritos> inscritos) {
		// TODO Auto-generated method stub
		for(Inscritos inscrito:inscritos) {
			inscritosRepository.delete(inscrito);
		}
		
		
	}

	@Override
	public Inscritos findById(Integer id) {
		// TODO Auto-generated method stub
		return inscritosRepository.findOne(id);
	}

	@Override
	public List<Inscritos> findByAll() {
		// TODO Auto-generated method stub
		List<Inscritos> inscritos=new ArrayList<Inscritos>();
		for (Inscritos inscrito: this.inscritosRepository.findAll()) {
			inscritos.add(inscrito);
		}
		return inscritos;
	}

	@Override
	public List<Inscritos> findByEscola(Integer id) {
		List<Inscritos> inscritos=new ArrayList<Inscritos>();
		for (Inscritos inscrito: this.inscritosRepository.findAll()) {
			if (inscrito.getTurma().getEscola().getEscolaId()==id){
				inscritos.add(inscrito);
			}
		}
		return inscritos;
	}

}
