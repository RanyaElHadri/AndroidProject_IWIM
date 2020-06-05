package com.example.androidproject_iwim;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject_iwim.models.Event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class NewEventActivity extends AppCompatActivity {

    private EditText mEventTitle;
    private EditText mEventDesc;
    private Button mSubmitBtn;

    private ImageButton mSelectImage;
    private static final int GALLERY_REQUEST = 1;

    private Uri mImageUri;

    private StorageReference mStorage;

    private ProgressDialog mProgress;

    private DatabaseReference mDatabase;

    private StorageTask mEventTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        mSelectImage = (ImageButton) findViewById(R.id.imageEvent);

        mEventTitle = (EditText) findViewById(R.id.editText1);
        mEventDesc = (EditText) findViewById(R.id.editText2);

        mSubmitBtn = (Button) findViewById(R.id.btn);

        mStorage = FirebaseStorage.getInstance().getReference();

        mProgress = new ProgressDialog(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Event");

        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(galleryIntent,GALLERY_REQUEST);

            }
        });

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEventTask != null && mEventTask.isInProgress()){
                    Toast.makeText(NewEventActivity.this,"Création en cours",Toast.LENGTH_SHORT).show();
                }else{
                    startPosting();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){

            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(mSelectImage);
        }

    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void startPosting() {

        mProgress.setMessage("Création de l'événement en cours ...");

        final String title_val = mEventTitle.getText().toString().trim();
        final String desc_val = mEventDesc.getText().toString().trim();

        if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && mImageUri!= null){

            mProgress.show();

            StorageReference filepath = mStorage.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));

            mEventTask = filepath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(
                            new OnCompleteListener<Uri>() {

                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String fileLink = task.getResult().toString();

                                    Event event = new Event(mEventTitle.getText().toString().trim(),
                                            mEventDesc.getText().toString().trim(),
                                            fileLink);

                                    String eventId = mDatabase.push().getKey();
                                    mDatabase.child(eventId).setValue(event);
                                }
                            });




                    mProgress.dismiss();

                    startActivity(new Intent(NewEventActivity.this,ListeEventsActivity.class));

                }
            });

        } else {
            Toast.makeText(this,"Vous devez remplir tous les champs !",Toast.LENGTH_SHORT).show();
        }
    }

}
