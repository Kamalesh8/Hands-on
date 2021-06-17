package com.cts.flightmanagement;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Flight {
	
	private String id;
	private String flightType;
	private List<Passenger> passengers;
	
	public boolean addPassenger(Passenger plist) {
		return false;		
	}
	
	public boolean removePassenger(Passenger plist) {
		return false;
	}
}
