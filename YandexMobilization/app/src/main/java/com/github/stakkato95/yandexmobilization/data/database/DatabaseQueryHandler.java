package com.github.stakkato95.yandexmobilization.data.database;

import com.github.stakkato95.yandexmobilization.data.model.Artist;
import com.github.stakkato95.yandexmobilization.event.SyncFailedEvent;
import com.raizlabs.android.dbflow.runtime.DBTransactionInfo;
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.BaseTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.TransactionListener;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelTransaction;
import com.raizlabs.android.dbflow.sql.language.Select;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
public final class DatabaseQueryHandler {

    public static void saveArtists(final List<Artist> artists) {
        ProcessModelInfo<Artist> processModelInfo = ProcessModelInfo.
                withModels(artists)
                .info(DBTransactionInfo.createSave())
                .result(new TransactionListener<List<Artist>>() {
                    @Override
                    public void onResultReceived(List<Artist> result) {
                        EventBus.getDefault().post(SyncFailedEvent.INSTANCE);
                    }

                    @Override
                    public boolean onReady(BaseTransaction<List<Artist>> transaction) {
                        return true;
                    }

                    @Override
                    public boolean hasResult(BaseTransaction<List<Artist>> transaction, List<Artist> result) {
                        return true;
                    }
                });

        ProcessModelTransaction<Artist> transaction = new ProcessModelTransaction<Artist>(processModelInfo, null) {
            @Override
            public void processModel(Artist model) {
                model.save();
            }
        };

        TransactionManager.getInstance().addTransaction(transaction);
    }

    public static List<Artist> getArtists() {
        return new Select().from(Artist.class).queryList();
    }
}
