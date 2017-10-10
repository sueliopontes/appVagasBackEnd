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
import br.edu.fatec.model.Ano;
import br.edu.fatec.services.AnoLetivoService;

@Transactional
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/anoLetivo")
public class AnoLetivoController {
	
	@Autowired
	private AnoLetivoService anoLetivoService;
	
	public void setAnoLetivoService(AnoLetivoService anoLetivoService) {
		this.anoLetivoService = anoLetivoService;
	}
	
	
	@RequestMapping(value="/findByAll")
	public ResponseEntity<Collection<Ano>> findByAll(){
		return new ResponseEntity<Collection<Ano>>(anoLetivoService.findByAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findById/{id}")
	public ResponseEntity<Ano> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<Ano>(anoLetivoService.findById(id),HttpStatus.OK);
	}	
	
	@RequestMapping(value="/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id){
		anoLetivoService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteByAll")
	public ResponseEntity deleteByAll(){
		anoLetivoService.deleteByAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public Ano save(@RequestBody Ano anoLetivo,HttpServletRequest request, HttpServletResponse response){
		anoLetivo = anoLetivoService.save(anoLetivo);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/anoLetivo/findById?id=" + anoLetivo.getAnoId());
		return anoLetivo;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public ResponseEntity delete(@RequestBody List<Ano> anoLetivos,HttpServletRequest request, HttpServletResponse response){
		anoLetivoService.deleteList(anoLetivos);
		System.out.print(anoLetivos.size());		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	

}
