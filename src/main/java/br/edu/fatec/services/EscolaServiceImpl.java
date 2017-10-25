package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Escola;
import br.edu.fatec.repositories.EscolaRepository;

@Transactional
@Service("escola")
public class EscolaServiceImpl implements EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;

	@Override
	public Escola save(Escola escola) {
		// TODO Auto-generated method stub
		return escolaRepository.save(escola);		
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.escolaRepository.delete(id);
		
	}
	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		this.escolaRepository.deleteAll();
		
	}
	@Override
	public Escola findById(Integer id) {
		// TODO Auto-generated method stub
		return escolaRepository.findOne(id);
		
	}

	@Override
	public List<Escola> findByAll() {
		// TODO Auto-generated method stub
		List<Escola> escolaList=new ArrayList<Escola>();
		for (Escola escola:this.escolaRepository.findAll()){
			escolaList.add(escola);
		}
		return escolaList;
		
		
	}
	@Override
	public void deleteList(List<Escola>escolas) {
		// TODO Auto-generated method stub		
		for (Escola escola:escolas){
			escolaRepository.delete(escola);
		}		
		
	}
	
	

}
