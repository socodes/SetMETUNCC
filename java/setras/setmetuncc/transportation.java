package setras.setmetuncc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class transportation extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        ListView transportationList = findViewById(R.id.transportationList);
        ArrayList<String> departure = new ArrayList<String>();
        departure.add("Guzelyurt-Lefkosa   -   Çimen:    +90 392 714 61 11");
        departure.add("Lefkoşa-Güzelyurt   -   Çimen:    +90 392 228 86 15");
        departure.add("Lefkoşa-Güzelyurt   -   Akva:     +90 392 227 25 29");
        departure.add("Güzelyurt-Lefkoşa   -   Akva:     +90 392 714 49 70");
        departure.add("Lefkoşa - Girne     -   Kombos:   +90 392 227 29 29");
        departure.add("Girne - Lefkoşa     -   Kombos:   +90 392 815 23 17");
        departure.add("Güzelyurt - Girne   -   Çimen:    +90 392 714 61 11");
        departure.add("Girne - Güzelyurt   -   Çimen:    +90 392 815 31 44");
        departure.add("Lefkoşa - Gazimağusa-   İtimat:   +90 392 227 27 43");
        departure.add("Gazimağusa - Lefkoşa-   İtimat:   +90 392 366 66 66");
        departure.add("Kıbhas Ercan Ofis:      +90 533 870 78 48");
        departure.add("Kıbhas Güzelyurt Ofis:  +90 533 870 78 49");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,departure);

        transportationList.setAdapter(arrayAdapter);

        transportationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (ActivityCompat.checkSelfPermission(transportation.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(transportation.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else{
                    if(position==0){
                        String position1 = "+903927146111";
                        String dial = "tel: "+position1;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 1){
                        String position2 = "+903922288615";
                        String dial = "tel: "+position2;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 2){
                        String position3 = "+903922272529";
                        String dial = "tel: "+position3;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 3){
                        String position4 = "+903927144970";
                        String dial = "tel: "+position4;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 4){
                        String position5 = "+903922272929";
                        String dial = "tel: "+position5;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 5){
                        String position6 = "+903928152317";
                        String dial = "tel: "+position6;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 6){
                        String position7 = "+903927146111";
                        String dial = "tel: "+position7;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 7){
                        String position8 = "+903928153144";
                        String dial = "tel: "+position8;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 8){
                        String position9 = "+903922272743";
                        String dial = "tel: "+position9;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 9){
                        String position10 = "+903923666666";
                        String dial = "tel: "+position10;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 10){
                        String position11 = "+905338707848";
                        String dial = "tel: "+position11;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }
                    else if(position == 11){
                        String position12 = "+905338707849";
                        String dial = "tel: "+position12;
                        Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse(dial));
                        startActivity(phone);
                    }

                }
            }
        });
    }

}
