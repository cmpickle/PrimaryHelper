package com.herokuapp.cmpickle.primaryhelper.AddKid;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.herokuapp.cmpickle.primaryhelper.Database.Tables.Kid;
import com.herokuapp.cmpickle.primaryhelper.Main.MainActivity;
import com.herokuapp.cmpickle.primaryhelper.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cmpickle on 2/25/18.
 */

public class AddKidFragment extends Fragment {

    @BindView(R.id.et_kid_firstname)
    EditText etFirstName;
    @BindView(R.id.et_kid_lastname)
    EditText etLastName;
    @BindView(R.id.et_kid_birthday)
    EditText etBirthday;
    @BindView(R.id.btn_submit_kid)
    Button submitButton;

    Date birthday;

    public AddKidFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        submitButton = (Button)view.findViewById(R.id.btn_submit_kid);
        etBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        birthday = new GregorianCalendar(i, i1, i2).getTime();
                        etBirthday.setText(String.format("%d/%d/%d", i1, i2, i));
                    }
                };
                DatePickerDialog datePicker = new DatePickerDialog(view.getContext(), dateSetListener, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR));
                datePicker.show();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kid kid = new Kid();
                kid.id = UUID.randomUUID();
                kid.inClass = true;
                kid.firstName = etFirstName.getText().toString();
                kid.lastName = etLastName.getText().toString();
                kid.birthday = birthday;
                kid.save();
                view.getContext().startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_kid, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
