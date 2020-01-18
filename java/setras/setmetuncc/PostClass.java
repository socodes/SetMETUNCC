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

public class PostClass extends ArrayAdapter<String> {
    private final ArrayList<String> altmenu;
    private final ArrayList<String> urun;
    private final ArrayList<String> aciklama;
    private final ArrayList<String> fiyat;
    private final Activity context;

    public PostClass(ArrayList<String> altmenu, ArrayList<String> urun, ArrayList<String> aciklama, ArrayList<String> fiyat, Activity context) {
        super(context,R.layout.custom_view,urun);
        this.altmenu=altmenu;
        this.urun = urun;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);
        TextView altmenuText = customView.findViewById(R.id.altmenuTextViewCustomView);
        TextView urunText = customView.findViewById(R.id.urunTextViewCustomView);
        TextView aciklamaText = customView.findViewById(R.id.aciklamaTextViewCustomView);
        TextView fiyatText = customView.findViewById(R.id.fiyatTExtViewCustomView);
        altmenuText.setText(altmenu.get(position));
        urunText.setText(urun.get(position));
        aciklamaText.setText(aciklama.get(position));
        fiyatText.setText(fiyat.get(position));
        return customView;
    }
}
