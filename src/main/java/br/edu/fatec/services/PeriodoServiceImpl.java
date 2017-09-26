package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Periodo;
import br.edu.fatec.repositories.PeriodoRepository;

@Transactional
@Service("periodo")
public class PeriodoServiceImpl implements PeriodoService {
	
	@Autowired
	private PeriodoRepository periodoRepository;

	@Override
	public Periodo save(Periodo periodo) {
		// TODO Auto-generated method stub
		return periodoRepository.save(periodo);		
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.periodoRepository.delete(id);
		
	}
	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		this.periodoRepository.deleteAll();
		
	}
	@Override
	public Periodo findById(Integer id) {
		// TODO Auto-generated method stub
		return periodoRepository.findOne(id);
		
	}

	@Override
	public List<Periodo> findByAll() {
		// TODO Auto-generated method stub
		List<Periodo> periodoList=new ArrayList<Periodo>();
		for (Periodo periodo:this.periodoRepository.findAll()){
			periodoList.add(periodo);
		}
		return periodoList;
		
		
	}
	@Override
	public void deleteList(List<Periodo>periodos) {
		// TODO Auto-generated method stub		
		for (Periodo periodo:periodos){
			periodoRepository.delete(periodo);
		}		
		
	}
	
	

}
