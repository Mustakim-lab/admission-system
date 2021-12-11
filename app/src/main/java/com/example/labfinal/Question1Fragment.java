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
import android.widget.Toast;


public class Question1Fragment extends Fragment {


    Button button;
    private RadioGroup radioGroup;
    private RadioButton radioButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question1, container, false);

        button=view.findViewById(R.id.next_ID);
        radioGroup=view.findViewById(R.id.radioGroup_ID);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int value=radioGroup.getCheckedRadioButtonId();
                radioButton=view.findViewById(value);

                String data=radioButton.getText().toString();

                SharedPreferences sharedPreferences= getActivity().getSharedPreferences("file",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("ans1",data);
                editor.commit();


                Question2Fragment question2Fragment=new Question2Fragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout_ID,question2Fragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}