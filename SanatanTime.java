package org.abhaytr;

/*

Welcome to Sanatan Time!

Java module that converts the 
currently used christian system 
time to the historic and vedic
sanatan system time.

All the conversion formulas and 
explanation of the conversion system
can be found in the "README.md" file
present with this file.

To use this module, simply include the
"SanatanTime.jar" file (which is present with this
file) in your project.

For guidance regarding the module,
kindly read the "README.md" file present with this
file.

Jai Shree Ram!

*/

import java.text.SimpleDateFormat;
import java.util.*;

public class SanatanTime
{
    
    int[] sanatan_time_start = new int[]{3, 30};
    String current_sanatan_time = "";
    int sanatan_ghadis = 0;
    int sanatan_pals = 0;
    int sanatan_lipts = 0;
    int sanatan_vilipts = 0;
    
    public SanatanTime(int[] sanatan_time_start)
    {
        if (sanatan_time_start[0] > 23 || sanatan_time_start[1] > 59)
        {
            throw new RuntimeException("Invalid Sun Rise (Day Start) Time.");
        }
        this.sanatan_time_start = sanatan_time_start;
        Date christian_current_time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("SSS");
        int milliseconds = Integer.parseInt(formatter.format(christian_current_time));
        double seconds = (double)(christian_current_time.getSeconds()) + (double)((double)(milliseconds) / 1000);
        int[] sanatan_converted_time = christian_to_sanatan_time(christian_current_time.getHours(), christian_current_time.getMinutes(), seconds);
        this.sanatan_ghadis = sanatan_converted_time[0];
        this.sanatan_pals = sanatan_converted_time[1];
        this.sanatan_lipts = sanatan_converted_time[2];
        this.sanatan_vilipts = sanatan_converted_time[3];
        this.current_sanatan_time = this.sanatan_ghadis + " Ghadis, " + this.sanatan_pals + " Pals, " + this.sanatan_lipts + " Lipts, " + this.sanatan_vilipts + " Vilipts";
    }
    
    public SanatanTime()
    {
        Date christian_current_time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("SSS");
        int milliseconds = Integer.parseInt(formatter.format(christian_current_time));
        double seconds = (double)(christian_current_time.getSeconds()) + (double)((double)(milliseconds) / 1000);
        int[] sanatan_converted_time = christian_to_sanatan_time(christian_current_time.getHours(), christian_current_time.getMinutes(), seconds);
        this.sanatan_ghadis = sanatan_converted_time[0];
        this.sanatan_pals = sanatan_converted_time[1];
        this.sanatan_lipts = sanatan_converted_time[2];
        this.sanatan_vilipts = sanatan_converted_time[3];
        this.current_sanatan_time = this.sanatan_ghadis + " Ghadis, " + this.sanatan_pals + " Pals, " + this.sanatan_lipts + " Lipts, " + this.sanatan_vilipts + " Vilipts";
    }
    
    private int hours_difference(int start_hour, int end_hour)
    {
        if (end_hour >= start_hour)
        {
            return (end_hour - start_hour);
        }
        else
        {
            return (24 - (start_hour - end_hour));
        }
    }
    
    private int[] christian_to_sanatan_time(int hours, int minutes, double seconds)
    {
        int minutes_from_day_start;
        if (hours == this.sanatan_time_start[0] && minutes >= this.sanatan_time_start[1])
        {
            minutes_from_day_start = minutes - this.sanatan_time_start[1];
        }
        else
        {
            minutes_from_day_start = (60 - this.sanatan_time_start[1]) + (hours_difference(this.sanatan_time_start[0] + 1, hours) * 60) + minutes;
        }
        int ghadis = (int)((double)(minutes_from_day_start / 24));
        int minutes_from_ghadi_start = minutes_from_day_start % 24;
        int pals = (int)((double)((double)((minutes_from_ghadi_start * 60) + seconds) / 24));
        int lipts = (int)((double)(((double)((minutes_from_ghadi_start * 60) + seconds) % 24) / 0.4));
        int vilipts = (int)((double)((double)(((double)((minutes_from_ghadi_start * 60) + seconds) % 24) % 0.4) * 150));
        return new int[]{ghadis, pals, lipts, vilipts};
    }
    
    public String convert(Date christian_time)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("SSS");
        int milliseconds = Integer.parseInt(formatter.format(christian_time));
        double seconds = (double)(christian_time.getSeconds()) + (double)((double)(milliseconds) / 1000);
        int[] sanatan_converted_time = christian_to_sanatan_time(christian_time.getHours(), christian_time.getMinutes(), seconds);
        return sanatan_converted_time[0] + " Ghadis, " + sanatan_converted_time[1] + " Pals, " + sanatan_converted_time[2] + " Lipts, " + sanatan_converted_time[3] + " Vilipts";
    }
    
    @Override
    public String toString()
    {
        return this.current_sanatan_time;
    }
    
    public int getGhadis()
    {
        return this.sanatan_ghadis; 
    }
    
    public int getPals()
    {
        return this.sanatan_pals; 
    }
    
    public int getLipts()
    {
        return this.sanatan_lipts; 
    }
    
    public int getVilipts()
    {
        return this.sanatan_vilipts; 
    }
    
}