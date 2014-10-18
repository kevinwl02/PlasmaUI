package gmk.kwl.plasmaui.plasmademo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class DynamicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupListView();
    }

    private void setupListView() {

        //Test data
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("Good");
        testData.add("Amazing");
        testData.add("Incredible");
        testData.add("Nice");
        testData.add("Awesome");
        testData.add("Fantastic");
        testData.add("Unreal");
        testData.add("Excellent");
        testData.add("Super");
        testData.add("Godlike");
        testData.add("Pro");
        testData.add("Perfect");
        testData.add("Cool");
        testData.add("Great");

        ListView listView = (ListView)getActivity().findViewById(R.id.list_view);
        DynamicListViewAdapter adapter = new DynamicListViewAdapter(getActivity(), testData);
        listView.setAdapter(adapter);
    }
}
