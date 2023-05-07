package com.example.bugawayme.tempTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.example.bugawayme.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class temp extends AppCompatActivity {

    private static final int REQUEST_CODE_PICK_IMAGE = 1;
    private static final int REQUEST_CODE_CAPTURE_CAMERA = 2;
    Uri imageUri ;
    File outputImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

    }

    //store
    protected void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    //camera
    protected void getImageFromCamera() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(getImageByCamera, REQUEST_CODE_CAPTURE_CAMERA);
        }
        else {
            Toast.makeText(getApplicationContext(), "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE) {
            Uri uri = data.getData();
            //to do find the path of pic by uri

        } else if (requestCode == REQUEST_CODE_CAPTURE_CAMERA) {
            Uri uri = data.getData();
            if (uri == null) {
                //use bundle to get data
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    Bitmap photo = (Bitmap) bundle.get("data"); //get bitmap
                    //path :生成图片取个名字和路径包含类型
//                    saveImage(Bitmap photo, "path");
                } else {
                    Toast.makeText(getApplicationContext(), "err****", Toast.LENGTH_LONG).show();
                    return;
                }
            } else {
                //to do find the path of pic by uri
            }
        }
    }

    public static boolean saveImage(Bitmap photo, String path) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}