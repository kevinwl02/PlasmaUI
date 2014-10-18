package gmk.kwl.plasmaui.plasmademo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gmk.kwl.plasmaui.view.PlasmaView;

/**
 * Created by Kevin Wong on 18/10/14.
 */
public class DynamicListViewAdapter extends ArrayAdapter<String> {

    public DynamicListViewAdapter(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String text = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dynamic_list_cell, parent, false);
        }

        TextView titleTextView = (TextView)convertView.findViewById(R.id.title_text_view);
        PlasmaView animationView = (PlasmaView)convertView.findViewById(R.id.animation_view);

        titleTextView.setText(text);
        animationView.startAnimations(true);

        return convertView;
    }
}
