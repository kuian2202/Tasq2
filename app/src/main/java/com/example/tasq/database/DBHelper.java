    package com.example.tasq.database;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.graphics.Bitmap;
    import android.widget.Toast;

    import com.example.tasq.models.ModelClass;

    import java.io.ByteArrayOutputStream;

    public class DBHelper extends SQLiteOpenHelper {
        public static final String DBNAME = "Login.db";

        public static final String COLUMN_NAME = "username";
        public static final String PASSWORD_NAME = "password";

        private ByteArrayOutputStream byteArrayOutputStream;
        private byte[] byteImage;
        private Context context;

        private static String createTableQuery = "Create table users(username TEXT " +
                ",password TEXT)";
        public DBHelper(Context context) {
            super(context, "Login.db", null, 2);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase MyDB) {
            MyDB.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
            MyDB.execSQL("drop Table if exists users");
            onCreate(MyDB);
        }

        public void updatePassword(String username, String password){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("password", password);

            String selection = "username = ?";
            String[] selectionArgs = {username};

            db.update("users", values, selection, selectionArgs);
            db.close();
        }

        public void updateName(String username, String newUsername){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", newUsername);

            String selection = "username = ?";
            String[] selectionArgs = {username};

            db.update("users", values, selection, selectionArgs);
            db.close();
        }
        public String getUsername(){
            String username = null;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{"username"});
            if(cursor.moveToFirst()){
                username = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            }
            cursor.close();
            db.close();
            return username;
        }
        public String getPassword(){
            String password = null;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from users where password = ?", new String[]{"password"});
            if(cursor.moveToFirst()){
                password = cursor.getString(cursor.getColumnIndex(PASSWORD_NAME));
            }
            cursor.close();
            db.close();
            return password;
        }
        public Cursor getUser(){
            String username = null;
            SQLiteDatabase database = this.getReadableDatabase();
            Cursor cursor = database.rawQuery("Select * from users", null);
            return cursor;
        }

        public Boolean insertData(String username, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues= new ContentValues();
            contentValues.put("username", username);
            contentValues.put("password", password);
            long result = MyDB.insert("users", null, contentValues);
            if(result==-1) return false;
            else
                return true;
        }

        public Boolean checkusername(String username) {
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
            if (cursor.getCount() > 0)
                return true;
            else
                return false;
        }

        public Boolean checkusernamepassword(String username, String password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
            if(cursor.getCount()>0)
                return true;
            else
                return false;
        }
    }
