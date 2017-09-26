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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.edu.fatec.model.Status;
import br.edu.fatec.services.StatusService;

@Transactional
@RestController
@RequestMapping(value = "/status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}
	
	
	@RequestMapping(value="/findByAll")
	public ResponseEntity<Collection<Status>> findByAll(){
		return new ResponseEntity<Collection<Status>>(statusService.findByAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findById/{id}")
	public ResponseEntity<Status> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<Status>(statusService.findById(id),HttpStatus.OK);
	}	
	
	@RequestMapping(value="/deleteById/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Integer id){
		statusService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteByAll")
	public ResponseEntity deleteByAll(){
		statusService.deleteByAll();
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public Status save(@RequestBody Status status,HttpServletRequest request, HttpServletResponse response){
		status = statusService.save(status);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/status/findById?id=" + status.getStatusId());
		return status;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseStatus(HttpStatus.CREATED)	
	public ResponseEntity delete(@RequestBody List<Status> statuss,HttpServletRequest request, HttpServletResponse response){
		statusService.deleteList(statuss);
		System.out.print(statuss.size());		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	

}
