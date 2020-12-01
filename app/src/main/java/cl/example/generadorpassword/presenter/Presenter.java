package cl.example.generadorpassword.presenter;

import cl.example.generadorpassword.model.Verify;

public class Presenter  {
    Verify verifier;
    PresenterView view;

    public Presenter(PresenterView view) {
        this.view = view;
        verifier = new Verify();
    }
    public void evaluatePass(String pass){
        int resultado = verifier.checkPassword(pass);

        switch (resultado){
            case Verify.WEAK:
                this.view.showWeak();
                break;
            case Verify.MEDIUM:
                this.view.showMedium();
                break;
            case Verify.STRONG:
                this.view.showStrong();
                break;
            case Verify.VERYSTRONG:
                this.view.showVeryStrong();
                break;

        }
    }
}
