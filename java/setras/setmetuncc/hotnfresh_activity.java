package setras.setmetuncc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class hotnfresh_activity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    Button hotnfreshtelone,hotnfreshteltwo;
    ListView hotnfreshlist;
    PostClass adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    ArrayList<String> altmenuFromFB;
    ArrayList<String> urunFromFB;
    ArrayList<String> fiyatFromFB;
    ArrayList<String> aciklamaFromFB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotnfresh_activity);

        hotnfreshlist = findViewById(R.id.hotnfreshlist);
        urunFromFB = new ArrayList<String>();
        fiyatFromFB = new ArrayList<String>();
        aciklamaFromFB = new ArrayList<String>();
        altmenuFromFB = new ArrayList<String>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        hotnfreshtelone = findViewById(R.id.hotnfreshtelone);
        hotnfreshteltwo = findViewById(R.id.hotnfreshteltwo);
        adapter = new PostClass(altmenuFromFB,urunFromFB,aciklamaFromFB,fiyatFromFB,this);
        hotnfreshlist.setAdapter(adapter);
        hotnfreshtelone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberone = "05488444466";

                if (ActivityCompat.checkSelfPermission(hotnfresh_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(hotnfresh_activity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial = "tel: "+numberone;
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                    startActivity(phone);
                }
            }
        });
        hotnfreshteltwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbertwo = "05338444466";

                if (ActivityCompat.checkSelfPermission(hotnfresh_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(hotnfresh_activity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial = "tel: "+numbertwo;
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                    startActivity(phone);
                }

            }
        });
        getDataFromDB();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){


                if (ActivityCompat.checkSelfPermission(hotnfresh_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(hotnfresh_activity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }
            }else{
                Toast.makeText(this, "Call Phone Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void getDataFromDB(){
        DatabaseReference newReference =firebaseDatabase.getReference("hotnfresh");
        newReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    HashMap<String,String> hashMap = (HashMap<String, String>) ds.getValue();
                    urunFromFB.add(hashMap.get("Ürün"));
                    aciklamaFromFB.add(hashMap.get("Açıklama"));
                    fiyatFromFB.add(hashMap.get("Fiyat"));
                    altmenuFromFB.add(hashMap.get("Alt menu"));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(hotnfresh_activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
