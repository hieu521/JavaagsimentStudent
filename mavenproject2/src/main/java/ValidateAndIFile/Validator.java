package ValidateAndIFile;


import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tltkh
 */
public class Validator {
    //Check Empt when input
    public static boolean checkEmpty(JTextField field, StringBuilder sb, String msg) {
        boolean ok = true;
        if (field.getText().equals("")) {
            sb.append(msg).append("\n");
            field.setBackground(Color.gray);
            ok = false;
        } else {
            field.setBackground(Color.white);
        }
        return ok;
    }
    public static boolean checkName(JTextField field, StringBuilder sb){
        
        boolean ok = true;
        try {
            String name = field.getText();
            char[] characters = name.toCharArray();
            for(char character:characters){
                if(Character.isDigit(character)){
                    sb.append("Name does not contain number");
                    break;
                }
            }
            
        } catch (Exception e) {
            sb.append("Error name: ");
            ok = false;
        }
        return ok;
    }
    
    //Check Age when input
    public static boolean checkAge(JTextField field, StringBuilder sb) {
        boolean ok = true;

        if (!checkEmpty(field, sb, "Age is not define")) {
            return false;
        }
        try {
            int age = Integer.parseInt(field.getText());
            if (age < 18 || age > 55) {
                sb.append("Invalid age(18-55)\n");
                field.setBackground(Color.gray);
                ok = false;
            }
        } catch (Exception e) {
            sb.append("Invalid age(default number)\n");
            field.setBackground(Color.gray);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }
   //Check Salary when input
    public static boolean checkStuition(JTextField field, StringBuilder sb) {
        boolean ok = true;

        if (!checkEmpty(field, sb, "Salary is not define")) {
            return false;
        }
        try {
            double salary = Double.parseDouble(field.getText());
            if (salary < 1000) {
                sb.append("Invalid salary(smallest 1000)\n");
                field.setBackground(Color.gray);
                ok = false;
            }
        } catch (Exception e) {
            sb.append("Invalid salary(default number)\n");
            field.setBackground(Color.gray);
            ok = false;
        }
        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }
    
    public static boolean checkID(JTextField field, StringBuilder sb) {
        boolean ok = true;
        
        if (!checkEmpty(field, sb, "Salary is not define")) {
            return false;
        }
        try {
            String ID = field.getText();
            Pattern p = Pattern.compile("[/.!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher m = p.matcher(ID);
            boolean isSpecialChar = m.find();
            
            if (isSpecialChar) {
                sb.append("ID does not contains special characters!");
            }
        } catch (Exception e) {
            sb.append("Invalid ID");
            field.setBackground(Color.red);
        }
        return ok;
    }
    //Check Email when input
    public static boolean checkEmail(JTextField field, StringBuilder sb) {
        boolean ok = true;

        if (!checkEmpty(field, sb, "Email is not define")) {
            return false;
        }

        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(field.getText());

        if (!matcher.find()) {
            sb.append("Invalid email \n");
            field.setBackground(Color.gray);
            ok = false;
        }

        if (ok) {
            field.setBackground(Color.white);
        }
        return ok;
    }
}
