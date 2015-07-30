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
@DiscriminatorValue("CASH_OUTFLOW_CATEGORY")
public class CashOutflowCategory extends CashOutflowComponent implements Serializable {
	
	private static final long serialVersionUID = 7943612850604696943L;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name="CASH_OUTFLOW_COMPONENT_ID")
	private List<CashOutflowComponent> cashOutflowComponents = new ArrayList<CashOutflowComponent>();
	
	public CashOutflowCategory(String name) { this.name = name; }
	
	@Override
	public void add(CashOutflowComponent cashOutflowComponent) {
		cashOutflowComponents.add(cashOutflowComponent);
	}
	
	@Override
	public void remove(CashOutflowComponent cashOutflowComponent) {
		cashOutflowComponents.remove(cashOutflowComponent);
	}
	
	@Override
	public CashOutflowComponent getChild(Long noteId) {
		CashOutflowComponent child = null;
		
		for(CashOutflowComponent cashOutflowComponent : cashOutflowComponents) {
			if(cashOutflowComponent instanceof CashOutflowCategory) {
				child = cashOutflowComponent.getChild(noteId);
				if(child != null) return child;
			} else if(cashOutflowComponent instanceof CashOutflowItem) {
				if(cashOutflowComponent.getNote().getNoteId().equals(noteId)) return cashOutflowComponent;
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
		
		for(CashOutflowComponent cashOutflowComponent : cashOutflowComponents) {
			totalUnweightedAmount = totalUnweightedAmount.add(cashOutflowComponent.getUnweightedAmount());
		}
		
		return totalUnweightedAmount;
	}
	
	@Override
	public BigDecimal getWeightedAmount() {
		BigDecimal totalWeightedAmount = BigDecimal.ZERO;
		
		for(CashOutflowComponent cashOutflowComponent : cashOutflowComponents) {
			totalWeightedAmount = totalWeightedAmount.add(cashOutflowComponent.getWeightedAmount());
		}
		
		return totalWeightedAmount;
	}
	
}