package com.jenjenfuture.geometrycalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonresult;
    private TextView textView1;
    private TextView textView2;
    private EditText editText1;
    private EditText editText2;
    private TextView result;
    private Spinner spinner;
    private TextView ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonresult = findViewById(R.id.cal);
        buttonresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().equals("Circle"))
                {
                    boolean error = false;
                    if (editText1.getText().toString().equals(""))
                    {
                        error = true;
                        editText1.setError("This field may not be empty");
                    }

                    if (!error)
                    {
                        double r = Double.parseDouble(editText1.getText().toString());
                        double square = Math.PI * Math.pow(r,2);
                        result.setText(String.valueOf(square));
                    }

                }
                else if (spinner.getSelectedItem().toString().equals("Rectangle"))
                {
                    boolean error = false;
                    if (editText1.getText().toString().equals(""))
                    {
                        error = true;
                        editText1.setError("This field may not be empty");
                    }
                    if (!error) {
                        double p = Double.parseDouble(editText1.getText().toString());
                        double l = Double.parseDouble(editText2.getText().toString());

                        double rectang = p * l;
                        result.setText(String.valueOf(rectang));
                    }
                }
                else if (spinner.getSelectedItem().toString().equals("Triangle"))
                {
                    boolean error = false;
                    if (editText1.getText().toString().equals(""))
                    {
                        error = true;
                        editText1.setError("This field may not be empty");
                    }
                    if(!error) {
                        double a = Double.parseDouble(editText1.getText().toString());
                        double t = Double.parseDouble(editText2.getText().toString());

                        double triang = (double) a * t / 2;
                        result.setText(String.valueOf(triang));
                    }
                }
                else if (spinner.getSelectedItem().toString().equals("Square"))
                {
                    boolean error = false;
                    if (editText1.getText().toString().equals(""))
                    {
                        error = true;
                        editText1.setError("This field may not be empty");
                    }
                    if (!error) {
                        Double a = Double.parseDouble(editText1.getText().toString());

                        double square = Math.pow(a, 2);
                        result.setText(String.valueOf(square));
                    }
                }
            }
        });
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        result= findViewById(R.id.result);
        spinner= findViewById(R.id.id_action_bar_spinner);
        editText1 = findViewById(R.id.edit1);
        editText2= findViewById(R.id.edit2);
        ok = findViewById(R.id.ok);

        String[] arraySpinner = new String[] {
                "Circle", "Rectangle", "Square", "Triangle"
        };
        spinner = (Spinner) findViewById(R.id.id_action_bar_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getItemAtPosition(position).equals("Circle"))
                {
                    textView2.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                    ok.setVisibility(View.INVISIBLE);
                    textView1.setText("Radius");
                    editText1.setText("");
                    result.setText("");
                }
                else if (spinner.getItemAtPosition(position).equals("Triangle"))
                {
                    textView2.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    ok.setVisibility(View.VISIBLE);
                    textView2.setText("Height");
                    textView1.setText("Base");
                    editText1.setText("");
                    editText2.setText("");
                    result.setText("");
                }
                else if (spinner.getItemAtPosition(position).equals("Square"))
                {
                    textView2.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                    ok.setVisibility(View.INVISIBLE);
                    textView1.setText("Side");
                    editText1.setText("");
                    result.setText("");
                }
                else if (spinner.getItemAtPosition(position).equals("Rectangle"))
                {
                    textView2.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    ok.setVisibility(View.VISIBLE);
                    textView2.setText("Width");
                    textView1.setText("Length");
                    editText1.setText("");
                    editText2.setText("");
                    result.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
