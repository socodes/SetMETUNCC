package setras.setmetuncc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class restaurants_activity extends AppCompatActivity {
    ImageView adaimage,cagimage,donatelloimage,ebimage,gundasimage,hotnfreshimage,kalkanlimage;
    ImageView komageneimage,lavishimage,sedoimage,vosvosimage,lezzetimage;
    ImageView heleheleimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_activity);

        adaimage = findViewById(R.id.adaimage);
        cagimage = findViewById(R.id.cagimage);
        donatelloimage = findViewById(R.id.donatelloimage);
        ebimage = findViewById(R.id.ebimage);
        gundasimage = findViewById(R.id.gundasimage);
        heleheleimage = findViewById(R.id.heleheleimage);
        hotnfreshimage = findViewById(R.id.hotnfreshimage);
        kalkanlimage = findViewById(R.id.kalkanlimage);
        komageneimage = findViewById(R.id.komageneimage);
        lavishimage = findViewById(R.id.lavishimage);
        lezzetimage = findViewById(R.id.lezzetimage);
        sedoimage = findViewById(R.id.sedoimage);
        vosvosimage = findViewById(R.id.vosvosimage);
        adaimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ada = new Intent(getApplicationContext(),ada_activity.class);
                startActivity(ada);
            }
        });
        cagimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cag = new Intent(getApplicationContext(),cag_activity.class);
                startActivity(cag);
            }
        });
        donatelloimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donatello = new Intent(getApplicationContext(),donatello_activity.class);
                startActivity(donatello);
            }
        });
        ebimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ebi = new Intent(getApplicationContext(),ebi_activity.class);
                startActivity(ebi);
            }
        });
        gundasimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gundas = new Intent(getApplicationContext(),gundas_activity.class);
                startActivity(gundas);
            }
        });
        heleheleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent heleheleintent= new Intent(getApplicationContext(),activity_helehele.class);
                startActivity(heleheleintent);
            }
        });
        hotnfreshimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotnfresh = new Intent(getApplicationContext(),hotnfresh_activity.class);
                startActivity(hotnfresh);
            }
        });
        kalkanlimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kalkanli = new Intent(getApplicationContext(),kalkanli_activity.class);
                startActivity(kalkanli);
            }
        });
        komageneimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent komagene = new Intent(getApplicationContext(),komagene_activity.class);
                startActivity(komagene);
            }
        });
        lavishimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lavish = new Intent(getApplicationContext(),lavish_activity.class);
                startActivity(lavish);
            }
        });
        lezzetimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lezzet = new Intent(getApplicationContext(),lezzet_activity.class);
                startActivity(lezzet);
            }
        });
        sedoimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sedo = new Intent(getApplicationContext(),sedo_activity.class);
                startActivity(sedo);
            }
        });
        vosvosimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vosvos = new Intent(getApplicationContext(),vosvos_activity.class);
                startActivity(vosvos);
            }
        });


    }
}
