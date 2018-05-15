package com.example.navaneethreddy.sortingnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> numbersList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText number = (EditText) findViewById(R.id.simpleEditText);
        final String userInput = number.getText().toString().trim();
        Button addNumber = (Button)findViewById(R.id.btn_act);
        Button sorting = (Button)findViewById(R.id.btn_act1);

        final TextView displayNumbers = (TextView)findViewById(R.id.tv_long);

        addNumber.setOnClickListener(new View.OnClickListener() {// Adding Numbers to ArrayList using button
            @Override
            public void onClick(View v) {
                final String userInput = number.getText().toString().trim();
               if (number.getText().toString().length() !=0){
                    displayNumbers.setText("");
                    numbersList.add(userInput);
                   displayNumbers.setText("Numbers before sorting :\n");
                    for(int i=0; i < numbersList.size(); i++){

                        displayNumbers.setText(displayNumbers.getText() + numbersList.get(i) + " \n ");
                    }
                    //System.out.println(numbersList.toString());
                    number.setText("");

                }
                else{
                   displayNumbers.setText("Enter the numbers first");
               }
            }

            });

       sorting.setOnClickListener(new View.OnClickListener() {// Sortinng the numbers using Sort Button
            @Override
            public void onClick(View v) {

                if (numbersList.size() != 0) {

                    Collections.sort(numbersList);

                    displayNumbers.setText("Numbers after sorting :\n");
                    for(int i=0; i<numbersList.size(); i++)
                        //System.out.println(numbersList.get(i));
                        displayNumbers.setText(displayNumbers.getText() + numbersList.get(i)+"\n");
                }
                else{
                    displayNumbers.setText("Add the numbers first and then try sorting");
                }
            }
        });


    }
}
