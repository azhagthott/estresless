package com.zecovery.android.estresless.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.zecovery.android.estresless.R;
import com.zecovery.android.estresless.models.Pending;

public class DetailActivity extends AppCompatActivity {

    private EditText descriptionEt;
    private Pending pending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        long id = getIntent().getLongExtra("id", 0);
        pending = Pending.findById(Pending.class, id);

        descriptionEt = (EditText) findViewById(R.id.descriptionEt);
        pending = (Pending) getIntent().getSerializableExtra("pending");
        getSupportActionBar().setTitle(pending.getName());

    }

    @Override
    protected void onResume() {
        super.onResume();
        String description = pending.getDescription();
        if (description != null) {
            descriptionEt.setText(description);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        String description = descriptionEt.getText().toString();
        pending.setDescription(description);
        pending.save();
    }
}
