package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Status;
import br.edu.fatec.repositories.StatusRepository;

@Transactional
@Service("status")
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public Status save(Status status) {
		// TODO Auto-generated method stub
		return statusRepository.save(status);		
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.statusRepository.delete(id);
		
	}
	@Override
	public void deleteByAll() {
		// TODO Auto-generated method stub
		this.statusRepository.deleteAll();
		
	}
	@Override
	public Status findById(Integer id) {
		// TODO Auto-generated method stub
		return statusRepository.findOne(id);
		
	}
	
	@Override
	public Status findByStatusNome(String statusNome) {
		// TODO Auto-generated method stub
		return statusRepository.findByStatusNome(statusNome);
		
	}

	@Override
	public List<Status> findByAll() {
		// TODO Auto-generated method stub
		List<Status> statusList=new ArrayList<Status>();
		for (Status status:this.statusRepository.findAll()){
			statusList.add(status);
		}
		return statusList;
		
		
	}
	@Override
	public void deleteList(List<Status>statuss) {
		// TODO Auto-generated method stub		
		for (Status status:statuss){
			statusRepository.delete(status);
		}		
		
	}
	
	

}
