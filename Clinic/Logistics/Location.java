package Logistics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.print.Doc;

import org.w3c.dom.traversal.DocumentTraversal;

import Reservations.Reservation;

public class Location {
	private Map<Time, Integer> noOfReservations = new HashMap<Time,Integer>();
    private int maxCapacity;// This is for physical tests and vaccination
	private ArrayList <Reservation> reservations = new ArrayList<>();
	private Doctor doctor;
	private String name;

	public Location(String name, int maxCapacity,Doctor doctor) {
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.doctor = doctor;
		this.doctor.setLocation(this);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void addReservationLoc(Reservation res)
	{
		reservations.add(res);
		if (res.getServiceType().equals("CheckUp"))
		{
			this.doctor.addTImeOccupied(res.getTime());
		}
		else
		{
			if (this.noOfReservations.containsKey(res.getTime()))
			{
				this.noOfReservations.put(res.getTime(), this.noOfReservations.get(res.getTime())+1);
			}
			else
			{
				this.noOfReservations.put(res.getTime(), 1);
			}
			
		}
	}

	public void getAvailableIntervals() throws CloneNotSupportedException
	{
		// Considering every appointment is of 30 mins

		ArrayList<Time> availableIntervals = new ArrayList<>();
		Time startTime=this.doctor.getStartTime();
		Time endTime = this.doctor.getEndTime();
		Time tempTime = startTime.clone();
		while (tempTime.compareTo(endTime)!=0)
		{
			if (this.noOfReservations.containsKey(tempTime)==false || this.noOfReservations.get(tempTime)<this.maxCapacity-1)
			{
				availableIntervals.add(tempTime);
			}
			int timeInMin= tempTime.timeToMinutes() + 30;
			tempTime = new Time(timeInMin/60, timeInMin%60);
		}
		
		System.out.println("The time slot will be of 30 mins for example if you select 08:00 then your appointment time will be 08:00 - 08:30, Please enter your time in hh:mm format");
		for (Time t:availableIntervals)
		{
			System.out.print(t+" ");
		}
		System.out.println();
	}

	public void getDocAvailability() throws CloneNotSupportedException 
	{
		this.doctor.getAvailability();
	}

	
    public void deleteReservationById (int n){
        int count = 0;

        for (Reservation reservation : reservations) {

            if(reservation.getId() == n){
                reservations.remove(count);
                return;
            }

            else{
                count++;
            }
            
        }

        //No reservation with this id found;
    }

	public void deleteReservationTimeRecord(Reservation r){
		Time time = r.getTime();

		int oldvalue = noOfReservations.get(time);
		noOfReservations.replace(time, oldvalue, oldvalue-1);
	}



}

	
