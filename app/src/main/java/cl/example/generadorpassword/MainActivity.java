package cl.example.generadorpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import cl.example.generadorpassword.databinding.ActivityMainBinding;
import cl.example.generadorpassword.presenter.Presenter;
import cl.example.generadorpassword.presenter.PresenterView;

public class MainActivity extends AppCompatActivity implements PresenterView {
/* TODO
 * MVP
 * View Binding
 * Test unitarios para modelo
 * Test unitarios presentador
 * Actividades
 * Tomar tiempos por cada tarea
 * programar en forma paulatina
 * Tareas
 *  [X] Crear repositorio en GitHub y compartir codigo y permisos para modificar
 * [X] 1.- Modificar Build.gradle (activar viewBinding)
 * [X]   Modificar MainActivity para activar viewBinding
 * [X] 2.- Diseño layout
 *
 *   Model
 * 3.- Generar clase parte del modelo (Verifier)
 *     - [x]atributos : niveles de fortalezas de la contraseña (debil, media, fuerte , super fuerte, largo de contraseña (min.))
 *     - [X]generar metodos de verificacion.
 *
 * Presenter
 * 4.- Generar clase Presenter
 *     - [x]crear interfaz presenterView
 *     - [x]atributos
 *
 *   View
 * 5.- [x]Main activity implementar metodos de la interfaz
 * 6.- [X]extraer recursos (values strings, colors)
 * 7.- [x]agregar listener en editText
 *
 *  test
 * 8.- [x]Agregar dependencias de test en build.gradle
 * 9.- [X] agregar test unitarios para modelo
 * 10.-0[] agregar test unitarios para presentador
 *
 */

   private ActivityMainBinding binding;
   private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter=new Presenter(this);
        binding.editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            presenter.evaluatePass(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    @Override
    public void showWeak() {
        binding.textView.setText("WEAK");
        binding.textView.setBackgroundColor(Color.RED);

    }

    @Override
    public void showMedium() {
        binding.textView.setText("MEDIUM");
        binding.textView.setBackgroundColor(Color.YELLOW);


    }

    @Override
    public void showStrong() {
        binding.textView.setText("STRONG");
        binding.textView.setBackgroundColor(Color.GREEN);

    }

    @Override
    public void showVeryStrong() {
        binding.textView.setText("VERY STRONG");
        binding.textView.setBackgroundColor(Color.BLUE);

    }
}