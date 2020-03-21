package au.edu.murdoch.assg2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    DatabaseHelper db;

//sssss
   // private DashBoardFragment dashBoardFragment;
    //private IncomeFragment incomeFragment;
    //private ExpenseFragment expenseFragment;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }






    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //displaySelectedListener(item.getItemId());
        return true;

    }
}
