package Reservations;
import java.util.Random;

import Logistics.Location;
import Logistics.Time;
import Logistics.User;
import ServicesFactory.Service;
public class Reservation{
    private Location location;
	private int id;
	private Service service;
	private User user;
	private Time time;
	
	public Reservation(User user, Location location, Service service, Time time) {
		this.location = location;
		this.service = service;
		this.user = user;
		this.time = time;
		Random rand = new Random();
		this.id= rand.nextInt();
	}
	
	public String getServiceType()
	{
		return this.service.getName();
	}

	public Time getTime() {
		return this.time;
	}

	public int getId(){
		return this.id;
	}

	public Location getLocation(){
		return this.location;
	}
	@Override
	public String toString() {
		return "Reservation id " + this.id + " Clinic Location " + location.toString() + " Service Requested " + service.getName() + " At " + this.time.toString();
	}

	
}

