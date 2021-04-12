package br.com.treinamento.atualizarcliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamento.atualizarcliente.model.Cliente;
import br.com.treinamento.atualizarcliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente getCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public void deleteCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
}
