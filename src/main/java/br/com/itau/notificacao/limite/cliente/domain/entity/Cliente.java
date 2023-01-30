package br.com.itau.notificacao.limite.cliente.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "cliente", schema="limite")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private Long id;
	  
	  @Column(name = "nm_cliente", nullable = false, length = 100)
	  private String nome;
	  
	  @Column(name = "ds_email", nullable = false, length = 100)
	  private String email;	  
	  
}
