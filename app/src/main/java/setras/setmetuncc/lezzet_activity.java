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

public class lezzet_activity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    Button lezzettel1, lezzettel2;
    ListView lezzetlist;
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
        setContentView(R.layout.activity_lezzet_activity);
        lezzetlist = findViewById(R.id.lezzetlist);
        urunFromFB = new ArrayList<String>();
        fiyatFromFB = new ArrayList<String>();
        aciklamaFromFB = new ArrayList<String>();
        altmenuFromFB = new ArrayList<String>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        lezzettel1 = findViewById(R.id.lezzettel1);
        lezzettel2 = findViewById(R.id.lezzettel2);
        lezzettel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberone = "05338825389";

                if (ActivityCompat.checkSelfPermission(lezzet_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(lezzet_activity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String dial = "tel: " + numberone;
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                    startActivity(phone);
                }
            }
        });
        lezzettel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numbertwo = "05338648487";

                if (ActivityCompat.checkSelfPermission(lezzet_activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(lezzet_activity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                } else {
                    String dial = "tel: " + numbertwo;
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                    startActivity(phone);
                }
            }
        });
        adapter = new PostClass(altmenuFromFB, urunFromFB, aciklamaFromFB, fiyatFromFB, this);
        lezzetlist.setAdapter(adapter);
        getDataFromDB();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(this, "Call Phone Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void getDataFromDB() {
        DatabaseReference newReference = firebaseDatabase.getReference("lezzetdiyarı");
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
                Toast.makeText(lezzet_activity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
