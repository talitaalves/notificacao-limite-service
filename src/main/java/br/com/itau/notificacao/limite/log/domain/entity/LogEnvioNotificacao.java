package br.com.itau.notificacao.limite.log.domain.entity;

import br.com.itau.notificacao.limite.cliente.domain.entity.Cliente;
import br.com.itau.notificacao.limite.conta.domain.entity.Conta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "log_envio_notificacao", schema="limite")
public class LogEnvioNotificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	  
	@Column(name = "ds_notificacao", nullable = false, length = 100)
	private String mensagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;	  
	  
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_conta")
	private Conta conta;
	  
}
