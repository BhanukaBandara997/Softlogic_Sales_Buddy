package softlogic_dealer_app.com.softlogic_dealer_app.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.AccountFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.HomeFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.InvoiceFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.ProductsFragment;
import softlogic_dealer_app.com.softlogic_dealer_app.fragments.PromotionsFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.home_page:
                            openFragment(HomeFragment.newInstance("te", "te"));
                            return true;
                        case R.id.products_page:
                            openFragment(ProductsFragment.newInstance("", ""));
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
        transaction.commit();
    }

}




