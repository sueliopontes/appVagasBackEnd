package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.fatec.model.Usuario;
import br.edu.fatec.repositories.UsuarioRepository;

@Transactional
@Service("usuario")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findByAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(Usuario usuario:this.usuarioRepository.findAll()){
			usuarios.add(usuario);			
		}
		return usuarios;
		
	}
	

}
