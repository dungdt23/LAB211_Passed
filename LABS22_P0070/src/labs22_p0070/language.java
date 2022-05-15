/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0070;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class language {

    public language() {

    }

    public ResourceBundle convertLanguage(int choice) {
        ResourceBundle convertLanguage = null;
        switch (choice) {
            case 1:
                Locale localeVi = new Locale("vi");
                convertLanguage = ResourceBundle.getBundle("language", localeVi);
                break;
            case 2:
                Locale localeEn = new Locale("en");
                convertLanguage = ResourceBundle.getBundle("language", localeEn);
                break;
            case 3:
                break;
        }
        return convertLanguage;
    }
}
