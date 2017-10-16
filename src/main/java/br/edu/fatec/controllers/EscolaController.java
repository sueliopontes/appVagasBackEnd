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
import br.edu.fatec.model.Escola;
import br.edu.fatec.services.EscolaService;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/escola")
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;
	
	public void setEscolaService(EscolaService escolaService) {
		this.escolaService = escolaService;
	}	
	
	@RequestMapping(value="/findByAll")	
	@CrossOrigin(methods= {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.PATCH,RequestMethod.TRACE,
			RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT},origins="*",maxAge=3600)
	public ResponseEntity<Collection<Escola>> findByAll(){
		return new ResponseEntity<Collection<Escola>>(escolaService.findByAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findById/{id}")
	public ResponseEntity<Escola> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<Escola>(escolaService.findById(id),HttpStatus.OK);
	}	
	
	@RequestMapping(value="/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id){
		escolaService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteByAll")
	public ResponseEntity deleteByAll(){
		escolaService.deleteByAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public Escola save(@RequestBody Escola escola,HttpServletRequest request, HttpServletResponse response){
		escola = escolaService.save(escola);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/escola/findById?id=" + escola.getEscolaId());
		return escola;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public ResponseEntity delete(@RequestBody List<Escola> escolas,HttpServletRequest request, HttpServletResponse response){
		escolaService.deleteList(escolas);
		System.out.print(escolas.size());		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	

}
