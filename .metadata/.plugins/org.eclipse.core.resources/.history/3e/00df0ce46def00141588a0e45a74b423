package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the template_colors database table.
 * 
 */
@Entity
@Table(name="template_colors")
@NamedQuery(name="TemplateColor.findAll", query="SELECT t FROM TemplateColor t")
public class TemplateColor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_template_color")
	private int idTemplateColor;

	//bi-directional many-to-one association to Template
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_template")
	private Template template;

	public TemplateColor() {
	}

	public int getIdTemplateColor() {
		return this.idTemplateColor;
	}

	public void setIdTemplateColor(int idTemplateColor) {
		this.idTemplateColor = idTemplateColor;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

}