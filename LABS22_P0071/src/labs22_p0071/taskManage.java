/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0071;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class taskManage {

    public taskManage() {
    }

    //add to program
    public int addTask(int id, task Task, ArrayList<task> taskList) {
        System.out.println("--------- Add Task ---------");
        getInput getInput = new getInput();
        String requirementName = getInput.StringInput("Requirement Name: ");
        int taskTypeID = getInput.IntegerInput("Task Type: ", 1, 4);
        taskType TaskType = new taskType();
        TaskType.setID(taskTypeID);
        TaskType.setName();
        String date = getInput.DateInput("Date: ");
        String from = getInput.FromPlanInput("From: ");
        String to = getInput.ToPlanInput("To: ", from);
        String assignee = getInput.StringInput("Assignee: ");
        String expert = getInput.StringInput("Reviewer: ");
        Task.setRequirementName(requirementName);
        Task.setTaskType(TaskType);
        Task.setDate(date);
        Task.setFromPlan(from);
        Task.setToPlan(to);
        Task.setAssignee(assignee);
        Task.setExpert(expert);
        //check if task is duplicated
        if (!this.checkDuplicatedTask(Task.getDate(), Task.getAssignee(), Task.getFromPlan(), Task.getToPlan(), taskList)) {

            Task.setID(id);
            taskList.add(Task);
            System.out.println("Add Successfully!");
            id++;
        } else {
            System.out.println("This task is duplicated.Can't add");
        }
        return id;
    }

    //delete task
    public void deleteTask(int id, ArrayList<task> taskList) {
        System.out.println("--------- Delete Task ---------");
        getInput getInput = new getInput();
        id = getInput.IntegerInput("ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        //check if id is existed
        if (!this.checkExistTask(id, taskList)) {
            System.out.println("ID doesn't exist");
        } else {
            //traverse from first to last element in taskList
            for (task Task : taskList) {
                //if task id equal to input id, remove from list
                if (Task.getID() == id) {
                    taskList.remove(Task);
                    System.out.println("Delete Successfully!");
                    break;
                }
            }
        }
    }

    //show task
    public void showTask(ArrayList<task> taskList) {
        display Display = new display();
        Display.displayList(taskList);
    }

    //check if task is exist or not
    public boolean checkExistTask(int id, ArrayList<task> taskList) {
        boolean result = false;
        //traverse from first to last element in taskList
        for (task Task : taskList) {
            //if input id is equal to old task id, break loop
            if (Task.getID() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    //check duplicated task 
    public boolean checkDuplicatedTask(String date, String assignee, String planFrom, String planTo, ArrayList<task> taskList) {
        boolean result = false;
        //traverse from first to last in taskList
        for (task Task : taskList) {
            //check if input date is equal to task in list date and assignee input is equal to assignee in list
            if (date.equals(Task.getDate()) && assignee.equals(Task.getAssignee())) {
                //if input planfrom bigger than planto in list OR input planto smaller than planfrom in list 
                if (planFrom.compareTo(Task.getToPlan()) > 0 || planTo.compareTo(Task.getFromPlan()) < 0) {
                    result = true;
                } else {
                    result = false;
                }

            }

        }
        return result;
    }

}
