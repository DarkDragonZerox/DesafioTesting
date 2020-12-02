package cl.example.generadorpassword.model;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;


import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;


public class VerifyTest {
    Verify verifier;

    @Before
    public void setUp() {

        verifier=new Verify();
    }

    @Test
    public void lengthMin_lowerlengthmin() {
        boolean resultado=verifier.lengthMin("abcd");
        assertFalse(resultado);
        assertThat(resultado).isFalse();
        MatcherAssert.assertThat(resultado, is(false));


    }
    @Test
    public void lengthMin_equalslengthmin() {
        boolean resultado=verifier.lengthMin("abcde");
        Assert.assertTrue(resultado);
        assertThat(resultado).isTrue();
        MatcherAssert.assertThat(resultado, is(true));
    }
    @Test
    public void lengthMin_overlengthmin() {
        boolean resultado=verifier.lengthMin("abcdef");
        Assert.assertTrue(resultado);
        assertThat(resultado).isTrue();
        MatcherAssert.assertThat(resultado, is(true));
    }
    @Test
    public void upper_allLowerCase() {
        boolean resultado=verifier.upper("abcdef");
        Assert.assertFalse(resultado);
        assertThat(resultado).isFalse();
        MatcherAssert.assertThat(resultado, is(false));
    }
    @Test
    public void upper_allUpperCase() {
        boolean resultado=verifier.upper("ABCDE");
        Assert.assertTrue(resultado);
        assertThat(resultado).isTrue();
        MatcherAssert.assertThat(resultado, is(true));
    }
    @Test
    public void upper_oneUpperandOneNumber() {
        boolean resultado=verifier.upper("abc1E");
        Assert.assertTrue(resultado);
        assertThat(resultado).isTrue();
        MatcherAssert.assertThat(resultado, is(true));
    }

    @Test
    public void isDigit_hasNumber() {
        boolean resultado = verifier.isDigit("abcd1");
        Assert.assertTrue(resultado);
        assertThat(resultado).isTrue();
        MatcherAssert.assertThat(resultado, is(true));
    }

    @Test
    public void isDigit_noNumber() {
        boolean resultado = verifier.isDigit("abcd");
        Assert.assertFalse(resultado); //Junit
        assertThat(resultado).isFalse(); //Truth
        MatcherAssert.assertThat(resultado, is(false)); //Hamcrest
    }

    @Test
    public void checkPassword_isWeak() {
        int resultado = verifier.checkPassword("sss");
        boolean res = Verify.WEAK==resultado;
        Assert.assertTrue(res); //Junit
        assertThat(res).isTrue(); //Truth
        MatcherAssert.assertThat(res, is(true)); //Hamcrest
    }

    @Test
    public void checkPassword_isMedium() {
        int resultado = verifier.checkPassword("ssshhh");
        Assert.assertEquals(Verify.MEDIUM, resultado); //Junit
        assertThat(resultado).isEqualTo(Verify.MEDIUM); //Truth
        MatcherAssert.assertThat(resultado, is(Verify.MEDIUM)); //Hamcrest
    }

    @Test
    public void checkPassword_isStrong() {
        int resultado = verifier.checkPassword("ssshhhD");
        Assert.assertEquals(Verify.STRONG, resultado); //Junit
        assertThat(resultado).isEqualTo(Verify.STRONG); //Truth
        MatcherAssert.assertThat(resultado, is(Verify.STRONG)); //Hamcrest

    }

    @Test
    public void checkPassword_isVeryStrong() {
        int resultado = verifier.checkPassword("ssshhhD4");
        Assert.assertEquals(Verify.VERYSTRONG, resultado); //Junit
        assertThat(resultado).isEqualTo(Verify.VERYSTRONG); //Truth
        MatcherAssert.assertThat(resultado, is(Verify.VERYSTRONG)); //Hamcrest

    }

    @Test
    public void checkPassword_isVoid() {
        int resultado = verifier.checkPassword("");
        Assert.assertEquals(Verify.WEAK, resultado); //Junit
        assertThat(resultado).isEqualTo(Verify.WEAK); //Truth
        MatcherAssert.assertThat(resultado, is(Verify.WEAK)); //Hamcrest
    }

}