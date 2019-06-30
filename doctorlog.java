package com.example.docapp.medico;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class doctorlog extends AppCompatActivity implements View.OnClickListener {
    private EditText fname,lname,degree,experience,etusername,etpasswd;
    //String Firstname , Lastname,Degree,Experience,username, passwd;
    private Button button;
    private ProgressDialog progressDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlog);


        fname =(EditText) findViewById(R.id.name);
        lname= (EditText) findViewById(R.id.lastname);
        degree= (EditText) findViewById(R.id.deg);
        experience= (EditText) findViewById(R.id.exp);
        etusername= (EditText) findViewById(R.id.uname);
        etpasswd= (EditText) findViewById(R.id.pass);

        button=(Button) findViewById(R.id.register);
        button.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);



    }



    @Override
    public void onClick(View v) {
        if (v==button)
            registerlog();
    }

    private void registerlog() {

        button=(Button) findViewById(R.id.register);
        fname =(EditText) findViewById(R.id.name);
        lname= (EditText) findViewById(R.id.lastname);
        degree= (EditText) findViewById(R.id.deg);
        experience= (EditText) findViewById(R.id.exp);
        etusername= (EditText) findViewById(R.id.uname);
        etpasswd= (EditText) findViewById(R.id.pass);

        final String Firstname=fname.getText().toString().trim();
        final String Lastname=lname.getText().toString().trim();
        final String Degree=degree.getText().toString().trim();
        final String Experience=experience.getText().toString().trim();
        final String username=etusername.getText().toString().trim();
        final String passwd= etpasswd.getText().toString().trim();
        /*String String method = "register";
        Stringbackground backgroundTask = new background(this);
        backgroundTask.execute(method,Firstname,Lastname,Degree,Experience,username,passwd);
//backgroundTask is variable
//background is the method or funct in backgrounftask class
        finish();*/

        progressDialog.setMessage("Registering...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, constant.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("Message.."),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();


                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("Firstname",Firstname);
                params.put("Lastname",Lastname);
                params.put("Degree",Degree);
                params.put("Experience",Experience);
                params.put("username",username);
                params.put("passwd",passwd);
                return params;




            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
