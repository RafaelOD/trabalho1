package br.com.facmanager.trabalho1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Preparacaomm;
    TextView Preparacaoss;
    TextView Descansomm;
    TextView Descansoss;
    TextView Exerciciomm;
    TextView Exercicioss;
    TextView Repeticao;
    Button start;
    Button sobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Preparacaoss = (TextView) findViewById(R.id.preparacaoss);
        Preparacaomm = (TextView) findViewById(R.id.preparacaomm);
        Descansoss = (TextView) findViewById(R.id.descancoss);
        Descansomm = (TextView) findViewById(R.id.descancomm);
        Exercicioss = (TextView) findViewById(R.id.exercicioss);
        Exerciciomm = (TextView) findViewById(R.id.exerciciomm);
        Repeticao = (TextView) findViewById(R.id.repeticao);

        start = (Button) findViewById(R.id.iniciar);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int preparacaomm, preparacaoss, descansomm, descansoss, exerciciomm, exercicioss, repeticao;

                try{
                    preparacaoss = Integer.parseInt(Preparacaoss.getText().toString());
                    preparacaomm = Integer.parseInt(Preparacaomm.getText().toString());
                    descansomm = Integer.parseInt(Descansomm.getText().toString());
                    descansoss = Integer.parseInt(Descansoss.getText().toString());
                    exerciciomm = Integer.parseInt(Exerciciomm.getText().toString());
                    exercicioss = Integer.parseInt(Exercicioss.getText().toString());
                    repeticao = Integer.parseInt(Repeticao.getText().toString());

                    Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                    i.putExtra("preparacaomm",preparacaomm);
                    i.putExtra("preparacaoss",preparacaoss);
                    i.putExtra("descansomm",descansomm);
                    i.putExtra("descansoss",descansoss);
                    i.putExtra("exerciciomm",exerciciomm);
                    i.putExtra("exercicioss",exercicioss);
                    i.putExtra("repeticao",repeticao);

                    startActivity(i);

                }catch (Exception e){


                }
            }
        });

        sobre = (Button) findViewById(R.id.sobre);
        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent A = new Intent(getApplicationContext(),Main3Activity.class);
                    startActivity(A);
            }
        });
    }

}
