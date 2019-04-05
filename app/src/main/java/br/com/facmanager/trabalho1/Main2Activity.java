package br.com.facmanager.trabalho1;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    int preparacaomm, preparacaoss, descansomm, descansoss, exerciciomm, exercicioss, repeticao;
    static long tpreparacao = 60000;
    static long tdescanso = 60000;
    static long texercicio = 60000;
    TextView timer;
    TextView repetir;
    TextView operacao;
    CountDownTimer mCountpreparacao, mCountdescanso, mCountexercio;
    ProgressBar bar;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        preparacaomm = getIntent().getIntExtra("preparacaomm", 0);
        preparacaoss = getIntent().getIntExtra("preparacaoss", 1);
        descansomm = getIntent().getIntExtra("descansomm", 2);
        descansoss = getIntent().getIntExtra("descansoss", 3);
        exerciciomm = getIntent().getIntExtra("exerciciomm", 4);
        exercicioss = getIntent().getIntExtra("exercicioss", 5);
        repeticao = getIntent().getIntExtra("repeticao", 6);

        timer = (TextView) findViewById(R.id.timer);
        repetir = (TextView) findViewById(R.id.repeticao);
        operacao = (TextView) findViewById(R.id.operacao);
        bar = (ProgressBar) findViewById(R.id.progressBar);

        contador = repeticao;
        tpreparacao = (preparacaomm * 60000) + (preparacaoss * 1000);
        //Exercício
        mCountpreparacao = new CountDownTimer(tpreparacao, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tpreparacao = millisUntilFinished;
                int minutos = (int) (tpreparacao / 1000) / 60;
                int segundos = (int) (tpreparacao / 1000) % 60;
                String timeformat = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
                timer.setText(timeformat);
                operacao.setText("Preparação");
                repetir.setText(Integer.toString(contador));

            }
            @Override
            public void onFinish() {
                mCountpreparacao.cancel();

                    texercicio = (exerciciomm * 60000) + (exercicioss * 1000);
                    mCountexercio = new CountDownTimer(texercicio, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            texercicio = millisUntilFinished;
                            int minutos = (int) (texercicio / 1000) / 60;
                            int segundos = (int) (texercicio / 1000) % 60;
                            String timeformat = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
                            timer.setText(timeformat);
                            operacao.setText("Exercício");
                            repetir.setText(Integer.toString(contador));

                        }

                        @Override
                        public void onFinish() {
                            mCountexercio.cancel();
                            tdescanso = (descansomm * 60000) + (descansoss * 1000);
                            mCountdescanso = new CountDownTimer(tdescanso, 1000) {

                                @Override
                                public void onTick(long millisUntilFinished) {
                                    tdescanso = millisUntilFinished;
                                    int minutos = (int) (tdescanso / 1000) / 60;
                                    int segundos = (int) (tdescanso / 1000) % 60;
                                    String timeformat = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
                                    timer.setText(timeformat);
                                    operacao.setText("Descanso");
                                    repetir.setText(Integer.toString(contador));

                                }

                                @Override
                                public void onFinish() {
                                    mCountdescanso.cancel();
                                    if(contador!=0){
                                        mCountexercio.start();
                                    }
                                    if(contador==0){
                                        operacao.setText("Fim");
                                        bar.setVisibility(View.INVISIBLE);
                                    }
                                }
                            }.start();
                            contador --;

                        }
                    }.start();
                }
        }.start();

        }

    }

