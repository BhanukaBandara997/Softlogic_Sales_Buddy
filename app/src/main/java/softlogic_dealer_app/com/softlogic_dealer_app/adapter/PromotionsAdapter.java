package softlogic_dealer_app.com.softlogic_dealer_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import softlogic_dealer_app.com.softlogic_dealer_app.R;
import softlogic_dealer_app.com.softlogic_dealer_app.model.Promotion;

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.PromotionsListViewHolder> {

    private Context mContext;
    private List<Promotion> promotionList;

    public PromotionsAdapter(Context mContext, List<Promotion> promotionList) {
        this.mContext = mContext;
        this.promotionList = promotionList;
    }


    @NonNull
    @Override
    public PromotionsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotions_list_item, parent, false);
        return new PromotionsAdapter.PromotionsListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionsListViewHolder holder, int position) {
        Promotion promotion = promotionList.get(position);
        // loading category cover using Glide library
        Glide.with(mContext).load(promotion.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return promotionList.size();
    }

    public class PromotionsListViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;

        public PromotionsListViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.promotions_thumbnail);
        }
    }
}
