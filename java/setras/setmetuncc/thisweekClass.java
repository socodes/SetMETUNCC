package setras.setmetuncc;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class thisweekClass extends ArrayAdapter<String> {
    private final ArrayList<String> tipText;
    private final ArrayList<String> isimText;
    private final ArrayList<String> yerText;
    private final ArrayList<String> zamanText;
    private final ArrayList<String> kimText;
    private final Activity context;

    public thisweekClass(ArrayList<String> tipText, ArrayList<String> isimText, ArrayList<String> yerzamanText, ArrayList<String> zamanText, ArrayList<String> kimText, Activity context) {
        super(context,R.layout.thisweek_view,isimText);
        this.tipText = tipText;
        this.isimText = isimText;
        this.yerText = yerzamanText;
        this.zamanText = zamanText;
        this.kimText = kimText;

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =context.getLayoutInflater();
        View thisweekview = layoutInflater.inflate(R.layout.thisweek_view,null,true);
        TextView tip = thisweekview.findViewById(R.id.tipthisweek);
        TextView isim = thisweekview.findViewById(R.id.isimthisweek);
        TextView yer = thisweekview.findViewById(R.id.yerthisweek);
        TextView kim = thisweekview.findViewById(R.id.kimthisweek);
        TextView zaman = thisweekview.findViewById(R.id.zamanthisweek);
        tip.setText(tipText.get(position));
        isim.setText(isimText.get(position));
        yer.setText(yerText.get(position));
        zaman.setText(zamanText.get(position));
        kim.setText(kimText.get(position));


        return thisweekview;
    }
}
