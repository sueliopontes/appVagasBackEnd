package br.edu.fatec.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

import br.edu.fatec.view.TurmaView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "turma")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "turmaId")
	@JsonView({ TurmaView.Alternative.class })
	private int turmaId;

	@Column(nullable = false, length = 60, name = "turmaNome")
	@JsonView({ TurmaView.Alternative.class })
	private String turmaNome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "anoId")
	@JsonView({ TurmaView.Alternative.class })
	private Ano ano;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "escolaId")
	@JsonView({ TurmaView.Alternative.class })
	private Escola escola;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "periodoId")
	@JsonView({ TurmaView.Alternative.class })
	private Periodo periodo;

}