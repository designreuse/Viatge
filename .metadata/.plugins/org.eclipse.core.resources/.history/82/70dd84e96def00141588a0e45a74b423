package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the presentation database table.
 * 
 */
@Entity
@Table(name="presentation")
@NamedQuery(name="Presentation.findAll", query="SELECT p FROM Presentation p")
public class Presentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_presentation")
	private int idPresentation;

	private String description;

	//bi-directional many-to-one association to Template
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_template")
	private Template template;

	public Presentation() {
	}

	public int getIdPresentation() {
		return this.idPresentation;
	}

	public void setIdPresentation(int idPresentation) {
		this.idPresentation = idPresentation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}