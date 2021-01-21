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

public class activity_helehele extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    ListView heleheleList;
    PostClass adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    ArrayList<String> altmenuFromFB;
    ArrayList<String> urunFromFB;
    ArrayList<String> fiyatFromFB;
    ArrayList<String> aciklamaFromFB;
    Button tel1,tel2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helehele);
        tel1 =findViewById(R.id.tel1);
        tel2 = findViewById(R.id.tel2);
        heleheleList = findViewById(R.id.helehelelist);
        urunFromFB = new ArrayList<String>();
        fiyatFromFB = new ArrayList<String>();
        aciklamaFromFB = new ArrayList<String>();
        altmenuFromFB = new ArrayList<String>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        adapter = new PostClass(altmenuFromFB, urunFromFB, aciklamaFromFB, fiyatFromFB, this);
        heleheleList.setAdapter(adapter);
        tel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberone = "05338885031";

                if (ActivityCompat.checkSelfPermission(activity_helehele.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity_helehele.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial = "tel: "+numberone;
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                    startActivity(phone);
                }
            }
        });
        tel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbertwo = "05428733644";

                if (ActivityCompat.checkSelfPermission(activity_helehele.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity_helehele.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    String dial = "tel: "+numbertwo;
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                    startActivity(phone);
                }
            }
        });
        getDataFromDB();
    }
    public void getDataFromDB() {
        DatabaseReference newReference = firebaseDatabase.getReference("helehele");
        newReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    HashMap<String, String> hashMap = (HashMap<String, String>) ds.getValue();
                    urunFromFB.add(hashMap.get("Ürün"));
                    aciklamaFromFB.add(hashMap.get("Açıklama"));
                    fiyatFromFB.add(hashMap.get("Fiyat"));
                    altmenuFromFB.add(hashMap.get("Alt menu"));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(activity_helehele.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
