package br.edu.fatec.services;

import java.util.List;

import br.edu.fatec.model.Status;

public interface StatusService {
	public Status save(Status status);
	public void deleteById (Integer id);
	public void deleteByAll();
	public void deleteList(List<Status> statuss);
	public Status findById(Integer id);
	public Status findByStatusNome(String statusNome);
	public List<Status> findByAll();

}
