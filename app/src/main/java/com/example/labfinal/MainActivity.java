package com.example.labfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEdit,deathOfEdit,phoneEdit,sscEdit,hscEdit;
    Button submitBtn;
    Spinner genderSpinner;
    String[] gender;

    AlertDialog.Builder alerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender=getResources().getStringArray(R.array.Gender);

        nameEdit=findViewById(R.id.nameEdit_ID);
        deathOfEdit=findViewById(R.id.deathOfEdit_ID);
        phoneEdit=findViewById(R.id.phoneEdit_ID);
        sscEdit=findViewById(R.id.sscResultEdit_ID);
        hscEdit=findViewById(R.id.hsscResultEdit_ID);

        genderSpinner=findViewById(R.id.genderSpinner_ID);
        submitBtn=findViewById(R.id.submitBtn_ID);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.gender_simple_layout,R.id.genderText_ID,gender);
        genderSpinner.setAdapter(arrayAdapter);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEdit.getText().toString();
                String deathof=deathOfEdit.getText().toString();
                String gender1=genderSpinner.getSelectedItem().toString();
                String phone=phoneEdit.getText().toString();
                String sscres=sscEdit.getText().toString();
                String hscres=hscEdit.getText().toString();

                if (name.isEmpty()){
                    nameEdit.setError("Enter name!!");
                    nameEdit.requestFocus();
                    return;
                }else if (deathof.isEmpty()){
                    deathOfEdit.setError("Enter death of birth!!");
                    deathOfEdit.requestFocus();
                    return;
                }else if (phone.isEmpty()){
                    phoneEdit.setError("Enter phone number!!");
                    phoneEdit.requestFocus();
                    return;
                }else if (sscres.isEmpty()){
                    sscEdit.setError("Enter s.s.c result !!");
                    sscEdit.requestFocus();
                    return;
                }else if (hscres.isEmpty()){
                    hscEdit.setError("Enter h.s.c result !!");
                    hscEdit.requestFocus();
                    return;
                }else {
                    saveData(name,deathof,gender1,phone,sscres,hscres);
                    nameEdit.setText("");
                    deathOfEdit.setText("");
                    phoneEdit.setText("");
                    sscEdit.setText("");
                    hscEdit.setText("");
                }


                alerDialog=new AlertDialog.Builder(MainActivity.this);
                alerDialog.setTitle("Are Ready viva?");
                alerDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,QuizActivity.class);
                        startActivity(intent);
                    }
                });

                alerDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                    }
                });

                alerDialog.setCancelable(false);

                AlertDialog alertDialog=alerDialog.create();
                alertDialog.show();
            }
        });
    }

    private void saveData(String name, String deathof, String gender1, String phone, String sscres, String hscres) {
        SharedPreferences sharedPreferences=getSharedPreferences("file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Name",name);
        editor.putString("birth",deathof);
        editor.putString("gender",gender1);
        editor.putString("phone",phone);
        editor.putString("ssc",sscres);
        editor.putString("hsc",hscres);
        editor.commit();

        Toast.makeText(MainActivity.this, "Your information save", Toast.LENGTH_SHORT).show();
    }

}