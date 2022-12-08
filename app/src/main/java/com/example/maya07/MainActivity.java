package com.example.maya07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] countries ={"Israel","USA","UK","Germany","Spain","Brazil","Argentina"};
    String[] cities ={"Jerusalem","Washington D.C","London","Berlin","Madrid","Brazilia","Buenos Aires"};
    String[] population ={"9.364","331.9","67.33","83.13","47.33","214","45.81"};
    int[] imgid ={R.drawable.israel,R.drawable.usa,R.drawable.uk,R.drawable.germany,R.drawable.spain,R.drawable.brazil,R.drawable.argentina};
    TextView tv;
    Spinner spin;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        spin = (Spinner) findViewById(R.id.spin);

        spin.setOnItemSelectedListener(this);

        CustomAdapter customadp = new CustomAdapter(getApplicationContext(),
                countries,cities, imgid);
        spin.setAdapter(customadp);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        count++;
        if(count>1)
        {
            tv.setText("country: "+countries[i]+"\n" +"capital: "+cities[i]+"\n"+"population: " +population[i]+" millions");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}