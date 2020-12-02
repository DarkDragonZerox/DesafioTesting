package cl.example.generadorpassword.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class PresenterTest {
    @Mock
    private PresenterView view;
    private Presenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        presenter = new Presenter(view);

    }

    @Test
    public void evaluatePass_Weak() {
        // given : dado a que
        String pass = "sss";
        //when = cuando
        presenter.evaluatePass(pass);
        //then = entonces
        Mockito.verify(view,Mockito.times(1)).showWeak();
        Mockito.verify(view,Mockito.never()).showMedium();
        Mockito.verify(view,Mockito.never()).showStrong();
        Mockito.verify(view,Mockito.never()).showVeryStrong();

    }
    @Test
    public void evaluatePass_Medium() {
        // given : dado a que
        String pass = "sssss";
        //when = cuando
        presenter.evaluatePass(pass);
        //then = entonces
        Mockito.verify(view,Mockito.never()).showWeak();
        Mockito.verify(view,Mockito.times(1)).showMedium();
        Mockito.verify(view,Mockito.never()).showStrong();
        Mockito.verify(view,Mockito.never()).showVeryStrong();

    }
    @Test
    public void evaluatePass_Strong() {
        // given : dado a que
        String pass = "ssssS";
        //when = cuando
        presenter.evaluatePass(pass);
        //then = entonces
        Mockito.verify(view,Mockito.never()).showWeak();
        Mockito.verify(view,Mockito.never()).showMedium();
        Mockito.verify(view,Mockito.times(1)).showStrong();
        Mockito.verify(view,Mockito.never()).showVeryStrong();

    }
    @Test
    public void evaluatePass_VeryStrong() {
        // given : dado a que
        String pass = "sss4S";
        //when = cuando
        presenter.evaluatePass(pass);
        //then = entonces
        Mockito.verify(view,Mockito.never()).showWeak();
        Mockito.verify(view,Mockito.never()).showMedium();
        Mockito.verify(view,Mockito.never()).showStrong();
        Mockito.verify(view,Mockito.times(1)).showVeryStrong();

    }
}