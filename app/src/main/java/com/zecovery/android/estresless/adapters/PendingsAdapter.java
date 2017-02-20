package com.zecovery.android.estresless.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.zecovery.android.estresless.R;
import com.zecovery.android.estresless.data.Queries;
import com.zecovery.android.estresless.models.Pending;

import java.util.List;

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.ViewHolder> implements PendingClickListener {

    PendingClickListener listener;

    private List<Pending> pendings = new Queries().notDone();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pendings, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        holder.textView.setText(pending.getName());
        holder.checkBox.setChecked(pending.isDone());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    final int adapterPosition = holder.getAdapterPosition();
                    Pending auxPendig = pendings.get((adapterPosition));
                    auxPendig.setDone(true);
                    auxPendig.save();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pendings.remove(adapterPosition);
                            notifyItemRemoved(adapterPosition);
                        }
                    }, 200);

                }
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }

    public void addPending(Pending pending) {
        pendings.add(pending);
        notifyDataSetChanged();
    }

    @Override
    public void clickedId(long id) {

    }

    @Override
    public void pending(Pending pending) {

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBox;
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}