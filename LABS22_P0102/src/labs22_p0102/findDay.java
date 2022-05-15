/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0102;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class findDay {

    public findDay() {
    }

    public void dayOfWeek(String inputDate, boolean existData) {
         Date date = null;
        if (existData) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                date = dateFormat.parse(inputDate);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //get calendar by current time zone
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int day = cal.get(Calendar.DAY_OF_WEEK);
            String dayOfWeek = null;
            switch (day) {
                case 1:
                    dayOfWeek = "Sunday";
                    break;
                case 2:
                    dayOfWeek = "Monday";
                    break;
                case 3:
                    dayOfWeek = "Tuesday";
                    break;
                case 4:
                    dayOfWeek = "Wednesday";
                    break;
                case 5:
                    dayOfWeek = "Thursday";
                    break;
                case 6:
                    dayOfWeek = "Friday";
                    break;
                case 7:
                    dayOfWeek = "Saturday";
                    break;
            }
            displayDayOfWeek(dayOfWeek);
        }
        
    }

    public void displayDayOfWeek(String dayOfWeek) {
        System.out.println("Your day is " + dayOfWeek);
    }
}
