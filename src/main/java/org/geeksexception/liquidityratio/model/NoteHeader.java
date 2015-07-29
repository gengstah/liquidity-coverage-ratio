package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTE_HEADER")
public class NoteHeader implements Serializable {
	
	private static final long serialVersionUID = 5101686540781800974L;
	
	@Id
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false, length = 500)
	private String name;
	
	public NoteHeader() { }
	
	public NoteHeader(Long id, String name) { this.id = id; this.name = name; }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}