package com.example.recyclerviewobject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.recyclerviewobject.CustomAdapter.PersonAdapter;

public class AddPersonActivity extends AppCompatActivity implements View.OnClickListener {

    Uri imageUri;
    ImageView personiv;
    EditText person_name, person_age;
    Button btnsave, btncancel;
    PersonAdapter adapter;
    private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        //instantiate
        personiv = (ImageView) findViewById(R.id.imageview2);
        person_name = (EditText) findViewById(R.id.edittextname);
        person_age = (EditText) findViewById(R.id.edittextage);

        btnsave = (Button) findViewById(R.id.btnsave);
        btncancel = (Button) findViewById(R.id.btncancel);


        personiv.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btncancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int sid = v.getId();

        switch (sid){
            case R.id.imageview2:
                Intent gallery = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
                break;
            case R.id.btnsave:
                String name = person_name.getText().toString();
                String age = person_age.getText().toString();

                if(!name.equals("") && !age.equals("")){
                    Intent intent = new Intent(); //blind intent
                    intent.putExtra("image", this.imageUri);
                    intent.putExtra("name", name);
                    intent.putExtra("age", age);

                    this.setResult(Activity.RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Fill in all fields!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btncancel:
                personiv.setImageResource(R.drawable.add_user);
                person_name.setText("");
                person_age.setText("");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode != 0){
            if(data != null){
                imageUri = data.getData();
                personiv.setImageURI(imageUri);
            }//end if
        }else{
            /////
        }
    }
}
