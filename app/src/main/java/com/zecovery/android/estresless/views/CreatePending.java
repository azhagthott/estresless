package com.zecovery.android.estresless.views;

import com.zecovery.android.estresless.models.Pending;

public class CreatePending {


    private PendingCallback callback;

    public CreatePending(PendingCallback callback) {
        this.callback = callback;
    }

    public void validation(String name) {
        if (name.trim().length() > 0) {
            Pending pending = new Pending();
            pending.setName(name);
            pending.setDone(false);
            pending.save();
            callback.created(pending);
        } else {
            callback.noName();
        }

    }
}
