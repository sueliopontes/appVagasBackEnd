package br.edu.fatec.repositories;

import org.springframework.data.repository.CrudRepository;


import br.edu.fatec.model.Status;
import br.edu.fatec.model.Usuario;

public interface StatusRepository extends CrudRepository<Status,Integer>{
	
	public Status findByStatusNome(String status);

}