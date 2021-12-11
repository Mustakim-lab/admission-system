package com.example.labfinal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {

    private TextView textView,textView1;
    AlertDialog.Builder alertDialog;
    Context context;

    public ResultFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_result, container, false);



        textView1=view.findViewById(R.id.information_ID);

        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("file",Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("Name","Not value");
        String birth=sharedPreferences.getString("birth","Not value");
        String gender=sharedPreferences.getString("gender","Not value");
        String phone=sharedPreferences.getString("phone","Not value");
        String ssc=sharedPreferences.getString("ssc","Not value");
        String hsc=sharedPreferences.getString("hsc","Not value");

        textView1.setText("Name: "+name+"\n"+"Death of birth: "+birth+"\n"+"Gender: "+gender+"\n"+"Phone: "+phone+"\n"+"S.S.C Result: "+ssc+"\n"+"H.S.C Result: "+hsc+"\n");

        textView=view.findViewById(R.id.resultText_ID);
        SharedPreferences sharedPreferences1=getActivity().getSharedPreferences("file", Context.MODE_PRIVATE);
        String ans_one=sharedPreferences1.getString("ans1","Not value");
        String ans_two=sharedPreferences1.getString("ans2","Not value");

        int count=0;

        if (ans_one.equals("Dhaka")){
            count=count+5;
        }
        if (ans_two.equals("Bangla")){
            count=count+5;
        }
        textView.setText("Result is= "+count+"\n"+"You are not selected!!");


        if (count==10){
            AlertDialog.Builder alert=new AlertDialog.Builder(context);

            alert.setTitle("You are selected for admission. are see the admission information?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent=new Intent(context,InformationActivity.class);
                    startActivity(intent);
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            alert.setCancelable(false);
            AlertDialog alertDialog=alert.create();
            alertDialog.show();
        }


        return view;
    }
}