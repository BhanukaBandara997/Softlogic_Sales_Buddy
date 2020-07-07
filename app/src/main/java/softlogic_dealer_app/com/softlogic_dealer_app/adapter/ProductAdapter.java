package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductListViewHolder> {

    private Context mContext;
    private List<Product> productList;

    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.title.setText(product.getProductName());
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // loading product cover using Glide library
        Glide.with(mContext).load(product.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductListViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView price;
        public ImageView thumbnail;

        public ProductListViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.product_title);
            price = view.findViewById(R.id.product_price);
            thumbnail = view.findViewById(R.id.product_thumbnail);
        }
    }
}
