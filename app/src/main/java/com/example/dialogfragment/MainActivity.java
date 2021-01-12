package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_show = findViewById(R.id.btn_show);


        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment fragment = dialogFragment.newInstance( String "sjfh", String"asjgulf", int R.drawable.ic_phone);
                fragment.show(getSupportFragmentManager(),null);
            }
        });

    }
}

