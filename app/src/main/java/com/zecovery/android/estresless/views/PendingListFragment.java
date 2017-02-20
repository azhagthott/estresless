package com.zecovery.android.estresless.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zecovery.android.estresless.R;
import com.zecovery.android.estresless.adapters.PendingClickListener;
import com.zecovery.android.estresless.adapters.PendingsAdapter;
import com.zecovery.android.estresless.models.Pending;

public class PendingListFragment extends Fragment implements PendingClickListener {

    private PendingsAdapter adapter;

    public PendingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pending_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pendingsRv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PendingsAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void addPending(Pending pending) {
        adapter.addPending(pending);
    }

    @Override
    public void clickedId(long id) {

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);

    }

    @Override
    public void pending(Pending pending) {

    }
}