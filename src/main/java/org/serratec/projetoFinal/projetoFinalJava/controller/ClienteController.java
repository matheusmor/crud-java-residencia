package org.serratec.projetoFinal.projetoFinalJava.controller;

import java.util.List;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Cliente;
import org.serratec.projetoFinal.projetoFinalJava.exception.ClienteNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cliente")
	public List<Cliente> getCliente(){
		return clienteService.getAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente getCliente(@PathVariable Integer id) throws ClienteNotFoundException {
		return clienteService.getCliente(id);
	}
	@PostMapping("/cliente")
	public Cliente postLivro(@RequestBody Cliente cliente) {
		return clienteService.createCliente(cliente);
	}
	
	@PutMapping("/cliente/{id}")
	public Cliente putCliente(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
		return clienteService.updateCliente(id,cliente);
	}
	
	@DeleteMapping("/cliente/{id}")
	public Cliente deleteCliente(@PathVariable Integer id) throws ClienteNotFoundException {
		return clienteService.deleteCliente(id);
	}
	
}
