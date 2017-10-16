package com.example.thagadur.android_session14_assignement2;

import android.view.View.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.thagadur.android_session14_assignement2.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //Decalred all the objects for the View and respective classes
    Button button;
    ImageView imageview;
    Bitmap bitmap;
    View view;
    ByteArrayOutputStream bytearrayoutputstream;
    File file;
    FileOutputStream fileoutputstream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Initialised the Views with respective ID  from the layout
        button = (Button) findViewById(R.id.button1);
        imageview = (ImageView) findViewById(R.id.imageView1);
        bytearrayoutputstream = new ByteArrayOutputStream();

//On click of the button saving the image from the drawable to the location in external storage
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                file = new File(Environment.getExternalStorageDirectory() + "/rahul.png");
                try {
                    //Printing the location of the Image in the LogCat
                    Log.e("path", "path= " + new File(Environment.getExternalStorageDirectory() + "/rahul.png").getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.createNewFile();
                    fileoutputstream = new FileOutputStream(file);
                    fileoutputstream.write(bytearrayoutputstream.toByteArray());
                    fileoutputstream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();
            }


        });

    }
}