package softlogic_dealer_app.com.softlogic_dealer_app.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.util.Objects;

import softlogic_dealer_app.com.softlogic_dealer_app.R;

public class ProductItemActivity extends AppCompatActivity {

    //    Facebook product share link related
    public static String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
    public static String FACEBOOK_PAGE_ID = "YourPageName";
    Context mContext;
    private ImageView productImage, socialMediaLinkImage;
    private TextView productNameTxt, productSerialNumberTxt, productPriceTxt, productDescriptionTxt;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);

        mContext = getApplicationContext();

        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");


        String productName = getIntent().getStringExtra("product_name");
        String productSerialNo = getIntent().getStringExtra("product_serial_no");
        String productDescription = getIntent().getStringExtra("product_description");
        String productSocialMediaLink = getIntent().getStringExtra("product_social_media_link");
        int productThumbnail = getIntent().getIntExtra("product_thumbnail", 0);

        productNameTxt = findViewById(R.id.product_name);
        productSerialNumberTxt = findViewById(R.id.product_serial_number);
        productDescriptionTxt = findViewById(R.id.product_description);
        socialMediaLinkImage = findViewById(R.id.social_media_link);
        productImage = findViewById(R.id.product_image);

        productNameTxt.setText(productName);
        productSerialNumberTxt.setText(productSerialNo);
        productDescriptionTxt.setText(productDescription);
        Glide.with(mContext).load(productThumbnail).into(productImage);

        socialMediaLinkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(ProductItemActivity.this);
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });


    }

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}