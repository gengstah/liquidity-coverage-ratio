package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "CASH_INFLOW")
@Inheritance
@DiscriminatorColumn(name="CASH_INFLOW_TYPE")
public abstract class CashInflowComponent implements Serializable {

	private static final long serialVersionUID = 255358250010018109L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected Long id;
	
	public CashInflowComponent() { }
	
	public void add(CashInflowComponent cashInflowComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(CashInflowComponent cashInflowComponent) {
		throw new UnsupportedOperationException();
	}
	
	public CashInflowComponent getChild(Long noteId) {
		throw new UnsupportedOperationException();
	}
	
	public Long getId() {
		throw new UnsupportedOperationException();
	}
	
	public String getName() {
		throw new UnsupportedOperationException();
	}
	
	public BigDecimal getUnweightedAmount() {
		throw new UnsupportedOperationException();
	}
	
	public BigDecimal getWeightedAmount() {
		throw new UnsupportedOperationException();
	}
	
	public Note getNote() {
		throw new UnsupportedOperationException();
	}
}