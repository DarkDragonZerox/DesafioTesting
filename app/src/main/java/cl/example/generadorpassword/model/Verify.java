package cl.example.generadorpassword.model;

public class Verify {

    private static final int WEAK = 3;
    private static final int MEDIUM = 4;
    private static final int STRONG = 5;
    private static final int VERYSTRONG = 10;
    private static final int LENGTHMIN = 5;

    /* REGLAS:
      1. AL MENOS 5 CARACTERES (WEAK)
      2. UNA LETRA MAYUSCULA (MIDIUM - STRONG)
      3. AL MENOS UN NUMERO (VERY STRONG)
     */

    private boolean lengthMin (String password){
        return false;
    }

    private boolean upper (String password) {
        return false;
    }

    private boolean digit (String password) {
        return false;
    }

    public int checkPassword (String password) {
         if (!lengthMin(password) ){
             return WEAK;
         }
         if  (!upper(password)){
             return MEDIUM;
         }
         if (!digit(password)){
             return STRONG;
         }
           return VERYSTRONG;
    }


}
