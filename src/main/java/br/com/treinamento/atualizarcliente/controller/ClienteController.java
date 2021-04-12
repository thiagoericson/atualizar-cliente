package br.com.treinamento.atualizarcliente.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.atualizarcliente.model.Cliente;
import br.com.treinamento.atualizarcliente.model.Salario;
import br.com.treinamento.atualizarcliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	// PUT
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		try {
			Cliente clienteAtual = clienteService.getCliente(id);
			cliente.setId(clienteAtual.getId());
			clienteService.saveCliente(cliente);
			return new ResponseEntity<>(HttpStatus.OK); // 200
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND); // 404
		}
	}

	// PATCH localhost:8083/clientes/8/salario > > > > > > > > > > > > 
	@PatchMapping("/{id}/salario")
	public ResponseEntity<?> updateSalario(@PathVariable Integer id, @RequestBody Salario salario) {
		try {
			// TODO: chamar o outro micro-serviço de consulta cliente > Service > Client > Consultar Cliente
			Cliente clienteAtual = clienteService.getCliente(id);
			clienteAtual.setId(clienteAtual.getId());
			clienteAtual.setSalario(salario.getSalario());
			clienteService.saveCliente(clienteAtual);
			return new ResponseEntity<>(HttpStatus.OK); // 200
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND); // 404
		}
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			// TODO: chamar o outro micro-serviço de consulta cliente > Service > Client > Consultar Cliente
			Cliente clienteAtual = clienteService.getCliente(id);
			clienteService.deleteCliente(clienteAtual.getId());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
		}
	}
}
