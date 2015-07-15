package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "PERFORMING_EXPOSURE")
public class PerformingExposure implements Serializable {
	
	private static final long serialVersionUID = -6068767609255537135L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	public PerformingExposure() { }

}