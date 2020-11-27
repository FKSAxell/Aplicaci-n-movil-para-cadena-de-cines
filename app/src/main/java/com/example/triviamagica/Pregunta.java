package com.example.triviamagica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pregunta extends AppCompatActivity {

    PreguntaPlantilla p1 = new PreguntaPlantilla("Pregunta1","o1","o2","o3","o4",0);
    PreguntaPlantilla p2 = new PreguntaPlantilla("Pregunta2","o1","o2","o3","o4",1);
    PreguntaPlantilla p3 = new PreguntaPlantilla("Pregunta3","o1","o2","o3","o4",2);
    PreguntaPlantilla p4 = new PreguntaPlantilla("Pregunta4","o1","o2","o3","o4",3);
    PreguntaPlantilla p5 = new PreguntaPlantilla("Pregunta5","o1","o2","o3","o4",4);
    PreguntaPlantilla[] preguntas =  {p1,p2,p3,p4,p5};
    List<PreguntaPlantilla> preguntasL = Arrays.asList(preguntas);
    int cont=0;

    private Button res1 ;
    private Button res2 ;
    private Button res3 ;
    private Button res4 ;
    Button[] res=  {res1,res2,res3,res4};
    List<Button> resL = Arrays.asList(res);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        res1 = (Button) findViewById(R.id.res1);
        res2 = (Button) findViewById(R.id.res2);
        res3 = (Button) findViewById(R.id.res3);
        res4 = (Button) findViewById(R.id.res4);

       /* Button button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("nombre");
            }
        });*/
        Random rand = new Random();
        int n = rand.nextInt(preguntasL.size());
        PreguntaPlantilla p=preguntasL.get(n);
        String op1= p.getResp1();
        String op2= p.getResp2();
        String op3= p.getResp3();
        String op4= p.getResp4();
        int cor = p.getCorrecta();
        String[] respuestas =  {op1,op2,op3,op4};
        List<String> respuestasL = Arrays.asList(respuestas);
        //String respuestaC =respuestasL.get(cor);
        for (int i = 0; i < 4 ; i++) {
            Button bt = resL.get(i);
            String tex = respuestasL.get(i);
            bt.setText(tex);
        }
    }




}