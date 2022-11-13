package Logistics;
import java.util.ArrayList;

import ServicesFactory.Service;

public class Hospital{
    private static ArrayList<Service> services;
	private static Hospital inst = new Hospital();
	private static ArrayList<Location> loc;
	private ArrayList<User> userList;

    private Hospital() {
		services = new ArrayList<Service>();
		loc = new ArrayList<Location>();
		userList=new ArrayList<>();
	}

	public static Hospital getinstance() {
		return inst;
	}

	public void addLocation(Location l){
		loc.add(l);
	}

	public void printLocations() {
		int i=1;
		for (Location l:loc)
		{
			System.out.println("Press "+ i+" for "+l);
			i+=1;
		}
	}

	public static Location getLocByIndex(int locationIndex) {
		int i=1;
		for (Location l: loc)
		{
			if (i==locationIndex)
			{
				return l;
			}
			i+=1;
		}
		return null;
	}

	public void addService(Service s) {
		if(s!=null)
			services.add(s);
	}

	public void printServices() {
		int i=1;
		for (Service s:services)
		{
			System.out.println("Press "+ i+" for "+ s);
			i+=1;
		}
	}

	public static Service getServiceByIndex(int serviceIndex) {
		int i=1;
		for (Service s: services)
		{
			if (i==serviceIndex)
			{
				return s;
			}
			i+=1;
		}
		return null;
	}

	public User findUserByHKID(String HKID)
	{
		for(User u:userList)
		{
			if(u.getHKID().equals(HKID))
			{
				return u;
			}
		}
		return null;
	}

	public void addUser(User u)
	{
		userList.add(u);
	}

}