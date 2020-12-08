# SanatanTime

Java module for converting the currently used Christian System Time to historic and vedic Sanatan System Time.

## Concept

In the Sanatan Time System, the day starts when the sun rises which happens around 3:30 AM everyday (It may differ by 1 to 2 Hours in different places and weather conditions). The units of the Sanatan Time System and its mathematical relation with the Current Time System Units are given below:

- **1 Vilipt (Sanatan Time Unit) = 1/150 Seconds OR 6.67 Milliseconds (approx.)(Christian Time Unit)**

- **1 Lipt (Sanatan Time Unit) = 60 Vilipt (Sanatan Time Unit) = 2/5 Seconds OR 400 Milliseconds (Christian Time Unit)**
    
    (60 Vilipt = 60 x 1 Vilipt = 60 x 6.67 Milliseconds = 400 Milliseconds (approx.) = 2/5 Seconds)

- **1 Pal (Sanatan Time Unit) = 60 Lipt (Sanatan Time Unit) = 24 Seconds (Christian Time Unit)**
    
    (60 Lipt = 60 x 1 Lipt = 60 x 400 Milliseconds = 24000 Milliseconds = 24 Seconds)

- **1 Ghadi (Sanatan Time Unit) = 60 Pal (Sanatan Time Unit) = 24 Minutes (Christian Time Unit)**
    
    (60 Pal = 60 x 1 Pal = 60 x 24 Seconds = 1440 Seconds = 24 Minutes)

- **1 Day = 60 Ghadi (Sanatan Time Unit) = 24 Hours (Christian Time Unit)**
    
    (60 Ghadi = 60 x 1 Ghadi = 60 x 24 Minutes = 1440 Minutes = 24 Hours)

Now, using the above relations, I have derived the mathematical formulas and mathematical functions which can be used to convert the Current System Time to Sanatan System Time and are listed below with explanation.

So, first of all, here is the list of information which we have with us:

- **sun_rise_hour** = The hour in which the sun rises (Most likely 3 in majority of the world).
- **sun_rise_minutes** = Number of minutes passed in sun_rise_hour after which the sun rises (Most likely 30 in majority of the world).
- **current_hour** = The hour in which the time is being calculated.
- **current_minutes** = Number of minutes passed in current_hour at the moment when time is being calculated.
- **current_seconds** = Number of seconds passed in current_minutes at the moment when time is being calculated.

Now our first objective is to calculate number of minutes passed between the sun rise time and the current time.

So for that, there are 2 cases which need to be considered and the calculations have to be done accordingly. The cases with explanation are as follows:

- **Case 1: current_hour is not equal to sun_rise_hour OR current_hour is equal to sun_rise_hour but current_minutes is less than sun_rise_minutes**

    In this case, the formula which we will use is as follows:

    **minutes_from_day_start = (60 - sun_rise_minutes) + (number_of_hours(sun_rise_hour + 1, current_hour) x 60) + current_minutes**

    The expression **(60 - sun_rise_minutes)** gives the minutes which were passed in the sun_rise_hour after the rise of the sun.
    The expression **(number_of_hours(sun_rise_hour + 1, current_hour) x 60)** gives the number of minutes passed between the hour after sun_rise_hour and the current_hour via function number_of_hours() which will be explained in detail below (60 is multiplied to number of hours to convert them into minutes passed).
    Then, **current_minutes** is added to the result of above expressions to add the number of minutes passed in the current_hour till the moment where time is being calculated.

- **Case 2: current_hour is equal to sun_rise_hour and current_minutes is equal to or greater than sun_rise_minutes**

    In this case, since the day has started less than an hour ago, hence we will use this formula which is as follows:

    **minutes_from_day_start = current_minutes - sun_rise_minutes**

    Basically, these are the minutes passed after sun rise in sun_rise_hour.

Now here's the explanation of number_of_hours() function:

## Installation

Simply using Gradle or Maven:

### Gradle:

```gradle
implementation 'com.abhaytr.jbeauty:JBeauty:1.0'
```

### Maven:
```maven
<dependency>
  <groupId>com.abhaytr.jbeauty</groupId>
  <artifactId>JBeauty</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

## Usage

Simply use this code (Modify according to your needs):

```java
import com.abhaytr.jbeauty.Beauty;
import com.abhaytr.jbeauty.ColorListener;
import java.util.Map;
import java.util.HashMap;

class YourClass
{
  
  public static void main(String args[])
  {
    Map parameters = new HashMap(); //For optional parameters (More about them below).
    Beauty.start(parameters, new ColorListener()
    {
      @Override
      public void on_new_color(int[] rgb_color)
      {
        int red_value = rgb_color[0];
        int green_value = rgb_color[1];
        int blue_value = rgb_color[2];
        //Now you can do anything with the RGB values (set as background, font color, etc..).
      }
    });
  }

}
```
Optional Parameters that are available are listed below in Parameters section and have to be passed as a Map (keys as name of parameters listed in Parameters section and value is your desired choice according to the options available for that parameter as specified in the Parameters section) which will be the first parameter for start() method of Beauty class.

## Parameters
- ### mode (Optional)
  
  Specifies colour set in which the colours have to vary.
  
  - **Parameter Value Type:** String or int[].
  
  - **Options for mode parameter**
    - **"dark":** Varies the colour in dark colours only (useful for dark mode projects).
    - **"light":** Varies the colour in light colours only (useful for light mode projects).
    - **[start_rgb, end_rgb]:** Varies the colour from start_rgb value (can be from 0 to 255) to end_rgb value (can be from 0 to 255).
  
  - **Default Value:** "" (i.e. varies from 0 to 255 RGB Values).

- ### start (Optional):
  
  Specefies colour in RGB format from which colours have to start varying.
  
  - **Input type for start parameter:** int[]{R_Value, G_Value, B_Value} (eg. int[]{0, 0, 0} for black).
  
  - **Default Value:** int[]{0, 0, 0} (for "dark", none or other mode parameter specified) and int[]{255, 255, 255} (for "light" mode parameter specified).

- ### time (Optional):
  
  Specifies the time in milliseconds after which the colour is changed according to its range.
  Useful for decreasing the time when using on slow hardware for maintaining the smoothness.
  
  - **Parameter Value Type:** int.
  
  - **Default Value:** 40 ms (Just perfect for majority hardware types).
  
So go ahead and enjoy the beauty of time varying RGB colour sets!
