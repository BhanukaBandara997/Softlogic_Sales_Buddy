package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import softlogic_dealer_app.com.softlogic_dealer_app.R;

public class SalesCategoryTableAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private Integer[] images = new Integer[]{R.drawable.album1, R.drawable.album2, R.drawable.album3, R.drawable.album4};

    public SalesCategoryTableAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //view inflating..
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        Log.d(String.valueOf(position), "Dot position" + position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.sales_cateogry_table_page, collection, false);
        ViewPager viewPager = (ViewPager) collection;
        viewPager.addView(view, 0);
        return view;
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
