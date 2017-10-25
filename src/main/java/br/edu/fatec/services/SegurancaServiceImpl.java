package br.edu.fatec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.edu.fatec.model.Usuario;
import br.edu.fatec.repositories.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByNome(username);
		if(usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return usuario;
	}

}
