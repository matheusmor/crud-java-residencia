package org.serratec.projetoFinal.projetoFinalJava.service;

import java.util.List;
import java.util.Optional;

import org.serratec.projetoFinal.projetoFinalJava.entidades.Cliente;
import org.serratec.projetoFinal.projetoFinalJava.exception.ClienteNotFoundException;
import org.serratec.projetoFinal.projetoFinalJava.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClienteService {
	@Autowired
	private ClientesRepository clientesRepository;

	public List<Cliente> getAll() {
		List<Cliente> livros = clientesRepository.findAll();
		return livros;
	}

	private Cliente findCliente(Integer id) throws ClienteNotFoundException {
		Optional<Cliente> achado = clientesRepository.findById(id);
		if (!achado.isPresent()) {
			throw new ClienteNotFoundException(id);
		}
		return achado.get();

	}

	public Cliente getCliente(Integer id) throws ClienteNotFoundException {
		return findCliente(id);
	}

	public Cliente updateCliente(Integer id, Cliente clienteNovo) throws ClienteNotFoundException {
		Cliente achado = findCliente(id);
		if (clienteNovo.getId() != null)
			achado.setId(clienteNovo.getId());
		if (clienteNovo.getNome_completo() != null)
			achado.setNome_completo(clienteNovo.getNome_completo());
		if (clienteNovo.getNome_usuario() != null)
			achado.setNome_usuario(clienteNovo.getNome_usuario());
		if (clienteNovo.getEmail() != null)
			achado.setEmail(clienteNovo.getEmail());
		if (clienteNovo.getCpf() != null)
			achado.setCpf(clienteNovo.getCpf());
		if (clienteNovo.getData_nascimento() != null)
			achado.setData_nascimento(clienteNovo.getData_nascimento());
		if (clienteNovo.getEndereco() != null)
			achado.setEndereco(clienteNovo.getEndereco());
		
		achado = clientesRepository.save(achado);
		return achado;

	}
	public Cliente deleteCliente(Integer id) throws ClienteNotFoundException {
Cliente cliente =findCliente(id);
		clientesRepository.delete(cliente);
		return cliente;
	}

	public Cliente createCliente(Cliente cliente) {
		Cliente obj= clientesRepository.save(cliente);
		return obj;
	}
}
