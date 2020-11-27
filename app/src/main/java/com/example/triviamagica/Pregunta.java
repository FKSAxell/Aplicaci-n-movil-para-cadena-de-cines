package com.example.triviamagica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Pregunta extends AppCompatActivity {

    PreguntaPlantilla p1 = new PreguntaPlantilla("¿Quien era el dueño y piloto de el Halcon Milenario?","Chewbacca","Obi-Wan Kenobi","Han Solo","R2D2",2,"nave");
    PreguntaPlantilla p2 = new PreguntaPlantilla("¿Cual es la verdadera identidad de Darth Vader?","Luke Skywalker","Anakin Skywalker","Jar Jar Binks","Leia Skywalker",1,"dark");
    PreguntaPlantilla p3 = new PreguntaPlantilla("¿Como se llama este personaje?","Jar JAr Binks","C3P0","Chewbacca","Wookiee",2,"chu");
    PreguntaPlantilla p4 = new PreguntaPlantilla("Este personaje era mejor conocido como:","Maestro Yoda","Maestro Windu","Maestro Kenobi","Maestro Shaak Ti",0,"ver");
    PreguntaPlantilla p5 = new PreguntaPlantilla("¿Como se llama este personaje ?","Conde Dooku","kylo Ren","emperador Palpatine","Jabba the hut",3,"ani");
    PreguntaPlantilla[] preguntas =  {p1,p2,p3,p4,p5};
    List<PreguntaPlantilla> preguntasL = new LinkedList<>(Arrays.asList(preguntas));

    int cont=5;
    int resueltas=0;

    private Button res1 ;
    private Button res2 ;
    private Button res3 ;
    private Button res4 ;
    private TextView textPreg;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        res1 = (Button) findViewById(R.id.res1);
        res2 = (Button) findViewById(R.id.res2);
        res3 = (Button) findViewById(R.id.res3);
        res4 = (Button) findViewById(R.id.res4);
        textPreg = (TextView) findViewById(R.id.textPreg);
        image = (ImageView)  findViewById(R.id.imagen);
        Button[] res=  {res1,res2,res3,res4};
        List<Button> resL = Arrays.asList(res);
        Random rand = new Random();
        int n = rand.nextInt(cont);
        PreguntaPlantilla p=preguntasL.get(n);
        String op1= p.getResp1();
        String op2= p.getResp2();
        String op3= p.getResp3();
        String op4= p.getResp4();
        int cor = p.getCorrecta();
        String[] respuestas =  {op1,op2,op3,op4};
        List<String> respuestasL = Arrays.asList(respuestas);
        String preg= p.getNombre();
        textPreg.setText(preg);
        image.setImageResource(getImageId(this, p.getImg()));
        for (int i = 0; i < 4 ; i++) {
            Button bt = resL.get(i);
            String tex = respuestasL.get(i);
            bt.setText(tex);

            if (cor == i){
                bt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        preguntasL.remove(preguntasL.get(n));
                        resueltas++;
                        cont--;
                        cambio();

                    }
                });
            }else{
                bt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                        Intent intent = new Intent(Pregunta.this, Perder.class);
                        intent.putExtra("cuantas", resueltas);
                        startActivity(intent);
                    }
                });

            }

        }

    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    public void cambio(){
        res1 = (Button) findViewById(R.id.res1);
        res2 = (Button) findViewById(R.id.res2);
        res3 = (Button) findViewById(R.id.res3);
        res4 = (Button) findViewById(R.id.res4);
        textPreg = (TextView) findViewById(R.id.textPreg);
        Button[] res=  {res1,res2,res3,res4};
        List<Button> resL = Arrays.asList(res);

       /* Button button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("nombre");
            }
        });*/
        Random rand = new Random();
        int n = rand.nextInt(cont);
        PreguntaPlantilla p=preguntasL.get(n);
        String op1= p.getResp1();
        String op2= p.getResp2();
        String op3= p.getResp3();
        String op4= p.getResp4();
        int cor = p.getCorrecta();
        String[] respuestas =  {op1,op2,op3,op4};
        List<String> respuestasL = Arrays.asList(respuestas);
        String preg= preguntasL.get(n).getNombre();
        textPreg.setText(preg);
        image.setImageResource(getImageId(this, p.getImg()));
        for (int i = 0; i < 4 ; i++) {
            Button bt = resL.get(i);
            String tex = respuestasL.get(i);
            bt.setText(tex);
            if (cor == i) {
                bt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        preguntasL.remove(p);
                        resueltas++;
                        cont--;
                        if (cont ==0){
                            finish();
                            Intent intent = new Intent(Pregunta.this, Codigoqr.class);

                            startActivity(intent);
                        }else{
                            cambio();
                        }
                    }
                });
            } else {
                bt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        finish();
                        Intent intent = new Intent(Pregunta.this, Perder.class);
                        intent.putExtra("cuantas", resueltas);
                        startActivity(intent);
                    }
                });

            }

        }
    }



}