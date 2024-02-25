package edu.utsa.cs3443.rhproject.account;
import edu.utsa.cs3443.rhproject.currency.*;

import java.io.File;
import java.util.ArrayList;

public class Account {
    int pass;
    String username, name;
    DinoMoney money;

    public Account(String username, String password, String name) {
        this.username = username;
        encrypt(password);
        this.name = name;
    }
    public boolean isValidPass(String pass, String cpass) {
        boolean valid = false, hasDigit = false, hasCapital = false;

        valid = !pass.equals(""); //Check that pass is not blank
        valid = (pass.equals(cpass));
        valid = (pass.length() < 8) ? false : true; //Check that pass is not less than 8 chars

        for(char c : pass.toCharArray()) {
            if (Character.isDigit(c))
                hasDigit = true; // checks that string has at least 1 digit

            if(Character.isUpperCase(c))
                hasCapital = true;//checks that string has at least 1 upper case letter.

            if(hasCapital && hasDigit)
                break;
        }

        if (!hasDigit || !hasCapital )
            valid = false;
        else
            valid = true;

        return valid;
    }

//    public void outputToTextFile() throws IOException {
//        File f = new File(name);
//        FileWriter output = new FileWriter("C:\\Hackathon\\ElderlyBank");
//
//        f.mkdir();
//    }
//    public boolean isValidPass(String pass) {
//        boolean valid = false, hasDigit = false, hasCapital = false;
//
//        valid = !pass.equals(""); //Check that pass is not blank
//
//        valid = (pass.length() < 8) ? false : true; //Check that pass is not less than 8 chars
//
//        for(char c : pass.toCharArray()) {
//            if (Character.isDigit(c))
//                hasDigit = true; // checks that string has at least 1 digit
//
//            if(Character.isUpperCase(c))
//                hasCapital = true;//checks that string has at least 1 upper case letter.
//
//            if(hasCapital && hasDigit)
//                break;
//        }
//
//        if (!hasDigit || !hasCapital )
//            valid = false;
//        else
//            valid = true;
//
//        if(valid)
//            encrypt(pass);
//
//        return valid;
//    }

        public void encrypt(String pass) {
            //System.out.println("Before:" + pass);
            //System.out.println("After:" + encryptedPass);
            this.pass = pass.hashCode();
    //		return encryptedPass;
        }

    public boolean isPassCorrect(String pass) {
        if (this.pass == pass.hashCode())
            return true;
        else
            return false;
    }

    public int getPassword() {
        return this.pass;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public DinoMoney money() {
        return this.money;
    }
}
