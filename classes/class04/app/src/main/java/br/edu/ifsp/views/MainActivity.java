package br.edu.ifsp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.buttonToClear.setOnClickListener((View view) -> {
            activityMainBinding.inputName.setText("");
            activityMainBinding.inputLastName.setText("");
            activityMainBinding.inputEmail.setText("");
            activityMainBinding.spinnerMaritalStatus.setSelection(0);
            activityMainBinding.radioButtonFemale.setChecked(true);
            person = null;
        });

        activityMainBinding.buttonToSave.setOnClickListener((View view) -> {
            person = new Person(
                    activityMainBinding.inputName.getText().toString(),
                    activityMainBinding.inputLastName.getText().toString(),
                    activityMainBinding.inputEmail.getText().toString(),
                    ((TextView) activityMainBinding.spinnerMaritalStatus.getSelectedView()).getText().toString(),
                    activityMainBinding.radioButtonFemale.isChecked() ?
                            getString(R.string.radio_button_female) :
                            getString(R.string.radio_button_male)

                    // Another way to do the same thing
//                    activityMainBinding.radioButtonFemale.isChecked() ?
//                            activityMainBinding.radioButtonFemale.getText().toString() :
//                            activityMainBinding.radioButtonMale.getText().toString()
            );

            Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
        });

        activityMainBinding.spinnerMaritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1)
                    activityMainBinding.partnerLayout.setVisibility(View.VISIBLE);
                else
                    activityMainBinding.partnerLayout.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onClick(View button) {
        if (button.getId() == R.id.buttonToSave)
            Toast.makeText(this, "You clicked on save button", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "You clicked on clear button", Toast.LENGTH_SHORT).show();
    }
}