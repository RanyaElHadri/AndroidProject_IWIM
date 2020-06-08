package com.example.androidproject_iwim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidproject_iwim.models.Doc;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class veiw_pdf_files extends AppCompatActivity {
    ListView myPDFListview;
    DatabaseReference databaseReference;
    List<Doc> uploadPDFS;
    String pid,name;
    TextView nMatiere;
    Button mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw_pdf_files);
        pid = getIntent().getStringExtra("pid");
        name = getIntent().getStringExtra("name");
        myPDFListview=findViewById(R.id.myListView);
        uploadPDFS=new ArrayList<>();
        mHome=findViewById(R.id.homeicon);
        nMatiere=findViewById(R.id.nom_matiere);
        nMatiere.setText("Matiere: "+name);
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeActivityIntent = new Intent(veiw_pdf_files.this, EspaceEtudiantActivity.class);
                startActivity(homeActivityIntent);
            }
        });

        viewAllFiles();

        myPDFListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Doc uploadPDF = uploadPDFS.get(position);
                Intent intent= new Intent();
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void viewAllFiles(){
        databaseReference= FirebaseDatabase.getInstance().getReference().child("docmatiere").child(pid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                     Doc uploedPDF = postSnapshot.getValue(Doc.class);
                    uploadPDFS.add(uploedPDF);
            }
                String[] uploads = new String[uploadPDFS.size()];
                for(int i=0;i<uploads.length;i++){
                    uploads[i]=uploadPDFS.get(i).getDocname();

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position,convertView,parent);
                        TextView myText=(TextView)view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                myPDFListview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
