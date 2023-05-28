package com.example.tasq.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tasq.AddNewTask;
import com.example.tasq.Home;
import com.example.tasq.R;
import com.example.tasq.database.DatabaseHandler;
import com.example.tasq.models.ToDoModel;
import com.google.android.material.datepicker.DateValidatorPointBackward;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private Home home;
    private DatabaseHandler db;
    private Context context;
    public ToDoAdapter(DatabaseHandler db,Home home, Context context){
        this.db = db;
        this.home = home;
        this.context = context;
        this.todoList = new ArrayList<>();
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }
    public void onBindViewHolder(ViewHolder holder, int position){
        db.openDatabase();
        ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());

        // Set the checkbox state without triggering the listener
        holder.task.setOnCheckedChangeListener(null);
        holder.task.setChecked(toBoolean(item.getStatus()));

        // Set a tag to the checkbox to identify its position in the list
        holder.task.setTag(position);

        // Set the listener after setting the initial state
        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int adapterPosition = (int) compoundButton.getTag();
                ToDoModel selectedItem = todoList.get(adapterPosition);

                if (isChecked) {
                    db.updateStatus(selectedItem.getId(), 1, context);
                } else {
                    db.updateStatus(selectedItem.getId(), 0, context);
                }

                selectedItem.setStatus(toInteger(isChecked));
                todoList.set(adapterPosition, selectedItem);
            }
        });
    }
    private int toInteger(boolean value) {
        return value ? 1 : 0;
    }
    public int getItemCount(){
        return todoList.size();
    }
    private boolean toBoolean(int n){
        return n!=0;
    }

    public void setTasks(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }
    public Context getContext(){
        return home;
    }
    public void deleteItem(int position) {
        ToDoModel item = todoList.get(position);
        db.deleteTask(item.getId());
        todoList.remove(position);
        notifyItemRemoved(position);
    }
    public void editItem(int position){
        ToDoModel item = todoList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getTask());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(home.getSupportFragmentManager(), AddNewTask.TAG);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;

        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }
}
