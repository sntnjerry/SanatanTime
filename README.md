# SanatanTime

Java module for converting the currently used christian system time to historic and vedic sanatan system time.

## Concept

In the Sanatan Time System, the day starts when the sun rises which happens around 3:30 AM everyday (It may differ by 1 to 2 Hours in different places and weather conditions). The units of the Sanatan Time System and its mathematical relation with the Current Time System Units are given below:

- **1 Vilipt (Sanatan Time Unit) = 1/150 Seconds OR 6.67 Milliseconds (Christian Time Unit)**

- **1 Lipt (Sanatan Time Unit) = 60 Vilipt (Sanatan Time Unit) = 2/5 Seconds OR 400 Milliseconds (Christian Time Unit)**
    (60 Vilipt = 60 x 1 Vilipt = 60 x 6.67 Milliseconds = 400 Milliseconds (approx.) = 2/5 Seconds)

- **1 Pal (Sanatan Time Unit) = 60 Lipt (Sanatan Time Unit) = 24 Seconds (Christian Time Unit)**
    (60 Lipt = 60 x 1 Lipt = 60 x 400 Milliseconds = 24000 Milliseconds = 24 Seconds)

- **1 Ghadi (Sanatan Time Unit) = 60 Pal (Sanatan Time Unit) = 24 Minutes (Christian Time Unit)**
    (60 Pal = 60 x 1 Pal = 60 x 24 Seconds = 1440 Seconds = 24 Minutes)

- **1 Day = 60 Ghadi (Sanatan Time Unit) = 24 Hours (Christian Time Unit)**
    (60 Ghadi = 60 x 1 Ghadi = 60 x 24 Minutes = 1440 Minutes = 24 Hours)

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
