package setras.setmetuncc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_phonebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);
        ListView phoneList = findViewById(R.id.phoneList);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Campus Health Center: 1920");
        list.add("Campus Officer on Call: 2122");
        list.add("Campus Security: 1958");
        list.add("Campus Technical Service: 1986");
        list.add("TRNC Ambulance Service: 112");
        list.add("TRNC Fire Brigade: 199");
        list.add("TRNC Forest Fire: 177");
        list.add("TRNC Police: 155");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);

        phoneList.setAdapter(arrayAdapter);
    }
}
