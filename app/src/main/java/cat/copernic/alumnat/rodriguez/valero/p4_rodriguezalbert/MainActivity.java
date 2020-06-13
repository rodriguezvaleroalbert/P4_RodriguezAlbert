package cat.copernic.alumnat.rodriguez.valero.p4_rodriguezalbert;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView logoSimpsons = findViewById(R.id.logo_simpsons);
        final ImageView engranatgeVermell = findViewById(R.id.engranatge_vermell);
        final ImageView engranatgeVerd = findViewById(R.id.engranatge_verd);
        final ImageView engranatgeblau = findViewById(R.id.engranatge_blau);
        final ImageView ull = findViewById(R.id.ull);
        final ImageView donut = findViewById(R.id.donut);
        //Relacionem l'animació amb l'ImageView
        AnimationDrawable animacioLogo = (AnimationDrawable) logoSimpsons.getDrawable();
        //Iniciem l'animació
        animacioLogo.start();
        //Fem invisibles els engranatges, l'ull i el donut
        engranatgeVermell.setVisibility(View.INVISIBLE);
        engranatgeblau.setVisibility(View.INVISIBLE);
        engranatgeVerd.setVisibility(View.INVISIBLE);
        ull.setVisibility(View.INVISIBLE);
        donut.setVisibility(View.INVISIBLE);
        /* Quan l'usuari cliqui el logo, si els engranatges, el donut i l'ull NO són visibles
         * es tornen visibles, si ja són visibles, es tornen invisibles */
        logoSimpsons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (engranatgeVermell.getVisibility() == View.VISIBLE) {
                    engranatgeVermell.setVisibility(View.INVISIBLE);
                    engranatgeblau.setVisibility(View.INVISIBLE);
                    engranatgeVerd.setVisibility(View.INVISIBLE);
                    ull.setVisibility(View.INVISIBLE);
                    donut.setVisibility(View.INVISIBLE);
                } else {
                    engranatgeblau.setVisibility(View.VISIBLE);
                    engranatgeVerd.setVisibility(View.VISIBLE);
                    engranatgeVermell.setVisibility(View.VISIBLE);
                    ull.setVisibility(View.VISIBLE);
                    donut.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}