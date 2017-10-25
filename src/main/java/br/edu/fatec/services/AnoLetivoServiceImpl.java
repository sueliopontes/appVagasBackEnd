package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Ano;
import br.edu.fatec.repositories.AnoLetivoRepository;

@Transactional
@Service("anoLetivo")
public class AnoLetivoServiceImpl implements AnoLetivoService {
	
	@Autowired
	private AnoLetivoRepository anoLetivoRepository;

	@Override
	public Ano save(Ano anoLetivo) {
		// TODO Auto-generated method stub
		return anoLetivoRepository.save(anoLetivo);		
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.anoLetivoRepository.delete(id);
		
	}
	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		this.anoLetivoRepository.deleteAll();
		
	}
	@Override
	public Ano findById(Integer id) {
		// TODO Auto-generated method stub
		return anoLetivoRepository.findOne(id);
		
	}

	@Override
	public List<Ano> findByAll() {
		// TODO Auto-generated method stub
		List<Ano> anoLetivoList=new ArrayList<Ano>();
		for (Ano anoLetivo:this.anoLetivoRepository.findAll()){
			anoLetivoList.add(anoLetivo);
		}
		return anoLetivoList;
		
		
	}
	@Override
	public void deleteList(List<Ano>anoLetivos) {
		// TODO Auto-generated method stub		
		for (Ano anoLetivo:anoLetivos){
			anoLetivoRepository.delete(anoLetivo);
		}		
		
	}
	
	

}
