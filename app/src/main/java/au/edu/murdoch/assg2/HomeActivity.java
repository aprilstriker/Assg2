package au.edu.murdoch.assg2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    DatabaseHelper db;

    Button btnAddIncome;
    Button btnAddExpense;
    String incomeAmt, expenseAmt;
    DrawerLayout drawerLayout;


//sssss
   // private DashBoardFragment dashBoardFragment;
    //private IncomeFragment incomeFragment;
    //private ExpenseFragment expenseFragment;
    ///sss

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Calendar calendar = Calendar.getInstance();
        String current = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.textView_Date);
        textViewDate.setText(current);

        btnAddExpense = (Button)findViewById(R.id.buttonAddExpense);

        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddExpenseActivity.class));
            }
        });

        btnAddIncome = (Button)findViewById(R.id.buttonAddIncome);

        btnAddIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddIncomeActivity.class));
            }
        });

        /*drawerLayout = findViewById(R.id.drawer_layout);
        findViewById(R.id.naView).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //displaySelectedListener(item.getItemId());
        return true;

    }

    /*public void expenseClick(View view) {
        Intent intent = new Intent(this, AddExpenseActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText_AddExpense);

        startActivity(intent);
    }*/

}
