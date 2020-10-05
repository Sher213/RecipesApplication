package com.example.recipesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);
        Intent intent = getIntent();
        String recipe = intent.getStringExtra("recipeString");

        TextView textView = findViewById(R.id.recipe_exp);
        textView.setText(recipe);
    }
}