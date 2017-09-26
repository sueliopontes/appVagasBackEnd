package br.edu.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "AUT_AUTORIZACAO")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Autorizacao implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUT_ID")
	private int id;

	@Column(name = "AUT_NOME", unique = true, length = 20, nullable = false)
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}

	public void setAuthority(String authority) {
		this.nome = authority;
	}

}
