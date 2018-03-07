package com.herokuapp.cmpickle.primaryhelper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.herokuapp.cmpickle.primaryhelper.Database.Tables.Kid;
import com.herokuapp.cmpickle.primaryhelper.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cmpic on 3/6/2018.
 */

public class KidAdapter extends RecyclerView.Adapter<KidAdapter.KidHolder> {

    private final ArrayList<Kid> kids;
    private final OnItemClickListener onItemClickListener;
    private final OnItemCheckListener onItemCheckListener;

    public interface OnItemClickListener {
        void onItemClick(Kid kid);
    }

    public interface OnItemCheckListener {
        void onItemCheck(Kid kid);
    }

    public KidAdapter(ArrayList<Kid> kids, OnItemClickListener onItemClickListener, OnItemCheckListener onItemCheckListener) {
        this.kids = kids;
        this.onItemClickListener = onItemClickListener;
        this.onItemCheckListener = onItemCheckListener;
    }

    public static class KidHolder extends RecyclerView.ViewHolder {
        View view;
        @BindView(R.id.checkbox_kid_item)
        CheckBox checkBoxActive;
        @BindView(R.id.textview_firstname_kid_item)
        TextView tvFirstname;
        @BindView(R.id.textview_lastname_kid_item)
        TextView tvLastName;
        @BindView(R.id.textview_birthday_kid_item)
        TextView tvBirthday;

        public KidHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        public void bindKid(Kid kid, OnItemClickListener onItemClickListener, OnItemCheckListener onItemCheckListener) {
            checkBoxActive.setChecked(kid.inClass);
            tvFirstname.setText(kid.firstName);
            tvLastName.setText(kid.lastName);
            SimpleDateFormat format = new SimpleDateFormat("m/d");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
            calendar.set(Calendar.MONTH, kid.birthday.getMonth());
            calendar.set(Calendar.YEAR, kid.birthday.getYear());
            String formattedDate = format.format(calendar.getTime());
            tvBirthday.setText(formattedDate);
        }
    }

    @Override
    public KidAdapter.KidHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kid, parent, false);
        return new KidHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(KidAdapter.KidHolder holder, int position) {
        Kid kid = kids.get(position);
        holder.bindKid(kid, onItemClickListener, onItemCheckListener);
    }

    @Override
    public int getItemCount() {
        return kids.size();
    }
}
