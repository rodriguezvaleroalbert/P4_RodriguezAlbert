package cat.copernic.alumnat.rodriguez.valero.p4_rodriguezalbert;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Boolean mReproduint = false;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView logoSimpsons = findViewById(R.id.logo_simpsons);
        final ImageView engranatgeVermell = findViewById(R.id.engranatge_vermell);
        final ImageView engranatgeVerd = findViewById(R.id.engranatge_verd);
        final ImageView engranatgeBlau = findViewById(R.id.engranatge_blau);
        final ImageView ull = findViewById(R.id.ull);
        final ImageView donut = findViewById(R.id.donut);
        //Relacionem l'animació amb l'ImageView
        AnimationDrawable animacioLogo = (AnimationDrawable) logoSimpsons.getDrawable();
        //Iniciem l'animació
        animacioLogo.start();
        //Fem invisibles els engranatges, l'ull i el donut
        engranatgeVermell.setVisibility(View.INVISIBLE);
        engranatgeBlau.setVisibility(View.INVISIBLE);
        engranatgeVerd.setVisibility(View.INVISIBLE);
        ull.setVisibility(View.INVISIBLE);
        donut.setVisibility(View.INVISIBLE);
        //Creem les animacions
        final Animation animacioVermell = AnimationUtils.loadAnimation(this, R.anim.animacio_vermell);
        final Animation animacioBlau = AnimationUtils.loadAnimation(this, R.anim.animacio_blau);
        final Animation animacioVerd = AnimationUtils.loadAnimation(this, R.anim.animacio_verd);
        final Animation animacioDonut = AnimationUtils.loadAnimation(this, R.anim.anim_donut);
        final Animation animacioUll = AnimationUtils.loadAnimation(this, R.anim.anim_ull);
        /* Quan l'usuari cliqui el logo, si els engranatges, el donut i l'ull NO són visibles
         * es tornen visibles, si ja són visibles, es tornen invisibles */
        logoSimpsons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (engranatgeVermell.getVisibility() == View.VISIBLE) {
                    //S'aturen les animacions dels engranatges per poder-los tornar a fer invisibles
                    engranatgeVermell.clearAnimation();
                    engranatgeBlau.clearAnimation();
                    engranatgeVerd.clearAnimation();
                    //S'atura l'animació del donut
                    donut.clearAnimation();
                    //S'atura l'animació de l'ull
                    ull.clearAnimation();
                    engranatgeVermell.setVisibility(View.INVISIBLE);
                    engranatgeBlau.setVisibility(View.INVISIBLE);
                    engranatgeVerd.setVisibility(View.INVISIBLE);
                    ull.setVisibility(View.INVISIBLE);
                    donut.setVisibility(View.INVISIBLE);
                } else {
                    engranatgeBlau.setVisibility(View.VISIBLE);
                    engranatgeVerd.setVisibility(View.VISIBLE);
                    engranatgeVermell.setVisibility(View.VISIBLE);
                    ull.setVisibility(View.VISIBLE);
                    donut.setVisibility(View.VISIBLE);
                    //S'inicíen les animacions dels engranatges
                    engranatgeVermell.startAnimation(animacioVermell);
                    engranatgeBlau.startAnimation(animacioBlau);
                    engranatgeVerd.startAnimation(animacioVerd);
                    //S'inicia l'animació del Donut
                    donut.startAnimation(animacioDonut);
                    //S'inicia l'animació de l'Ull
                    ull.startAnimation(animacioUll);
                }
            }
        });
        //Declarem el MediaPlayer amb la cançó
        mPlayer = MediaPlayer.create(this, R.raw.the_simpsons);
        //Establim la ruta del fitxer de so
        /* Quan es piqui sobre el donut, si s'està reproduïnt l'audio s'aturarà, en cas qcontrari
         * s'iniciarà la reproducció. */
        donut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mReproduint) {
                    //Atura reproducció
                    mPlayer.pause();
                } else {
                    //Iniciem la reproducció
                    mPlayer.start();
                }
                //Canvia l'estat
                mReproduint = !mReproduint;
            }
        });
    }
}