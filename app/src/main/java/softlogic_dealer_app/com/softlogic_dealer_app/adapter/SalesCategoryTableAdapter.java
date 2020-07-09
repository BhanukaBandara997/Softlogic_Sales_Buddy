package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

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

import java.util.ArrayList;
import java.util.List;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.model.CategorySales;

public class SalesCategoryTableAdapter extends PagerAdapter {

    private Context mContext;
    private Integer[] images = new Integer[]{R.drawable.album1, R.drawable.album2, R.drawable.album3, R.drawable.album4};
    List<CategorySales> categorySalesList = new ArrayList<>();
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

    private void getCategorySalesAccordingToPos(int position) {

    }

    private void updateSalesCategoryList(View view) {

        updateCategory1(view, R.id.category_color_image1, R.id.category_name1, R.id.sales_amount1, R.color.colorDarkGrey, "TEST1");

        updateCategory2(view, R.id.category_color_image2, R.id.category_name2, R.id.sales_amount2, R.color.colorDarkGreen, "TEST2");

        updateCategory3(view, R.id.category_color_image3, R.id.category_name3, R.id.sales_amount3, R.color.colorOffWhite, "TEST3");

        updateCategory4(view, R.id.category_color_image4, R.id.category_name4, R.id.sales_amount4, R.color.colorBlue, "TEST4");
    }

    private void updateCategory4(View view, int p, int p2, int p3, int p4, String test4) {
        ImageView categoryColorImage4 = view.findViewById(p);
        TextView categoryName4 = view.findViewById(p2);
        TextView salesAmount4 = view.findViewById(p3);

        categoryColorImage4.setBackgroundTintList(mContext.getResources().getColorStateList(p4));
        categoryName4.setText(test4);
        salesAmount4.setText("2541");
    }

    private void updateCategory3(View view, int p, int p2, int p3, int p4, String test3) {
        ImageView categoryColorImage3 = view.findViewById(p);
        TextView categoryName3 = view.findViewById(p2);
        TextView salesAmount3 = view.findViewById(p3);

        categoryColorImage3.setBackgroundTintList(mContext.getResources().getColorStateList(p4));
        categoryName3.setText(test3);
        salesAmount3.setText("2541");
    }

    private void updateCategory2(View view, int p, int p2, int p3, int p4, String test2) {
        ImageView categoryColorImage2 = view.findViewById(p);
        TextView categoryName2 = view.findViewById(p2);
        TextView salesAmount2 = view.findViewById(p3);

        categoryColorImage2.setBackgroundTintList(mContext.getResources().getColorStateList(p4));
        categoryName2.setText(test2);
        salesAmount2.setText("2541");
    }

    private void updateCategory1(View view, int p, int p2, int p3, int p4, String test1) {
        ImageView categoryColorImage1 = view.findViewById(p);
        TextView categoryName1 = view.findViewById(p2);
        TextView salesAmount1 = view.findViewById(p3);

        categoryColorImage1.setBackgroundTintList(mContext.getResources().getColorStateList(p4));
        categoryName1.setText(test1);
        salesAmount1.setText("2541");
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        ViewPager viewPager = (ViewPager) collection;
        View view1 = (View) view;
        viewPager.removeView(view1);
    }

    @Override
    public int getCount() {
//        return categorySalesList.size();
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
