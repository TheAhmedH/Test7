package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class RecipeDishAdapter extends RecyclerView.Adapter<RecipeDishAdapter.RecipeDishHolder> {
    private List<RecipeDish> mRecipeDishList;
    private Context mContext;
    private OnRecipeDishListener mOnRecipeDishListener;


    public RecipeDishAdapter(Context mContext, List<RecipeDish> mRecipeDishList, OnRecipeDishListener onRecipeDishListener) {
        this.mRecipeDishList = mRecipeDishList;
        this.mContext = mContext;
        this.mOnRecipeDishListener = onRecipeDishListener;
    }

    @NonNull
    @Override
    public RecipeDishHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_dish_list, parent, false);
        return new RecipeDishHolder(view, mOnRecipeDishListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDishHolder holder, int position) {
        RecipeDish currentDish = mRecipeDishList.get(position);
        String dishName = currentDish.getName();
        String imageURL = currentDish.getImage();
        holder.recipeDish_TV.setText(dishName);

    }

    class RecipeDishHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView recipeDish_IV;
        TextView recipeDish_TV;
        OnRecipeDishListener onRecipeDishListener;

        public RecipeDishHolder(@NonNull View itemView, OnRecipeDishListener onRecipeDishListener) {
            super(itemView);
            this.onRecipeDishListener = onRecipeDishListener;
            recipeDish_TV = itemView.findViewById(R.id.dish_name_textview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
         onRecipeDishListener.onRecipeDishClick(getAdapterPosition());
        }
    }

    //method to set RecipeDishList
    public void setRecipeDishList(List<RecipeDish> mRecipeDishList) {
        this.mRecipeDishList = mRecipeDishList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mRecipeDishList.size();
    }

    //Creating an interface
    public interface OnRecipeDishListener {
        void onRecipeDishClick(int position);
    }

    public List<RecipeDish> getmRecipeDishList() {
        return mRecipeDishList;
    }
}
