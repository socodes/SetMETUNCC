package setras.setmetuncc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class activity_thisweek extends AppCompatActivity {
    ListView thisweeklist;
    thisweekClass adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    ArrayList<String> tipFromFB;
    ArrayList<String> isimFromFB;
    ArrayList<String> yerFromFB;
    ArrayList<String> zamanFromFB;
    ArrayList<String> kimFromFB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thisweek);
        thisweeklist = findViewById(R.id.thisweeklist);
        tipFromFB = new ArrayList<String>();
        isimFromFB = new ArrayList<String>();
        yerFromFB = new ArrayList<String>();
        zamanFromFB = new ArrayList<String>();
        kimFromFB = new ArrayList<String>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();
        adapter = new thisweekClass(tipFromFB,isimFromFB,yerFromFB, zamanFromFB, kimFromFB,this);
        thisweeklist.setAdapter(adapter);
        getDataFromDB();
    }

    private void getDataFromDB() {
        DatabaseReference newReference = firebaseDatabase.getReference("thisweek");
        newReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    HashMap<String, String> hashMap = (HashMap<String, String>) ds.getValue();
                    tipFromFB.add(hashMap.get("Tip"));
                    isimFromFB.add(hashMap.get("İsim"));
                    yerFromFB.add(hashMap.get("Yer"));
                    zamanFromFB.add(hashMap.get("Zaman"));
                    kimFromFB.add(hashMap.get("Kim"));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(activity_thisweek.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
