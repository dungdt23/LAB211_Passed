/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0104;

import java.io.File;

/**
 *
 * @author Admin
 */
public class LABS22_P0104 {

    public static void main(String[] args) {
        getInput getInput = new getInput();
        fileInteract FileInteract = new fileInteract();

        //STEP 1: User input directory of file
        String directoryOfFile = getInput.StringInput("Please enter directory of file:  ");
        //STEP 2: User input string to search
        String searchWord = getInput.searchWord("Please enter string to search: ", directoryOfFile);
        //STEP 3: Find string or letter words that contain the input string
        FileInteract.searchResult(directoryOfFile, searchWord);
    }

}
