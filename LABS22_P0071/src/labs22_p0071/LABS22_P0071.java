/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0071;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class LABS22_P0071 {

    public static void TaskManagement() {
        boolean continueProgram = true;
        ArrayList<task> taskList = new ArrayList<>();
        display Display = new display();
        //Function 1: Display a menu and ask users to select an option
        int choice = Display.displayMenu();
        //Function 2: Perform function based on the selected option
        taskManage TaskManage = new taskManage();
        int id = 1;
        //loop until user want to stop
        while (continueProgram) {
            switch (choice) {
                //Option 1: Add Task
                case 1:
                    task newTask = new task();
                    id = TaskManage.addTask(id,newTask, taskList);
                    break;
                //Option 2: Delete Task
                case 2:
                    int deletedID = 0;
                    TaskManage.deleteTask(deletedID, taskList);
                    break;
                //Option 3: Show task
                case 3:
                    TaskManage.showTask(taskList);
                    break;
                //Option 4: Exit the program
                case 4:
                    continueProgram = false;
                    break;
            }
            //check if user want to continue
            if (continueProgram) {
                choice = Display.displayMenu();
            }
        }
    }

    public static void main(String[] args) {
        TaskManagement();
    }

}
