package br.com.treinamento.atualizarcliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinamento.atualizarcliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
