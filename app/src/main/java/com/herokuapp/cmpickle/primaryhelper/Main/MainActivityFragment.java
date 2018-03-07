package com.herokuapp.cmpickle.primaryhelper.Main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herokuapp.cmpickle.primaryhelper.Database.Tables.Kid;
import com.herokuapp.cmpickle.primaryhelper.R;
import com.herokuapp.cmpickle.primaryhelper.adapter.KidAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.util.UUID.randomUUID;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements KidAdapter.OnItemClickListener, KidAdapter.OnItemCheckListener {

    @BindView(R.id.recyclerview_kids)
    RecyclerView rvKids;

    ArrayList<Kid> kids = new ArrayList<>();

    public MainActivityFragment() {
        Kid kid = new Kid();
        kid.id = UUID.randomUUID();
        kid.inClass = true;
        kid.firstName = "Andy";
        kid.lastName = "Anderson";
        kid.birthday = new Date(1520386118);
        kid.save();
        kids.add(kid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.Adapter adapter = new KidAdapter(kids, this, this);
        rvKids.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Kid kid) {

    }

    @Override
    public void onItemCheck(Kid kid) {
        kid.inClass = !kid.inClass;
    }
}
