package br.edu.fatec.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.edu.fatec.model.Inscritos;
import br.edu.fatec.services.InscritosService;
import br.edu.fatec.view.InscritoView;

@Transactional
@RestController

@RequestMapping(value = "/inscritos")
public class InscritosController {
	@Autowired
	private InscritosService inscritosService;

	public void setInscritosService(InscritosService inscritosService) {
		this.inscritosService = inscritosService;
	}
	@CrossOrigin(methods= {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.PATCH,RequestMethod.TRACE,
			RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT},origins="*",maxAge=3600)
	@RequestMapping(value = "/findByAll")
	public ResponseEntity<Collection<Inscritos>> findByAll() {
		return new ResponseEntity<Collection<Inscritos>>(inscritosService.findByAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/findById/{id}")
	public ResponseEntity<Inscritos> findById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Inscritos>(inscritosService.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id) {
		inscritosService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteByAll")
	public ResponseEntity deleteByAll() {
		inscritosService.deleteByAll();
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Inscritos save(@RequestBody Inscritos inscritos, HttpServletRequest request, HttpServletResponse response) {
		System.out.print(inscritos);
		inscritos = inscritosService.save(inscritos);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/inscritos/findById?id=" + inscritos.getInscritoId());
		return inscritos;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity delete(@RequestBody List<Inscritos> inscritos, HttpServletRequest request,
			HttpServletResponse response) {
		inscritosService.deleteList(inscritos);
		System.out.print(inscritos.size());
		return new ResponseEntity(HttpStatus.OK);
	}

}
