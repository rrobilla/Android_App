package ca.camosun.androidtemperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    Button leftButton;
    Button rightButton;

    protected String a2bLabel = "C to F";
    protected String b2aLabel = "F to C";
    protected Double aVal = 0.556;
    protected Double bVal = 1.8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.conversionTypes);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this,
                R.array.conv_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);




        leftButton = findViewById(R.id.leftButton);
        leftButton.setText(a2bLabel);
        rightButton = findViewById(R.id.rightButton);
        rightButton.setText(b2aLabel);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0: // Temp
                leftButton.setText("C to F");
                rightButton.setText("F to C");
                aVal = 0.556;
                bVal = 1.8;
                break;
            case 1: // Area
                leftButton.setText("ac to ha");
                rightButton.setText("ha to ac");
                aVal = 0.405;
                bVal = 2.471;
                break;
            case 2: //Length
                leftButton.setText("ft to m");
                rightButton.setText("m to ft");
                aVal = 0.305;
                bVal = 3.281;
                break;
            case 3: //Weight
                leftButton.setText("lbs to kg");
                rightButton.setText("kg to lbs");
                aVal = 0.454;
                bVal = 2.205;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // sometimes you need nothing here
    }



    public void leftButton(View view) {
        EditText converterField = (EditText) findViewById(R.id.converterField);
        String temp = converterField.getText().toString();
        double convertedTemp = Double.parseDouble(temp) * 9.0 / 5.0 + 32.0;
        converterField.setText(Double.toString(convertedTemp));
    }
    public void rightButton(View view) {
        EditText converterField = (EditText) findViewById(R.id.converterField);
        String temp = converterField.getText().toString();
        double convertedTemp = (Double.parseDouble(temp) - 32.0) * 5.0 / 9.0;
        converterField.setText(Double.toString(convertedTemp));
    }

}
