package com.example.recipesapplication;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> entryNames = new ArrayList<>();
    private ArrayList<String> entryDesc = new ArrayList<>();
    private ArrayList<String> entryRecipe = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> names, ArrayList<String>  desc, ArrayList<String> recipe, Context context) {
        entryNames = names;
        entryDesc = desc;
        entryRecipe = recipe;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.recipe_name.setText(entryNames.get(position));
        holder.recipe_desc.setText(entryDesc.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onBindViewHolder: clicked on:" + entryNames.get(position));
                Intent intent = new Intent(mContext, DisplayRecipeActivity.class);
                intent.putExtra("recipeString", entryRecipe.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return entryNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView recipe_name;
        TextView recipe_desc;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recipe_name = itemView.findViewById(R.id.recipe_name);
            recipe_desc = itemView.findViewById(R.id.recipe_desc);
            parentLayout = itemView.findViewById(R.id.entryLayout);
        }
    }
}
