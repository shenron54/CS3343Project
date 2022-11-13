package Logistics;
import java.util.ArrayList;

import Reservations.Reservation;

public class User {
    private String HKID;
    private String name;
    private ArrayList<Reservation> reservations;

    public User(String HKID,String name)
    {
        this.HKID=HKID;
        this.name=name;
        reservations=new ArrayList<>();
    }

    public void addReservation(Reservation res)
    {
        reservations.add(res);
    }
    
    public String getHKID()
    {
        return this.HKID;
    }

    public ArrayList<Reservation> getReservations(){
         return this.reservations;
    }

    public Reservation getReservationById (int n){
        

        for (Reservation reservation : reservations) {

            if(reservation.getId() == n){
                
                return reservation;
            }
            
        }

        return null;
        //No reservation with this id found;
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


}
