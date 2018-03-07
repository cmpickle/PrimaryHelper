package com.herokuapp.cmpickle.primaryhelper.AddKid;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.herokuapp.cmpickle.primaryhelper.Main.MainActivity;
import com.herokuapp.cmpickle.primaryhelper.R;

/**
 * Created by cmpickle on 2/25/18.
 */

public class AddKidFragment extends Fragment {

    Button submitButton;

    public AddKidFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        submitButton = (Button)view.findViewById(R.id.btn_submit_kid);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_kid, container, false);
    }
}
