package br.edu.fatec.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.model.Aluno;
import br.edu.fatec.model.Usuario;
import br.edu.fatec.services.UsuarioService;


@CrossOrigin
@Transactional
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin(methods= {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.PATCH,RequestMethod.TRACE,
			RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT},origins="*",maxAge=3600)
	@RequestMapping(value="/findByAll")	
	public ResponseEntity<Collection<Usuario>> findByAll(){
		return new ResponseEntity<Collection<Usuario>>(usuarioService.findByAll(),HttpStatus.OK);
	}
	

}
