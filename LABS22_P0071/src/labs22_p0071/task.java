/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0071;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class task {

    private int ID;
    private taskType TaskType;
    private String RequirementName;
    private String Date;
    private String FromPlan;
    private String ToPlan;
    private String Assignee;
    private String Expert;

    public task() {
    }

    public int getID() {
        return ID;
    }

    public taskType getTaskType() {
        return TaskType;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public String getDate() {
        return Date;
    }

    public String getFromPlan() {
        return FromPlan;
    }

    public String getToPlan() {
        return ToPlan;
    }

    public String getAssignee() {
        return Assignee;
    }

    public String getExpert() {
        return Expert;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTaskType(taskType TaskType) {
        this.TaskType = TaskType;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setFromPlan(String FromPlan) {
        this.FromPlan = FromPlan;
    }

    public void setToPlan(String ToPlan) {
        this.ToPlan = ToPlan;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public void setExpert(String Expert) {
        this.Expert = Expert;
    }

}
