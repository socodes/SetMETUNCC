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

public class NavClass extends ArrayAdapter<String> {
    private final ArrayList<String> departureText;
    private final ArrayList<String> companyText;
    private final ArrayList<String> telephoneText;
    private final Activity context;

    public NavClass(ArrayList<String> departureText, ArrayList<String> companyText, ArrayList<String> telephoneText, Activity context) {
        super(context,R.layout.navigation,departureText);
        this.departureText = departureText;
        this.companyText = companyText;
        this.telephoneText = telephoneText;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =context.getLayoutInflater();
        View navView = layoutInflater.inflate(R.layout.navigation,null,true);
        TextView departure = navView.findViewById(R.id.departureNavigation);
        TextView company = navView.findViewById(R.id.companyNavigation);
        TextView telephone = navView.findViewById(R.id.telephoneNavigation);

        departure.setText(departureText.get(position));
        company.setText(companyText.get(position));
        telephone.setText(telephoneText.get(position));


        return navView;
    }
}
