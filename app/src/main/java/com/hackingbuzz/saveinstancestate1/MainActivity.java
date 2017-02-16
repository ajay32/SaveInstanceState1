package com.hackingbuzz.saveinstancestate1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //But without taking Id attribute ...by giving id we kind of save then in memory
    // if you want to know the value of saveInstanceState ... just take an edittext write something in it and run it ...your text will gone.
    //  just do this experiment by running it ...without taking saveInstance state lifecycle method..:)

    EditText textBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox = (EditText)findViewById(R.id.editBox);

    }

    // id tag save state but we need id here to initlize our edit text and also want to show how instateState work...so added just extra charSequence

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // android think String is charSequence .... so we shoud use charSequence instead of String..if we are using String ..we have to tell android by toString() method see below
        //  String text =  textBox.getText().toString();
       //   outState.putString("EditBoxText", (String) textJoined);

        CharSequence text =  textBox.getText();

        CharSequence textJoined = text + " Bye Bye!";  // bole to uhi lia :)

     outState.putCharSequence("EditTextBox", textJoined);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

            textBox.setText(savedInstanceState.getCharSequence("EditTextBox"));
    }
}
