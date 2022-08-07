package br.edu.ifsp.class02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import br.edu.ifsp.class02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private int counter = 0;

//    With ActivityMainBinding it is no longer necessary to use object references
//    private TextView textView;
//    private Button button;
//    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      To use ActivityMainBinding you always need to inflate the setContent before do anything
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        activityMainBinding.editTextInit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                counter = Integer.parseInt(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                counter++;
//                textView.setText(String.valueOf(counter));
//            }
//        });

        activityMainBinding.buttonClick.setOnClickListener(
                view -> activityMainBinding.textViewCounter.setText(String.valueOf(++counter))
        );
    }
}