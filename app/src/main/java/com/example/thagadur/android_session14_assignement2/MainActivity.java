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

        button = (Button) findViewById(R.id.button1);
        imageview = (ImageView) findViewById(R.id.imageView1);
        bytearrayoutputstream = new ByteArrayOutputStream();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hi hello How are you");
                Toast.makeText(MainActivity.this, "Hi rahul" +
                        "", Toast.LENGTH_SHORT).show();

//                Drawable drawable = getResources().getDrawable(R.drawable.rahul);
//
//                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
//
//                bitmap.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);

                file = new File(Environment.getExternalStorageDirectory() + "/rahul.png");
                try {
                    Log.e("path", "path= " + new File(Environment.getExternalStorageDirectory() + "/rahul.png").getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try

                {
                    file.createNewFile();

                    fileoutputstream = new FileOutputStream(file);

                    fileoutputstream.write(bytearrayoutputstream.toByteArray());

                    fileoutputstream.close();

                } catch (Exception e)

                {

                    e.printStackTrace();

                }

                Toast.makeText(MainActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }


        });

   /*     button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Log.i("Onclick ","Why not working ");
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();

                Drawable drawable = getResources().getDrawable(R.drawable.rahul);

                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

                bitmap.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);

                file = new File(Environment.getExternalStorageDirectory() + "/SampleImage.png");
                try {
                    Log.e("path", "path= " + new File(Environment.getExternalStorageDirectory() + "/SampleImage.png").getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try

                {
                    file.createNewFile();

                    fileoutputstream = new FileOutputStream(file);

                    fileoutputstream.write(bytearrayoutputstream.toByteArray());

                    fileoutputstream.close();

                } catch (Exception e)

                {

                    e.printStackTrace();

                }

                Toast.makeText(MainActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });*/
    }
}