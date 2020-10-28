package org.serratec.projetoFinal.projetoFinalJava.controller;

import java.util.List;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Funcionario;
import org.serratec.projetoFinal.projetoFinalJava.exception.FuncionarioNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/funcionario")
	public List<Funcionario> getFuncionario(){
		return funcionarioService.getAll();
	}
	
	@GetMapping("/funcionario/{id}")
	public Funcionario getFuncionario(@PathVariable Integer id) throws FuncionarioNotFoundException {
		return funcionarioService.getFuncionario(id);
	}
	@PostMapping("/funcionario")
	public Funcionario postFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.createFuncionario(funcionario);
	}
	
	@PutMapping("/funcionario/{id}")
	public Funcionario putFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
		return funcionarioService.updateFuncionario(id,funcionario);
	}
	
	@DeleteMapping("/funcionario/{id}")
	public Funcionario deleteFuncionario(@PathVariable Integer id) throws FuncionarioNotFoundException {
		return funcionarioService.deleteFuncionario(id);
	}
}
