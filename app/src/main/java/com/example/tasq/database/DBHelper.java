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
        private ByteArrayOutputStream byteArrayOutputStream;
        private byte[] byteImage;
        private Context context;

        public DBHelper(Context context) {
            super(context, "Login.db", null, 2);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase MyDB) {
            MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, image BLOB)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
            MyDB.execSQL("drop Table if exists users");
            onCreate(MyDB);
        }
        public byte[] getByteArrayFromBitmap(Bitmap bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        public void storeData(ModelClass modelClass){
            SQLiteDatabase database = this.getWritableDatabase();
            Bitmap bitmapImage = modelClass.getImage();
            byte[] byteImage = getByteArrayFromBitmap(bitmapImage);
            ContentValues contentValues = new ContentValues();
            contentValues.put("image", byteImage);
            long checkQuery = database.insert("users", null, contentValues);
            if (checkQuery != -1){
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                database.close();
            } else {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
        public void updateName(String oldUsername, String username){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", username);

            String selection = "username = ?";
            String[] selectionArgs = {oldUsername};

            db.update("users", values, selection, selectionArgs);
            db.close();
        }
        public String getUsername(){
            String username = null;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("users", new String[]{}, null,null,null,null,null);
            if(cursor.moveToFirst()){
                username = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            }
            cursor.close();
            db.close();
            return username;
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
