package cl.example.generadorpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cl.example.generadorpassword.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
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
 *     - atributos : niveles de fortalezas de la contraseña (debil, media, fuerte , super fuerte, largo de contraseña (min.))
 *     - generar metodos de verificacion.
 *
 * Presenter
 * 4.- Generar clase Presenter
 *     - crear interfaz presenterView
 *     - atributos
 *
 *   View
 * 5.- Main activity implementar metodos de la interfaz
 * 6.- extraer recursos (values strings, colors)
 * 7.- agregar listener en editText
 *
 *  test
 * 8.- Agregar dependencias de test en build.gradle
 * 9.- agregar test unitarios para modelo
 * 10.- agregar test unitarios para presentador
 *
 */

   private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}