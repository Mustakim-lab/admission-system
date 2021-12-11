package com.example.labfinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Question2Fragment extends Fragment {


    Button button1;
    private RadioGroup radioGroup1;
    private RadioButton radioButton1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_question2, container, false);

        button1=view.findViewById(R.id.next1_ID);
        radioGroup1=view.findViewById(R.id.radio1Group_ID);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int value=radioGroup1.getCheckedRadioButtonId();
                radioButton1=view.findViewById(value);

                String data2=radioButton1.getText().toString();

                SharedPreferences sharedPreferences= getActivity().getSharedPreferences("file", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("ans2",data2);
                editor.commit();


                ResultFragment resultFragment=new ResultFragment(getContext());
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout_ID,resultFragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}