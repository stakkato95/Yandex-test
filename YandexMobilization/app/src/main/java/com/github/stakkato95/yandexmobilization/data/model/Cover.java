package com.github.stakkato95.yandexmobilization.data.model;

import com.github.stakkato95.yandexmobilization.data.database.MobilizationDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ManyToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
@Table(database = MobilizationDatabase.class)
public class Cover extends BaseModel {

    @PrimaryKey
    public int id;

    @SerializedName("small")
    @Column
    public String small;

    @SerializedName("big")
    @Column
    public String big;
}
