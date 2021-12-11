package com.example.labfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    private Spinner spinner,spinner1;
    private TextView resultText;
    private Button button;
    String[] program,semester;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

       program=getResources().getStringArray(R.array.program);
       semester=getResources().getStringArray(R.array.semester);

       button=findViewById(R.id.resultBtn_ID);
       resultText=findViewById(R.id.result_ID);

       spinner=findViewById(R.id.spinner_program_ID);
       ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(CalculateActivity.this,R.layout.program_layout,R.id.programText_ID,program);
       spinner.setAdapter(arrayAdapter);

       spinner1=findViewById(R.id.spinner_semester_ID);
       ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(CalculateActivity.this,R.layout.semester_layout,R.id.semesterText1_ID,semester);
       spinner1.setAdapter(arrayAdapter1);



       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String data=spinner.getSelectedItem().toString();
               String data1=spinner1.getSelectedItem().toString();

               if (data.equals("C.S.E")){
                   double value=Double.parseDouble(data1);
                   if (data1.equals("0")){
                       //double value=Double.parseDouble(data1);
                       result=value*0;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("1")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("2")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("3")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("4")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("5")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("6")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("7")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("8")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("9")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("10")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("11")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("12")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }

               }else if (data.equals("E.E.E")){
                   double value=Double.parseDouble(data1);
                   if (data1.equals("0")){
                       //double value=Double.parseDouble(data1);
                       result=value*0;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("1")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("2")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("3")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("4")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("5")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("6")){
                       result=value*65000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("7")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("8")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("9")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("10")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("11")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }else if (data1.equals("12")){
                       result=value*84000;
                       resultText.setText("Total Amount: "+result);
                   }
               }
           }
       });



    }

}