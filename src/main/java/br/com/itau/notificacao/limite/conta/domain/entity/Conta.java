package br.com.itau.notificacao.limite.conta.domain.entity;

import java.util.Random;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "conta", schema="limite")
public class Conta {
	 
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "agencia_conta")
	private Long agencia;
	
	@Column(name = "numero_conta")
	private Long numeroConta;
	
	@Column(name = "digito_conta")
	private Long digitoConta;
	
	@Column(name = "limite")
	private Double limite;
	
	@Column(name = "saldo")
	private Double saldo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Long generateId(Long agencia, Long digito, Long conta) {
		Long dac = new Random().nextLong();
		return dac+agencia+digito+conta;
	}

	public Conta(Long agencia, Long numeroConta, Long digitoConta, Double limite, Double saldo, Cliente cliente) {
		super();
		this.id = generateId(agencia, digitoConta, digitoConta);
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.digitoConta = digitoConta;
		this.limite = limite;
		this.saldo = saldo;
		this.cliente = cliente;
	}

}
