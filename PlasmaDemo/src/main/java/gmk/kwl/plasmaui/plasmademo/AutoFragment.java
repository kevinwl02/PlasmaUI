package gmk.kwl.plasmaui.plasmademo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gmk.kwl.plasmaui.view.PlasmaView;


public class AutoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auto, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupReplay();

        PlasmaView animationView = (PlasmaView)getActivity().findViewById(R.id.auto_animation_view_group);
        animationView.startAnimations(true);
    }

    private void setupReplay() {

        Button replayButton = (Button)getActivity().findViewById(R.id.replay_button);
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlasmaView animationView = (PlasmaView)getActivity().findViewById(R.id.auto_animation_view_group);
                animationView.startAnimations(true);
            }
        });
    }
}
