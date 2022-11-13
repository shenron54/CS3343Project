package Logistics;
import java.lang.Cloneable;
public class Time implements Comparable<Time>,Cloneable{
    private int hour;
    private int min;

    public Time(int hr, int min){
        this.hour = hr;
        this.min = min;
    }

    @Override
    public String toString() {
        String hr = ""+this.hour;
        String minutes =""+this.min;
        if (this.min<10)
        {
            minutes = "0"+ this.min;
        }
        if (this.hour<10)
        {
            hr = "0" + this.hour;
        }
        return hr+":"+minutes;
    }

    @Override
    public int compareTo(Time o) {
        if (this.hour==o.hour && this.min==o.min)
            return 0;
        return -1;
    }
    @Override
    public Time clone() throws CloneNotSupportedException {
        Time t=(Time)super.clone();
        return t;
    }

    public int timeToMinutes()
    {
        return this.hour*60+this.min;
    }
    
}
