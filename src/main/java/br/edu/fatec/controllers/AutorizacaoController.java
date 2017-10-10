package br.edu.fatec.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.model.Autorizacao;
import br.edu.fatec.services.AutorizacaoService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AutorizacaoController {
	
	@Autowired
	private AutorizacaoService autorizacaoService;

	public void setAutorizacaoService(AutorizacaoService autorizacaoService) {
		this.autorizacaoService = autorizacaoService;
	}
	
	@RequestMapping(value = "/autorizacao/{nome}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Collection<Autorizacao>> pesquisar(@PathVariable("nome") String nome) {
		return new ResponseEntity<Collection<Autorizacao>>(autorizacaoService.buscar(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/autorizacao/getAll")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Collection<Autorizacao>> getAll() {
		return new ResponseEntity<Collection<Autorizacao>>(autorizacaoService.todos(), HttpStatus.OK);
	}
	
}
