package br.edu.ifsp.class03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.class03.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.ckInit.setOnClickListener(view -> {
            if (activityMainBinding.ckInit.isChecked())
                counter = Integer.parseInt(activityMainBinding.ckInit.getText().toString());
        });

        activityMainBinding.zeroRb.setOnClickListener(view -> {
            counter = Integer.parseInt(activityMainBinding.zeroRb.getText().toString());
            Toast.makeText(this, "You clicked on radio button zero", Toast.LENGTH_SHORT).show();
        });

        activityMainBinding.tenRb.setOnClickListener(view -> {
            counter = Integer.parseInt(activityMainBinding.tenRb.getText().toString());
            Toast.makeText(this, "You clicked on radio button ten", Toast.LENGTH_SHORT).show();
        });

        activityMainBinding.spinnerInit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // The parameter i means the selected position and l the component id selected
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                counter = (i == 0)? 0 : (i == 1)? 5 : 10;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        activityMainBinding.buttonClick.setOnClickListener(
                view -> activityMainBinding.textViewCounter.setText(String.valueOf(++counter))
        );
    }
}