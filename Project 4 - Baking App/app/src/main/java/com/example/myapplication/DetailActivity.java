package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    List<Ingredient> mIngredientList = new ArrayList<>();
    private IngredientsAdapter mIngredientsAdapter;
    private RecyclerView mIngredientRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_detail);

       mIngredientList = (List<Ingredient>) getIntent().getSerializableExtra("myIngredientList");
       mIngredientRecyclerView = findViewById(R.id.ingredient_RV);

       mIngredientsAdapter = new IngredientsAdapter(mIngredientList, getApplicationContext());

       mIngredientRecyclerView.setAdapter(mIngredientsAdapter);


    }
}
