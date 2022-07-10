package com.cg.ofr.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

import com.cg.ofr.entities.FlatAddress;
@Component
@Entity
@Table(name="flats")
public class FlatDto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer flatId;
	
	@Column
	@Min(value=300000,message="value should be above 300000")
	@Max(value=5000000,message="value should be below 5000000")
	private Double cost;
	
	@Column(name="availability")
	private String availability;
	
	@OneToOne(cascade=CascadeType.ALL)
	private FlatAddress flatAddress;
	
	public FlatDto() {}
	
	public FlatDto(Integer flatId, Double cost, String availability, FlatAddress flatAddress) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.availability = availability;
		this.flatAddress = flatAddress;
	}

	public Integer getFlatId() {
		return flatId;
	}
	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}
	public Double getCost() {
		return cost;
	}
	public  void setCost(Double cost) {
		this.cost = cost;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	@Override
	public String toString() {
		return "FlatDto [flatId=" + flatId + ", cost=" + cost + ", availability=" + availability + ", flatAddress="
				+ flatAddress + "]";
	}
	
   
}

