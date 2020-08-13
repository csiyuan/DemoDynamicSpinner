package sg.edu.rpc346.id19016011.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);
        alNumbers = new ArrayList<>();
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn2.setAdapter(aaNumbers);


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                //Approach 2
//                alNumbers.clear();
//
//                if (pos == 0){
//                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }
//                else{
//                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }
//                aaNumbers.notifyDataSetChanged();
//            }
                switch (pos){
                    case 0:
                        alNumbers.clear();
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumbers.clear();
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(1);
                        break;
                }
                aaNumbers.notifyDataSetChanged();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if (pos == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();

            }
        });


    }
}
