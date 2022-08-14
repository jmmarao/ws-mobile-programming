package br.edu.ifsp.formapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import br.edu.ifsp.formapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        Spinner spinner = findViewById(activityMainBinding.spinner.getId());

        spinner.setAdapter(new ArrayAdapter<FU>(
                this, android.R.layout.simple_spinner_item, FU.values()));

        activityMainBinding.btnSave.setOnClickListener(
                view -> {
                    Form form = populateForm();

                    Toast.makeText(this, form.toString(), Toast.LENGTH_LONG).show();
                }
        );

        activityMainBinding.btnClear.setOnClickListener(
                view -> clearForm()
        );
    }

    @NonNull
    private Form populateForm() {
        String name = activityMainBinding.inputName.getText().toString();
        String phone = activityMainBinding.inputPhone.getText().toString();
        String email = activityMainBinding.inputEmail.getText().toString();
        boolean isSubscriber = activityMainBinding.ckSubscriberList.isChecked();
        String gender = activityMainBinding.radioGenderFemale.isChecked() ? "Female" : "Male";
        String city = activityMainBinding.inputCity.getText().toString();
        String fu = activityMainBinding.spinner.getSelectedItem().toString();

        return new Form(name, phone, email, isSubscriber, gender, city, fu);
    }

    private void clearForm() {
        activityMainBinding.inputName.getText().clear();
        activityMainBinding.inputPhone.getText().clear();
        activityMainBinding.inputEmail.getText().clear();
        activityMainBinding.ckSubscriberList.setChecked(false);
        activityMainBinding.radioGroup.clearCheck();
        activityMainBinding.inputCity.getText().clear();
        activityMainBinding.spinner.setAdapter(new ArrayAdapter<FU>(
                this, android.R.layout.simple_spinner_item, FU.values()));
    }
}