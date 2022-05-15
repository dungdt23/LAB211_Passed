/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0071;

/**
 *
 * @author Admin
 */
public class taskType {

    private int ID;
    private String Name;

    public taskType() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName() {
        switch (this.getID()) {
            case 1:
                this.Name = "Code";
                break;
            case 2:
                this.Name = "Test";
                break;
            case 3:
                this.Name = "Design";
                break;
            case 4:
                this.Name = "Review";
                break;
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

}
