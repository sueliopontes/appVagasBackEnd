package br.edu.fatec.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aluno")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "alunoId")
	private int id;

	@Column(nullable = false, length = 60, name = "alunoNome")
	private String nome;

	@Column(nullable = false, length = 60, name = "alunoMae")
	private String mae;

	@Column(nullable = false, length = 60, name = "alunoDtNasc")
	private String dataNascimento;	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "aluno")
	@XmlElement(name = "inscritos")
	@JsonIgnore
	private Set<Inscritos> inscritos = new HashSet<Inscritos>(0);

}
