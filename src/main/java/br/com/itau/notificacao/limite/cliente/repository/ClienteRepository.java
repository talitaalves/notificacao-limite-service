package br.com.itau.notificacao.limite.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
