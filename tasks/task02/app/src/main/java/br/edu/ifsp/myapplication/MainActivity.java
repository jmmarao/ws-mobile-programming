package br.edu.ifsp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import br.edu.ifsp.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.buttonRegister.setOnClickListener(view -> {
                    User user = getUser();

                    String toastText = user.toString();

                    if (activityMainBinding.checkCellPhone.isChecked())
                        toastText += "\n\tCell phone: " + activityMainBinding.inputCellPhone.getText().toString();

                    if (activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Elementary School") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("High School") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Degree") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Specialization") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Master Degree") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Doctorate Degree")) {
                        toastText += "\n\tConclusion year: " + activityMainBinding.inputConclusionYear.getText().toString();
                    }

                    if (activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Degree") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Specialization") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Master Degree") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Doctorate Degree")) {
                        toastText += "\n\tInstitution: " + activityMainBinding.inputInstitution.getText().toString();
                    }

                    if (activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Master Degree") ||
                            activityMainBinding.spinnerEducationLevel.getSelectedItem().toString().equals("Doctorate Degree")) {
                        toastText += "\n\tPaper title: " + activityMainBinding.inputPostGraduateTitle.getText().toString();
                        toastText += "\n\tSupervisor: " + activityMainBinding.inputSupervisor.getText().toString();
                    }

                    Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
                }
        );

        activityMainBinding.buttonClear.setOnClickListener(view -> {
            activityMainBinding.inputName.getText().clear();
            activityMainBinding.inputEmail.getText().clear();
            activityMainBinding.spinnerPhoneType.setSelection(0);
            activityMainBinding.inputPhone.getText().clear();
            activityMainBinding.checkCellPhone.setChecked(false);
            activityMainBinding.inputCellPhone.getText().clear();
            activityMainBinding.radioButtonFemale.setChecked(true);
            activityMainBinding.inputBirthDate.getText().clear();
            activityMainBinding.inputInterestAreas.getText().clear();
            activityMainBinding.spinnerEducationLevel.setSelection(0);
            activityMainBinding.inputConclusionYear.getText().clear();
            activityMainBinding.inputInstitution.getText().clear();
            activityMainBinding.inputPostGraduateTitle.getText().clear();
            activityMainBinding.inputSupervisor.getText().clear();

            activityMainBinding.inputConclusionYear.setVisibility(View.GONE);
            activityMainBinding.inputInstitution.setVisibility(View.GONE);
            activityMainBinding.inputPostGraduateTitle.setVisibility(View.GONE);
            activityMainBinding.inputSupervisor.setVisibility(View.GONE);
        });

        activityMainBinding.checkCellPhone.setOnClickListener(view -> {
            if (activityMainBinding.checkCellPhone.isChecked())
                activityMainBinding.inputCellPhone.setVisibility(View.VISIBLE);
            else
                activityMainBinding.inputCellPhone.setVisibility(View.GONE);
        });

        activityMainBinding.spinnerEducationLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                    activityMainBinding.inputConclusionYear.setVisibility(View.VISIBLE);

                    activityMainBinding.inputInstitution.setVisibility(View.GONE);
                    activityMainBinding.inputPostGraduateTitle.setVisibility(View.GONE);
                    activityMainBinding.inputSupervisor.setVisibility(View.GONE);
                }

                if (i == 3 || i == 4 || i == 5 || i == 6) {
                    activityMainBinding.inputInstitution.setVisibility(View.VISIBLE);

                    activityMainBinding.inputPostGraduateTitle.setVisibility(View.GONE);
                    activityMainBinding.inputSupervisor.setVisibility(View.GONE);
                }

                if (i == 5 || i == 6) {
                    activityMainBinding.inputPostGraduateTitle.setVisibility(View.VISIBLE);
                    activityMainBinding.inputSupervisor.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @NonNull
    private User getUser() {
        String name = activityMainBinding.inputName.getText().toString();
        String email = activityMainBinding.inputEmail.getText().toString();
        String phoneType = activityMainBinding.spinnerPhoneType.getSelectedItem().toString();
        String phone = activityMainBinding.inputPhone.getText().toString();
        String gender = activityMainBinding.radioButtonFemale.isChecked() ? "Femmale" : "Male";
        String birthDate = activityMainBinding.inputBirthDate.getText().toString();
        String interestAreas = activityMainBinding.inputInterestAreas.getText().toString();

        return new User(name, email, phoneType, phone, gender, birthDate, interestAreas);
    }
}