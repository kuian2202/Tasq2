package com.example.tasq.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tasq.ActivityAchievements;
import com.example.tasq.Home;
import com.example.tasq.models.ToDoModel;

import java.util.ArrayList;
import java.util.List;
import com.example.tasq.R;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String NAME = "toDoListDatabase";
    private static final String TODO_TABLE  = "todo";
    private static final String ID = "id";
    private static final String TASK = "task";
    private static final String STATUS = "status";
    private static final String CREATE_TODO_TABLE = "CREATE TABLE " +
    TODO_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    TASK + " TEXT, " + STATUS + " INTEGER)";
    private Context context;
    private TextView levelTextView;
    private TextView achievementsTextView;

    private SQLiteDatabase db;
    public DatabaseHandler(Context context){
        super(context, NAME, null, VERSION);
        this.context = context;
        this.levelTextView = levelTextView;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //drop old table
        db.execSQL("DROP TABLE IF EXISTS " + TODO_TABLE);
        //create table again
        onCreate(db);
    }
    public void openDatabase(){
        db = this.getWritableDatabase();
    }
    public void insertTask(ToDoModel task){
        ContentValues cv = new ContentValues();
        cv.put(TASK, task.getTask());
        cv.put(STATUS, 0);
        db.insert(TODO_TABLE, null, cv);
    }
    public List<ToDoModel>getAllTasks(){
        List<ToDoModel> taskList = new ArrayList<>();
        Cursor cur = null;
        db.beginTransaction();
        try{
            cur = db.query(TODO_TABLE, null, null, null, null, null, null, null);
            if(cur!=null){
                if (cur.moveToFirst()){
                    do{
                        ToDoModel task = new ToDoModel();
                        task.setId(cur.getInt(cur.getColumnIndex(ID)));
                        task.setTask(cur.getString(cur.getColumnIndex(TASK)));
                        task.setStatus(cur.getInt(cur.getColumnIndex(STATUS)));
                        taskList.add(task);
                    }while (cur.moveToNext());
                }
            }
        }
        finally {
            db.endTransaction();
            cur.close();
        }
        return taskList;
    }
    public void updateStatus(int id, int status, Context context){
        int previousStatus = getStatusById(id);
        ContentValues cv = new ContentValues();
        cv.put(STATUS, status);
        db.update(TODO_TABLE, cv, ID + "=?", new String[]{String.valueOf(id)});

        // Check if the status changed from incomplete to complete
        if (previousStatus == 0 && status == 1) {
            // Fetch the count of completed tasks
            int completedTaskCount = getCompletedTaskCount();

            // Check if the count is equal to 5
            if (completedTaskCount % 7 == 0) {
                levelUp();
            }
            if (completedTaskCount == 5) {
                unlockAchievement(context, "achievement 1");
            } else if (completedTaskCount == 10) {
                unlockAchievement(context, "achievement 2");
            } else if (completedTaskCount == 100) {
                unlockAchievement(context, "achievement 3");
            } else if (completedTaskCount == 500) {
                unlockAchievement(context, "achievement 4");
            } else if (completedTaskCount == 1000) {
                unlockAchievement(context, "achievement 5");
            }
        }
    }
    private void levelUp() {
        // Level up logic here
        Toast.makeText(context, "Level Up!", Toast.LENGTH_SHORT).show();
        if (context instanceof Home) {
            Home homeActivity = (Home) context;
            TextView levelTextView = homeActivity.findViewById(R.id.textView3);
            int currentLevel = Integer.parseInt(levelTextView.getText().toString().replace("Level ", ""));
            int newLevel = currentLevel + 1;
            levelTextView.setText("Level " + newLevel);
            homeActivity.saveLevelToSharedPreferences(newLevel);
        }
    }
    private void unlockAchievement(Context context, String achievementName) {
        Toast.makeText(context, "Achievement Unlocked: " + achievementName, Toast.LENGTH_SHORT).show();
    }


    private int getStatusById(int id) {
        Cursor cursor = db.query(TODO_TABLE, new String[]{STATUS}, ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()) {
            int status = cursor.getInt(cursor.getColumnIndex(STATUS));
            cursor.close();
            return status;
        }
        return -1;
    }
    public int getCompletedTaskCount() {
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TODO_TABLE + " WHERE " + STATUS + " = 1", null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }
    public void updateTask(int id, String task){
        ContentValues cv = new ContentValues();
        cv.put(TASK, task);
        db.update(TODO_TABLE, cv, ID + "=   ?", new String[] {String.valueOf(id)});
    }
    public void deleteTask(int id){
        db.delete(TODO_TABLE, ID + "=?", new String[]{String.valueOf(id)});
    }
}

