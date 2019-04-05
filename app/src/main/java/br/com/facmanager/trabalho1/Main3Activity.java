package br.com.facmanager.trabalho1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(R.drawable.documentacao);
      //S  PhotoViewAttacher p = new PhotoViewAttacher(img);
    }
}
