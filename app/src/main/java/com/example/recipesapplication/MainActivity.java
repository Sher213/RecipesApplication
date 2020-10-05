package com.example.recipesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> eNames = new ArrayList<>();
    private ArrayList<String> eDescs = new ArrayList<>();
    private ArrayList<String> eRecipe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecipes();
        initRecyclerView();
    }

    private void initRecipes(){
        eNames.add("Linguini");
        eDescs.add("wow this is real good linguini yummy try this one out!");
        eRecipe.add("some of this some of that and you got it");
        eNames.add("Soup");
        eDescs.add("delicious soup. Click to see recipe. Really good stuff!");
        eRecipe.add("its soup, cant be that hard!");
        eNames.add("Burger");
        eDescs.add("Juicy burger, really yummy great stuff. Easy to cook try it out!");
        eRecipe.add("you will probably need a grill and some beef.");
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(eNames, eDescs, eRecipe,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}