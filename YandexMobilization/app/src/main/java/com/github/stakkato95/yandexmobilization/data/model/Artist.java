package com.github.stakkato95.yandexmobilization.data.model;

import com.github.stakkato95.yandexmobilization.data.database.MobilizationDatabase;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyAction;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.ManyToMany;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.security.PublicKey;
import java.util.List;

import retrofit2.http.PUT;

/**
 * Created by artsiomkaliaha on 24/04/16.
 */
@Table(database = MobilizationDatabase.class)
//@ManyToMany(referencedTable = Genre.class)
public class Artist extends BaseModel {

    @SerializedName("id")
    @PrimaryKey
    @Column
    public int id;

    @SerializedName("name")
    @Column
    public String name;

    @SerializedName("genres")
    public List<Genre> genres;

    @SerializedName("tracks")
    @Column
    public int tracks;

    @SerializedName("albums")
    @Column
    public int albums;

    @SerializedName("description")
    @Column
    public String description;

    @SerializedName("cover")
    @ForeignKey(
            references = {@ForeignKeyReference(columnName = "cover_id",
                    columnType = Integer.class,
                    foreignKeyColumnName = "id")})
    public Cover cover;
}
