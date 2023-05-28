package com.example.tasq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tasq.database.DBHelper;
import com.example.tasq.models.ModelClass;

import java.io.IOException;

public class Settings extends AppCompatActivity {

    EditText uploadName;
    ImageView uploadImage;

    TextView newName;
    Button saveButton;
    private Uri uri;
    private Bitmap bitmapImage;
    DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);
        newName = findViewById(R.id.newName);
        uploadImage = findViewById(R.id.uploadImage);
        uploadName = findViewById(R.id.uploadName);
        saveButton = findViewById(R.id.saveButton);
        dbHelper = new DBHelper(this);
        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            assert data != null;
                            uri = data.getData();
                            try {
                                bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            } catch (IOException e) {
                                Toast.makeText(Settings.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            uploadImage.setImageBitmap(bitmapImage);
                        } else {
                            Toast.makeText(Settings.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    activityResultLauncher.launch(intent);
                } catch (Exception e){
                    Toast.makeText(Settings.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeImage();
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Add your additional functionality here

        // For example, if you want to go back to the Home activity
        Intent intent = new Intent(Settings.this, Home.class);
        startActivity(intent);

        // Finish the current activity (optional)
        finish();
    }
    private void storeImage() {
        if (!uploadName.getText().toString().isEmpty() && uploadImage.getDrawable() != null && bitmapImage != null) {
            dbHelper.storeData(new ModelClass(uploadName.getText().toString(), bitmapImage));
            Intent intent = new Intent(Settings.this, Home.class);
            startActivity(intent);
        }else if(!uploadName.getText().toString().isEmpty()){
            String user = uploadName.getText().toString();
            newName.setText(user);
            Intent intent = new Intent(Settings.this, Home.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Fields are mandatory", Toast.LENGTH_SHORT).show();
        }
    }

}
