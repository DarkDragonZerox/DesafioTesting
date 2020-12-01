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
        boolean resultado=verifier.upper("abC1e");
        Assert.assertTrue(resultado);
        assertThat(resultado).isTrue();
        MatcherAssert.assertThat(resultado, is(true));
    }

    @Test
    public void digit() {
    }

    @Test
    public void checkPassword() {
    }
}