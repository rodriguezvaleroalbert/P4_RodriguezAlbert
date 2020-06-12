package cat.copernic.alumnat.rodriguez.valero.p4_rodriguezalbert;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView logoSimpsons = findViewById(R.id.logo_simpsons);
        //Relacionem l'animació amb l'ImageView
        AnimationDrawable animacioLogo = (AnimationDrawable) logoSimpsons.getDrawable();
        //Iniciem l'animació
        animacioLogo.start();
    }
}