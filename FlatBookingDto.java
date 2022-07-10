package com.cg.ofr.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Component
@Table(name="flat_booking")
public class FlatBookingDto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	bookingNo;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="flat_FlatBooking")
	private FlatDto flatdto;
		
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="tenant_FlatBooking")
	private TenantDto tenantdto;
		
	@Column
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;
		
	@Column
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;
	

	public FlatBookingDto() {}
	public FlatBookingDto( FlatDto flatdto, TenantDto tenantdto,  LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		
		this.flatdto = flatdto;
		this.tenantdto = tenantdto;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}
	
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public FlatDto getFlatdto() {
		return flatdto;
	}
	public void setFlatdto(FlatDto flatdto) {
		this.flatdto = flatdto;
	}
	public TenantDto getTenantdto() {
		return tenantdto;
	}
	public void setTenantdto(TenantDto tenantdto) {
		this.tenantdto = tenantdto;
	}
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
	
	@Override
	public String toString() {
		return "FlatBookingDto [bookingNo=" + bookingNo + ", flatdto=" + flatdto + ", tenantdto=" + tenantdto
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
	
	
	
	
	
	

}
