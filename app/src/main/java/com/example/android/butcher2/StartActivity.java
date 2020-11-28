package com.example.android.butcher2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;

//songhui20201101
public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //로딩 액티비티 실행
        Intent intent=new Intent(this,Loading.class);

        ImageButton camerabutton = (ImageButton)findViewById(R.id.btn_camera);
        camerabutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CameraActivity.class);
                startActivity(intent);
            }
        });
        ImageButton lookbook = (ImageButton)findViewById(R.id.btn_lookbook);
        lookbook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri targetUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                String targetDir = Environment.getExternalStorageDirectory().toString() + "/AnimationCapture";
                targetUri = targetUri.buildUpon().appendQueryParameter("bucketId",String.valueOf(targetDir.toLowerCase().hashCode())).build();
                Intent intent = new Intent(Intent.ACTION_VIEW, targetUri);
                startActivity(intent);
            }
        });
    }
}