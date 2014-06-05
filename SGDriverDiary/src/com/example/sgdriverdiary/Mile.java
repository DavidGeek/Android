package com.example.sgdriverdiary;

public class Mile {
	private String date;
	private String petrol;
	private Double mile;
	private String kiosk;
	private Double rate;
	public Mile(){}

	public Mile(String date, Double  mile, String kiosk,String petrol, Double rate) {
		super();
		this.date=date;
		this.petrol = petrol;
		this.mile = mile;
		this.kiosk=kiosk;
		this.rate=rate;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date=date;
	}
	public String getPetrol() {
		return petrol;
	}
	public void setPetrol(String petrol) {
		this.petrol = petrol;
	}
	public Double getMile() {
		return mile;
	}
	public void setMile(Double mile) {
		this.mile = mile;
	}
	public String getKiosk() {
		return kiosk;
	}
	public void setKiosk(String kiosk) {
		this.kiosk = kiosk;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Mile [date =" + date + ", mile=" + mile + ", kiosk=" + kiosk + ", petrol=" + petrol + ", rate=" + rate
				+ "]";
	}



}