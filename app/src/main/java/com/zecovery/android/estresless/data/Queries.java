package com.zecovery.android.estresless.data;

import com.zecovery.android.estresless.models.Pending;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public List<Pending> notDone() {

        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingsList = Pending.find(Pending.class, "doneOther=0");

        if (pendingsList != null && pendingsList.size() > 0) {
            pendings.addAll(pendingsList);
        }
        return pendings;
    }
}
