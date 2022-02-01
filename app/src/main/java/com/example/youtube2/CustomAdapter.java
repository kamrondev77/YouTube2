package com.example.youtube2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (members.get(position).isAvailable()) {return TYPE_AVAILABLE_YES;}
        return TYPE_AVAILABLE_NOT;
    }

    @Override
    public int getItemCount() {return members.size();}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == TYPE_AVAILABLE_YES) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_yes, viewGroup, false);
            return new CustomViewYesHolder(view);
        }

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_not, viewGroup, false);
        return new CustomViewNoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);


        if (holder instanceof CustomViewYesHolder) {
            TextView first_name = ((CustomViewYesHolder) holder).first_name;
            TextView last_name = ((CustomViewYesHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());
        }

        if (holder instanceof CustomViewNoHolder) {
            TextView first_name = ((CustomViewNoHolder) holder).first_name;
            TextView last_name = ((CustomViewNoHolder) holder).last_name;

            first_name.setText("This firstname is not available");
            last_name.setText("This lastname is not available");
        }
    }


    public class CustomViewYesHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name, last_name;

        public CustomViewYesHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }

    public class CustomViewNoHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name, last_name;

        public CustomViewNoHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
