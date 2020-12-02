package cl.example.generadorpassword.model;

import androidx.annotation.VisibleForTesting;

public class Verify {

    public static final int WEAK = 3;
    public static final int MEDIUM = 4;
    public static final int STRONG = 5;
    public static final int VERYSTRONG = 10;
    private static final int LENGTHMIN = 5;

    /* REGLAS:
      1. AL MENOS 5 CARACTERES (WEAK)
      2. UNA LETRA MAYUSCULA (MIDIUM - STRONG)
      3. AL MENOS UN NUMERO (VERY STRONG)
     */
    @VisibleForTesting
    protected boolean lengthMin (String password){

        return password.length()>=LENGTHMIN;
    }
    @VisibleForTesting
    protected boolean upper (String password) {
        return !password.equals(password.toLowerCase());
    }

    @VisibleForTesting
    protected boolean isDigit(String password) {

        return password.matches(".*\\d.*");
    }

    public int checkPassword (String password) {
         if (!lengthMin(password) ){
             return WEAK;
         }
         if  (!upper(password)){
             return MEDIUM;
         }
         if (!isDigit(password)){
             return STRONG;
         }
           return VERYSTRONG;
    }


}
