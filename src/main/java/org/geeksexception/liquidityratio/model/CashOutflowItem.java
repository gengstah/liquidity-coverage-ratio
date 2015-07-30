package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("CASH_OUTFLOW_ITEMS")
public class CashOutflowItem extends CashOutflowComponent implements Serializable {
	
	private static final long serialVersionUID = 7148567126490568040L;
	
	@ManyToOne
	@JoinColumn(name="NOTE_ID", nullable = false)
	private Note note;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	private BigDecimal unweightedAmount;
	
	public CashOutflowItem(Note note, BigDecimal unweightedAmount) {
		this.note = note;
		this.unweightedAmount = unweightedAmount;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return note.getDescription();
	}
	
	@Override
	public Note getNote() {
		return note;
	}
	
	@Override
	public BigDecimal getUnweightedAmount() {
		return unweightedAmount;
	}
	
	@Override
	public BigDecimal getWeightedAmount() {
		return unweightedAmount.multiply(note.getWeight());
	}

	@Override
	public String toString() {
		return "CashOutflowItem [getId()=" + getId() + ", getName()="
				+ getName() + ", getUnweightedAmount()="
				+ getUnweightedAmount() + ", getWeightedAmount()="
				+ getWeightedAmount() + "]";
	}
	
}