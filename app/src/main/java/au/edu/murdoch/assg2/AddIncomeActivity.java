package au.edu.murdoch.assg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddIncomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] InCategories = { "Food", "Transport", "Travel", "Rental"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        Spinner InSpin = (Spinner) findViewById(R.id.spinnerInCategory);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, InCategories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        InSpin.setAdapter(adapter);
        InSpin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), "Selected category : "+InCategories[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }
}
