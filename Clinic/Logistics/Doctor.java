package Logistics;
import java.util.ArrayList;

public class Doctor {
    public String name;
    private Location location;
    private Time startAvailability;
    private Time EndAvailability;
    private ArrayList<Time> TimeOccupied;

    public Doctor(String name, Time startTime, Time endTime){
        this.startAvailability=startTime;
        this.EndAvailability=endTime;
        this.name=name;
        TimeOccupied = new ArrayList<>();
        TimeOccupied.add(new Time(9,30));
    }
    public void setLocation(Location loc){
        this.location=loc; 
    }

    public void addTImeOccupied(Time t)
    {
        TimeOccupied.add(t);
    }
    
    public void getAvailability() throws CloneNotSupportedException 
    {
        ArrayList<Time> availableIntervals = new ArrayList<>();
		Time tempTime = this.startAvailability.clone();
		while (tempTime.compareTo(this.EndAvailability)!=0)
		{
			if (this.TimeOccupied.contains(tempTime)==false)
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

    public Time getStartTime() {
        return this.startAvailability;
    }
    public Time getEndTime() {
        return this.EndAvailability;
    }
    
}
