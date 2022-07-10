package com.cg.ofr.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import com.cg.ofr.entities.User;

@Entity
@Component
@Table(name="landlord")

public class LandlordDto{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer landlordId;
	
	@Column
	@NotEmpty(message = "Landlord name is required")
	private String landlordName;
	
	@Column
	private int landlordAge;
	  
	  @OneToMany
	  @JoinTable
	  private List<FlatDto> flatList;
	 
	
	@OneToOne
	private User user;
	
	public LandlordDto() {}

	public LandlordDto(Integer landlordId, String landlordName,int landlordAge, List<FlatDto> flatList, User user) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
		this.user = user;
	}

	public Integer getLandlordId() {
		return landlordId;
	}

	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
	}

	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public int getLandlordAge() {
		return landlordAge;
	}

	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}

	public List<FlatDto> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<FlatDto> flatList) {
		this.flatList = flatList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LandlordDto [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge="
				+ landlordAge + ", flatList=" + flatList + ", user=" + user + "]";
	}

	
}