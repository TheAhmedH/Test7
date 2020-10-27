package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsHolder> {

    private List<Ingredient> mIngredientList;
    private Context mContext;

    public IngredientsAdapter(List<Ingredient> mIngredientList, Context mContext) {
        this.mIngredientList = mIngredientList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public IngredientsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recyclerview_ingredient, parent, false);
        return new IngredientsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsHolder holder, int position) {
        Ingredient currentIngredient = mIngredientList.get(position);
        String quantity = currentIngredient.getQuantity().toString();
        String ingredientName = currentIngredient.getIngredient();
        String measure = currentIngredient.getMeasure().toString();

        holder.ingredientQuantityTV.setText(quantity);
        holder.ingredientMeasureTV.setText(measure);
        holder.ingredientNameTV.setText(ingredientName);
    }

    @Override
    public int getItemCount() {
        return mIngredientList.size();
    }

    class IngredientsHolder extends RecyclerView.ViewHolder {
        TextView ingredientNameTV;
        TextView ingredientQuantityTV;
       TextView ingredientMeasureTV;

        public IngredientsHolder(@NonNull View itemView) {
            super(itemView);
            ingredientNameTV = itemView.findViewById(R.id.ingredientName_TV);
            ingredientMeasureTV = itemView.findViewById(R.id.measure_TV);
            ingredientQuantityTV = itemView.findViewById(R.id.quantity_TV);
        }
    }
}
