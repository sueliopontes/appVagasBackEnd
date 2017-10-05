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
import com.fasterxml.jackson.annotation.JsonView;

import br.edu.fatec.view.StatusView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "status")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "statusId")
	@JsonView({ StatusView.Alternative.class })
	private int statusId;

	@Column(nullable = false, length = 60, name = "statusNome")
	@JsonView({ StatusView.Alternative.class })
	private String statusNome;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "status")
	@XmlElement(name = "inscritos")
	@JsonIgnore
	private Set<Inscritos> inscritos = new HashSet<Inscritos>(0);
	

}