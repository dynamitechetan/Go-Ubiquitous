package com.example.android.sunshine.app.sync;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.WearableListenerService;

public class SunshineWatchFaceListener extends WearableListenerService {
    private static final String LOG_TAG = SunshineWatchFaceListener.class.getSimpleName();
    public static final String UPDATE_WATCHFACE_PATH = "/update_watchface";

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        for(DataEvent dataEvent: dataEventBuffer){
            if(dataEvent.getType() == DataEvent.TYPE_CHANGED){
                String path = dataEvent.getDataItem().getUri().getPath();
                if(path.equals(UPDATE_WATCHFACE_PATH)){
                    SunshineSyncAdapter.syncImmediately(this);
                }
            }
        }
    }
}
