package br.edu.fatec.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.edu.fatec.model.Turma;
import br.edu.fatec.services.TurmaService;
import br.edu.fatec.view.TurmaView;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	public void setTurmaService(TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
	@CrossOrigin(methods= {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.PATCH,RequestMethod.TRACE,
			RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT},origins="*",maxAge=3600)
	@RequestMapping(value="/findByAll")
	@JsonView({TurmaView.Alternative.class})
	public ResponseEntity<Collection<Turma>> findByAll(){
		return new ResponseEntity<Collection<Turma>>(turmaService.findByAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findById/{id}")
	public ResponseEntity<Turma> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<Turma>(turmaService.findById(id),HttpStatus.OK);
	}	
	
	@RequestMapping(value="/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id){
		turmaService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteByAll")
	public ResponseEntity deleteByAll(){
		turmaService.deleteByAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public Turma save(@RequestBody Turma turma,HttpServletRequest request, HttpServletResponse response){
		System.out.print(turma);
		turma = turmaService.save(turma);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/turma/findById?id=" + turma.getTurmaId());
		return turma;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public ResponseEntity delete(@RequestBody List<Turma> turmas,HttpServletRequest request, HttpServletResponse response){
		turmaService.deleteList(turmas);
		System.out.print(turmas.size());		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	

}
