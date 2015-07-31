package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("CASH_INFLOW_CATEGORY")
public class CashInflowCategory extends CashInflowComponent implements Serializable {
	
	private static final long serialVersionUID = 7021456543821696716L;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name="CASH_OUTFLOW_COMPONENT_ID")
	private List<CashInflowComponent> cashInflowComponents = new ArrayList<CashInflowComponent>();
	
	public CashInflowCategory(String name) { this.name = name; }
	
	@Override
	public void add(CashInflowComponent cashInflowComponent) {
		cashInflowComponents.add(cashInflowComponent);
	}
	
	@Override
	public void remove(CashInflowComponent cashInflowComponent) {
		cashInflowComponents.remove(cashInflowComponent);
	}
	
	@Override
	public CashInflowComponent getChild(Long noteId) {
		CashInflowComponent child = null;
		
		for(CashInflowComponent cashInflowComponent : cashInflowComponents) {
			if(cashInflowComponent instanceof CashInflowCategory) {
				child = cashInflowComponent.getChild(noteId);
				if(child != null) return child;
			} else if(cashInflowComponent instanceof CashInflowItem) {
				if(cashInflowComponent.getNote().getNoteId().equals(noteId)) return cashInflowComponent;
			}
		}
		
		return child;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public BigDecimal getUnweightedAmount() {
		BigDecimal totalUnweightedAmount = BigDecimal.ZERO;
		
		for(CashInflowComponent cashInflowComponent : cashInflowComponents) {
			totalUnweightedAmount = totalUnweightedAmount.add(cashInflowComponent.getUnweightedAmount());
		}
		
		return totalUnweightedAmount;
	}
	
	@Override
	public BigDecimal getWeightedAmount() {
		BigDecimal totalWeightedAmount = BigDecimal.ZERO;
		
		for(CashInflowComponent cashInflowComponent : cashInflowComponents) {
			totalWeightedAmount = totalWeightedAmount.add(cashInflowComponent.getWeightedAmount());
		}
		
		return totalWeightedAmount;
	}
	
}