package com.example.lab_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public class Books{
        List<String>getInfo(String group){
            List<String>info= new ArrayList<>();
            if (group.equals("Science")) {
                info.add("Recommended Books:");
                info.add("\nPhysics: 'Fundamentals of Physics' by Halliday & Resnick");
                info.add("\nChemistry: 'Organic Chemistry' by Morrison & Boyd");
                info.add("\nBiology: 'Biology' by Campbell & Reece");
            }

            if (group.equals("Commerce")) {
                info.add("Recommended Books:");
                info.add("\nEconomics: 'Principles of Economics' by N. Gregory Mankiw");
                info.add("\nAccounting: 'Financial Accounting' by Jerry J. Weygandt");
                info.add("\nBusiness Studies: 'Business Studies' by Peter Stimpson");
            }

            if (group.equals("Arts")) {
                info.add("Recommended Books:");
                info.add("\nHistory: 'A People's History of the United States' by Howard Zinn");
                info.add("\nLiterature: 'The Norton Anthology of English Literature'");
                info.add("\nSociology: 'Sociology' by Anthony Giddens");
            }

            return info;
        }
    }
    private Books expert= new Books();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickFindInfo(View view){
        TextView info =(TextView)  findViewById(R.id.text);
        TextView info2 =(TextView)  findViewById(R.id.infoss);
        Spinner dis = (Spinner) findViewById(R.id.spinner);
        String type=String.valueOf(dis.getSelectedItem());
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_MESSAGE, type);
        startActivity(intent);

    }
}