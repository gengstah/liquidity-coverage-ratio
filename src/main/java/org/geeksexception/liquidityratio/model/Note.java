package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NOTE")
public class Note implements Serializable {
	
	private static final long serialVersionUID = -999933857875787599L;
	
	@Id
	@Column(name = "NOTE_ID", nullable = false)
	private Long noteId;
	
	@Column(name = "DESCRIPTION", nullable = false, length = 500)
	private String description;
	
	@Column(name = "WEIGHT", nullable = false)
	private BigDecimal weight;
	
	@ManyToOne
	@JoinColumn(name="NOTE_HEADER_ID")
	private NoteHeader noteHeader;
	
	public Note() { }
	
	public Note(Long noteId, String description, BigDecimal weight) {
		this.noteId = noteId;
		this.description = description;
		this.weight = weight;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", description=" + description
				+ ", weight=" + weight + ", noteHeader=" + noteHeader + "]";
	}
	
}