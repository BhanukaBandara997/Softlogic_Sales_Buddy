package softlogic_dealer_app.com.softlogic_dealer_app.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.adapter.ProductAdapter;
import softlogic_dealer_app.com.softlogic_dealer_app.model.Product;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerView = findViewById(R.id.product_recycler_view);
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        Get details intent
        String categoryName = getIntent().getStringExtra("category_name");
        getSupportActionBar().setTitle(categoryName);

        productList = new ArrayList<>();
        adapter = new ProductAdapter(ProductListActivity.this, productList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new ProductListActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        addProductToList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Adding few albums for testing
     */
    private void addProductToList() {
        int[] covers = new int[]{
                R.drawable.img1,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img7,
                R.drawable.img8,
                R.drawable.img11,
                R.drawable.img15};

        Product a = new Product("Epson EH-TW6100 Home Theater Projector", "Resolution 1080p Projector Distance Zoom: Wide 30 to 300 (0.87 - 8.9m)", "PJ-V11H501052-TW6100", " Resolution 1080p \n" +
                " Projector Distance \n" +
                " Zoom: Wide 30 to 300 (0.87 - 8.9m) \n" +
                " Zoom: Tele 30 to 300 (1.42 - 14.5m) \n " +
                " Brightness White Light \n" +
                " Output 2,300 Lumens \n" +
                " Color Light Output 2,300 Lumens \n" +
                " Lamp Life (Normal/ Eco) 4,000 hours/ 5,000 hours \n" +
                " Contrast Ratio 40,000:1 \n" +
                " Warranty 1 Year & 750 hours for lamp", "www.facebook.com/item001", "LKR 35,000", covers[0]);
        productList.add(a);

        a = new Product("Epson EH-TW6100 Home Theater Projector", "Resolution 1080p Projector Distance Zoom: Wide 30 to 300 (0.87 - 8.9m)", "PJ-V11H501052-TW6100", "Resolution 1080p \\n" +
                " Projector Distance\t  \\n" +
                " Zoom: Wide\t30 to 300 (0.87 - 8.9m) \\n" +
                " Zoom: Tele\t30 to 300 (1.42 - 14.5m) \\n" +
                " Brightness White Light \\n" +
                " Output\t2,300 Lumens \\n" +
                " Color Light Output\t2,300 Lumens \\n" +
                " Lamp Life (Normal/ Eco)\t4,000 hours/ 5,000 hours \\n" +
                " Contrast Ratio\t40,000:1 \\n" +
                " Warranty\t1 Year & 750 hours for lamp", "www.facebook.com/item001", "LKR 45,000", covers[1]);
        productList.add(a);

        a = new Product("Epson EH-TW6100 Home Theater Projector", "Resolution 1080p Projector Distance Zoom: Wide 30 to 300 (0.87 - 8.9m)", "PJ-V11H501052-TW6100", "Resolution 1080p \\n" +
                " Projector Distance\t  \\n" +
                " Zoom: Wide\t30 to 300 (0.87 - 8.9m) \\n" +
                " Zoom: Tele\t30 to 300 (1.42 - 14.5m) \\n" +
                " Brightness White Light \\n" +
                " Output\t2,300 Lumens \\n" +
                " Color Light Output\t2,300 Lumens \\n" +
                " Lamp Life (Normal/ Eco)\t4,000 hours/ 5,000 hours \\n" +
                " Contrast Ratio\t40,000:1 \\n" +
                " Warranty\t1 Year & 750 hours for lamp", "www.facebook.com/item001", "LKR 55,000", covers[2]);
        productList.add(a);

        a = new Product("Epson EH-TW6100 Home Theater Projector", "Resolution 1080p Projector Distance Zoom: Wide 30 to 300 (0.87 - 8.9m)", "PJ-V11H501052-TW6100", "Resolution 1080p \\n" +
                " Projector Distance\t  \\n" +
                " Zoom: Wide\t30 to 300 (0.87 - 8.9m) \\n" +
                " Zoom: Tele\t30 to 300 (1.42 - 14.5m) \\n" +
                " Brightness White Light \\n" +
                " Output\t2,300 Lumens \\n" +
                " Color Light Output\t2,300 Lumens \\n" +
                " Lamp Life (Normal/ Eco)\t4,000 hours/ 5,000 hours \\n" +
                " Contrast Ratio\t40,000:1 \\n" +
                " Warranty\t1 Year & 750 hours for lamp", "www.facebook.com/item001", "LKR 65,000", covers[3]);
        productList.add(a);

        a = new Product("Epson EH-TW6100 Home Theater Projector", "Resolution 1080p Projector Distance Zoom: Wide 30 to 300 (0.87 - 8.9m)", "PJ-V11H501052-TW6100", "Resolution 1080p \\n" +
                " Projector Distance\t  \\n" +
                " Zoom: Wide\t30 to 300 (0.87 - 8.9m) \\n" +
                " Zoom: Tele\t30 to 300 (1.42 - 14.5m) \\n" +
                " Brightness White Light \\n" +
                " Output\t2,300 Lumens \\n" +
                " Color Light Output\t2,300 Lumens \\n" +
                " Lamp Life (Normal/ Eco)\t4,000 hours/ 5,000 hours \\n" +
                " Contrast Ratio\t40,000:1 \\n" +
                " Warranty\t1 Year & 750 hours for lamp", "www.facebook.com/item001", "LKR 75,000", covers[4]);
        productList.add(a);

        a = new Product("Epson EH-TW6100 Home Theater Projector", "Resolution 1080p Projector Distance Zoom: Wide 30 to 300 (0.87 - 8.9m)", "PJ-V11H501052-TW6100", "Resolution 1080p \\n" +
                " Projector Distance\t  \\n" +
                " Zoom: Wide\t30 to 300 (0.87 - 8.9m) \\n" +
                " Zoom: Tele\t30 to 300 (1.42 - 14.5m) \\n" +
                " Brightness White Light \\n" +
                " Output\t2,300 Lumens \\n" +
                " Color Light Output\t2,300 Lumens \\n" +
                " Lamp Life (Normal/ Eco)\t4,000 hours/ 5,000 hours \\n" +
                " Contrast Ratio\t40,000:1 \\n" +
                " Warranty\t1 Year & 750 hours for lamp", "www.facebook.com/item001", "LKR 85,000", covers[5]);
        productList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}
