package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import softlogic_dealer_app.com.softlogic_dealer_app.R;

public class SalesCategoryTableAdapter extends PagerAdapter {

    private Context mContext;
    private Integer[] images = new Integer[]{R.drawable.album1, R.drawable.album2, R.drawable.album3, R.drawable.album4};

    public SalesCategoryTableAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Log.d(String.valueOf(position), "Dot position" + position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.sales_cateogry_table_page, collection, false);
        ViewPager viewPager = (ViewPager) collection;

        updateSalesCategoryList(view);

        viewPager.addView(view, 0);
        return view;
    }

    private void updateSalesCategoryList(View view) {
        ImageView categoryColorImage1 = view.findViewById(R.id.category_color_image1);
        TextView categoryName1 = view.findViewById(R.id.category_name1);
        TextView salesAmount1 = view.findViewById(R.id.sales_amount1);

        categoryColorImage1.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.colorDarkGrey));
        categoryName1.setText("TEST1");
        salesAmount1.setText("2541");

        ImageView categoryColorImage2 = view.findViewById(R.id.category_color_image2);
        TextView categoryName2 = view.findViewById(R.id.category_name2);
        TextView salesAmount2 = view.findViewById(R.id.sales_amount2);

        categoryColorImage2.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.colorDarkGreen));
        categoryName2.setText("TEST2");
        salesAmount2.setText("2541");

        ImageView categoryColorImage3 = view.findViewById(R.id.category_color_image3);
        TextView categoryName3 = view.findViewById(R.id.category_name3);
        TextView salesAmount3 = view.findViewById(R.id.sales_amount3);

        categoryColorImage3.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.colorOffWhite));
        categoryName3.setText("TEST3");
        salesAmount3.setText("2541");

        ImageView categoryColorImage4 = view.findViewById(R.id.category_color_image4);
        TextView categoryName4 = view.findViewById(R.id.category_name4);
        TextView salesAmount4 = view.findViewById(R.id.sales_amount4);

        categoryColorImage4.setBackgroundTintList(mContext.getResources().getColorStateList(R.color.colorBlue));
        categoryName4.setText("TEST4");
        salesAmount4.setText("2541");
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        ViewPager viewPager = (ViewPager) collection;
        View view1 = (View) view;
        viewPager.removeView(view1);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
