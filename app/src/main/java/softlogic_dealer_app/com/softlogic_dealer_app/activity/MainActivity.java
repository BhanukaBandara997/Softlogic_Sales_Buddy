package softlogic_dealer_app.com.softlogic_dealer_app.activity;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.AccountFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.HomeFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.InvoiceFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.CategoryFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.PromotionsFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home_page:
                            openFragment(HomeFragment.newInstance("te", "te"));
                            return true;
                        case R.id.products_page:
                            openFragment(CategoryFragment.newInstance("", ""));
                            return true;
                        case R.id.promotions_page:
                            openFragment(PromotionsFragment.newInstance("", ""));
                            return true;
                        case R.id.invoice_page:
                            openFragment(InvoiceFragment.newInstance("", ""));
                            return true;
                        case R.id.account_page:
                            openFragment(AccountFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };
    private BottomNavigationView bottomNavigationView;
    private Toolbar mToolBar;
    private String[] activityTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

}




