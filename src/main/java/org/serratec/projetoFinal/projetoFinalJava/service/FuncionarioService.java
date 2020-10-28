package org.serratec.projetoFinal.projetoFinalJava.service;

import java.util.List;
import java.util.Optional;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Funcionario;
import org.serratec.projetoFinal.projetoFinalJava.exception.FuncionarioNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionariosRepository;

	public List<Funcionario> getAll() {
		List<Funcionario> funcionarios = funcionariosRepository.findAll();
		return funcionarios;
	}

	private Funcionario findFuncionario(Integer id) throws FuncionarioNotFoundException {
		Optional<Funcionario> achado = funcionariosRepository.findById(id);
		if (!achado.isPresent()) {
			throw new FuncionarioNotFoundException(id);
		}
		return achado.get();

	}

	public Funcionario getFuncionario(Integer id) throws FuncionarioNotFoundException {
		return findFuncionario(id);
	}

	public Funcionario updateFuncionario(Integer id, Funcionario funcionarioNovo) throws FuncionarioNotFoundException {
		Funcionario achado = findFuncionario(id);
		if (funcionarioNovo.getCodigo() != null)
			achado.setCodigo(funcionarioNovo.getCodigo());
		if (funcionarioNovo.getNome() != null)
			achado.setNome(funcionarioNovo.getNome());
		if (funcionarioNovo.getCpf() != null)
			achado.setCpf(funcionarioNovo.getCpf());
		
		
		achado = funcionariosRepository.save(achado);
		return achado;

	}
	public Funcionario deleteFuncionario(Integer id) throws FuncionarioNotFoundException {
		Funcionario funcionario =findFuncionario(id);
		funcionariosRepository.delete(funcionario);
		return funcionario;
	}

	public Funcionario createFuncionario(Funcionario funcionario) {
		Funcionario obj= funcionariosRepository.save(funcionario);
		return obj;
	}
}
