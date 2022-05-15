/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0071;

import com.sun.xml.internal.bind.v2.model.core.ID;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class display {

    public display() {
    }

    //display Menu
    public int displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println(".  Add Task");
        System.out.println(".  Delete Task");
        System.out.println(".  Display");
        System.out.println(".  exit");
        getInput getInput = new getInput();
        int choice = getInput.IntegerInput("Enter youir choice :", 1, 4);
        return choice;
    }

    //display list 
    public void displayList(ArrayList<task> list) {
        //check if list is empty
        if (list.isEmpty()) {
            System.out.println("Not found");
            return;
        }
        System.out.println("------------------------------------------------ Task ------------------------------------------------");
        System.out.format("%-10s %-20s %-15s %-10s %-15s %-10s %-10s", "ID", "Name", "Task Type", "Date", "Time", "Assigne", "Reviewer");
        System.out.println("");
        //traverse from first to last element in task list
        for (task Task : list) {
            displayTask(Task);
        }
    }

    //display task
    public void displayTask(task Task) {
        float time = Float.valueOf(Task.getToPlan()) - Float.valueOf(Task.getFromPlan());
        System.out.format("%-10d %-20s %-15s %-10s %-15s %-10s %-10s", Task.getID(), Task.getRequirementName(), Task.getTaskType().getName(), Task.getDate().toString(), Float.toString(time), Task.getAssignee(), Task.getExpert());
        System.out.println("");
    }

}
