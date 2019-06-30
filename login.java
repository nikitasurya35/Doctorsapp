package com.example.docapp.medico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {
    //private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // button=(Button) findViewById(R.id.signup);
       // button.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
              //  opendoclog();
            //}
        //});
    }
    public void opendoclog(View view){
       // Intent intent = new Intent(this,doctorlog.class);
        startActivity(new Intent(this,doctorlog.class));
    }
}
