/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs22_p0011;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class convert {

    public convert() {
    }

    public String implementConvert(int baseInput, int baseOuput, String value) {
        String result = "";
        switch (baseInput) {
            case 2:
                result = convertFromBinary(value, baseOuput);
                break;
            case 10:
                result = convertFromDec(value, baseOuput);

                break;
            case 16:
                result = convertFromHex(value, baseOuput);

                break;
        }

        return result;
    }

    //Convert from binary to other bases
    public String convertFromBinary(String inputData, int baseOutput) {
        String result = "";
        int Result = 0;
        BigInteger bigIntegerResult = new BigInteger("0");
        //variable to check if input is valid
        boolean checkInput = true;
        //Loop run through all character of input data
        for (int i = 0; i < inputData.length(); i++) {
            //if character is not 1 or 0, input will be invalid
            if (inputData.charAt(i) != '1' && inputData.charAt(i) != '0') {
                checkInput = false;
                break;
            }
        }
        if (checkInput == false) {
            result = "Input muse be Binary";
        } else {
            if (baseOutput == 2) {
                //return input if base out put is the same
                result = inputData;
            } else {
                if (baseOutput == 10) {
                    //Loop run through all character of input data
                    for (int i = inputData.length() - 1; i >= 0; i--) {
                        String digit = Character.toString(inputData.charAt(i));
                        BigInteger coefficient = new BigInteger(digit);
                        bigIntegerResult = bigIntegerResult.add(
                                coefficient.multiply(new BigInteger("2").pow(inputData.length() - 1 - i)));
                    }
                    //result = Long.toString(Result);
                    result = bigIntegerResult.toString();
                } else {
                    String tempResult = convertFromBinary(inputData, 10);
                    result = convertFromDec(tempResult, 16);
                }
            }
        }

        return result;
    }

    //convert from decimal base to other bases
    public String convertFromDec(String inputData, int baseOutput) {
        String result = "";
        boolean checkInput = true;
        //Loop run through all character of input data
        for (int i = 0; i < inputData.length(); i++) {
            //check if input of decimal value is valid or not
            if (inputData.charAt(i) < '0' || inputData.charAt(i) > '9') {
                checkInput = false;
                break;
            }
        }
        if (checkInput == false) {
            result = "Input must be Decimal";
        } else {

            if (baseOutput == 10) {
                //return input if base out put is the same 
                result = inputData;
            } else {
                if (baseOutput == 2) {
                    try {

                        BigInteger inputValue = new BigInteger(inputData);
                        BigInteger quotient = new BigInteger("0");
                        BigInteger remainder = new BigInteger("0");
                        //Loop until the quotient is 0
                        do {
                            quotient = inputValue.divide(new BigInteger("2"));
                            remainder = inputValue.remainder(new BigInteger("2"));
                            result += remainder.toString();
                            inputValue = quotient;
                        } while (!quotient.equals(new BigInteger("0")));
                        StringBuilder reverseStr = new StringBuilder(result);
                        reverseStr.reverse();
                        result = reverseStr.toString();
                    } catch (Exception e) {
                        result = "Input must be integer";
                    }

                } else {
                    try {

                        BigInteger inputValue = new BigInteger(inputData);
                        BigInteger quotient = new BigInteger("0");
                        BigInteger remainder = new BigInteger("0");
                        //Loop until the quotient is 0
                        do {
                            quotient = inputValue.divide(new BigInteger("16"));
                            remainder = inputValue.remainder(new BigInteger("16"));
                            switch (remainder.intValue()) {
                                case 10:
                                    result += "A";
                                    break;
                                case 11:
                                    result += "B";
                                    break;
                                case 12:
                                    result += "C";
                                    break;
                                case 13:
                                    result += "D";
                                    break;
                                case 14:
                                    result += "E";
                                    break;
                                case 15:
                                    result += "F";
                                    break;
                                default:
                                    result += String.valueOf(remainder);
                                    break;
                            }
                            inputValue = quotient;
                        } while (!quotient.equals(new BigInteger("0")));
                        StringBuilder reverseStr = new StringBuilder(result);
                        reverseStr.reverse();
                        result = reverseStr.toString();
                    } catch (Exception e) {
                        result = "Input must be integer";
                    }
                }
            }
        }

        return result;
    }

    //convert from hexadecimal base to other bases
    public String convertFromHex(String inputData, int baseOutput) {
        String result = "";
        boolean checkInput = true;
        //Loop run through all character of input data
        for (int i = 0; i < inputData.length(); i++) {
            //check if input of hexadecimal value is valid or not
            if ((inputData.charAt(i) < '0' || inputData.charAt(i) > '9') && (inputData.charAt(i) < 'A' || inputData.charAt(i) > 'F')) {
                checkInput = false;
                break;
            }
        }
        if (checkInput == false) {
            result = "Input must be Hexadecimal";
        } else {
            if (baseOutput == 16) {
                //return input if base out put is the same 
                result = inputData;
            } else {
                if (baseOutput == 10) {
                    //long Result = 0;
                    BigInteger integerBigInteger = new BigInteger("0");
                    //Loop run through all character of input data
                    for (int i = inputData.length() - 1; i >= 0; i--) {
                        String digit = null;
                        switch (inputData.charAt(i)) {
                            case 'A':
                                digit = "10";
                                break;
                            case 'B':
                                digit = "11";
                                break;
                            case 'C':
                                digit = "12";
                                break;
                            case 'D':
                                digit = "13";
                                break;
                            case 'E':
                                digit = "14";
                                break;
                            case 'F':
                                digit = "15";
                                break;
                            default:
                                digit = String.valueOf(inputData.charAt(i));
                                break;
                        }

                        BigInteger coefficient = new BigInteger(digit);
                        integerBigInteger = integerBigInteger.add(
                                coefficient.multiply(new BigInteger("16").pow(inputData.length() - 1 - i)));
                    }

                    result = integerBigInteger.toString();
                } else {
                    String tempResult = convertFromHex(inputData, 10);
                    result = convertFromDec(tempResult, 2);
                }
            }
        }

        return result;
    }
}
