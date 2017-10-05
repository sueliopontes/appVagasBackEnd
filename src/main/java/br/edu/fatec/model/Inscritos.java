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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;
import br.edu.fatec.view.InscritoView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "inscrito")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Inscritos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "inscritoId")
	@JsonView({ InscritoView.Alternative.class })
	private int inscritoId;	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statusId")
	@JsonView({ InscritoView.Alternative.class })
	private Status status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alunoId")
	@JsonView({ InscritoView.Alternative.class })
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "turmaId")
	@JsonView({ InscritoView.Alternative.class })
	private Turma turma;

}
