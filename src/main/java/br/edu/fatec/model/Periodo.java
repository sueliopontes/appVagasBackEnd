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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.edu.fatec.model.Turma;
import br.edu.fatec.view.TurmaView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "periodo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "periodoId")
	@JsonView({TurmaView.Alternative.class})
	private int periodoId;

	@Column(nullable = false, length = 60, name = "periodoNome")
	@JsonView({TurmaView.Alternative.class})
	private String periodoNome;

	@OneToMany(fetch = FetchType.EAGER,mappedBy = "periodo")
	@XmlElement(name = "turmas")
	@JsonIgnore
	private Set<Turma> turmas = new HashSet<Turma>(0);	
	
}