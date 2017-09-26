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
import br.edu.fatec.model.Periodo;
import br.edu.fatec.services.PeriodoService;

@Transactional
@RestController
@RequestMapping(value = "/periodo")
public class PeriodoController {
	
	@Autowired
	private PeriodoService periodoService;
	
	public void setPeriodoService(PeriodoService periodoService) {
		this.periodoService = periodoService;
	}
	
	
	@RequestMapping(value="/findByAll")
	public ResponseEntity<Collection<Periodo>> findByAll(){
		return new ResponseEntity<Collection<Periodo>>(periodoService.findByAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findById/{id}")
	public ResponseEntity<Periodo> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<Periodo>(periodoService.findById(id),HttpStatus.OK);
	}	
	
	@RequestMapping(value="/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id){
		periodoService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteByAll")
	public ResponseEntity deleteByAll(){
		periodoService.deleteByAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public Periodo save(@RequestBody Periodo periodo,HttpServletRequest request, HttpServletResponse response){
		periodo = periodoService.save(periodo);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/periodo/findById?id=" + periodo.getPeriodoId());
		return periodo;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public ResponseEntity delete(@RequestBody List<Periodo> periodos,HttpServletRequest request, HttpServletResponse response){
		periodoService.deleteList(periodos);
		System.out.print(periodos.size());		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	

}
