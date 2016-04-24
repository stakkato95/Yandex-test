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
//@ManyToMany(referencedTable = Artist.class)
public class Genre extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public String name;

//
//    @SerializedName("pop")
//    POP,
//
//    @SerializedName("dance")
//    DANCE,
//
//    @SerializedName("electronics")
//    ELECTRONICS,
//
//    @SerializedName("rnb")
//    RNB,
//
//    @SerializedName("rap")
//    RAP,
//
//    @SerializedName("rusrap")
//    RUS_RAP,
//
//    @SerializedName("rusrock")
//    RUS_ROCK,
//
//    @SerializedName("rusfolk")
//    RUS_FOLK,
//
//    @SerializedName("soul")
//    SOUL,
//
//    @SerializedName("alternative")
//    ALTERNATIVE,
//
//    @SerializedName("country")
//    COUNTRY,
//
//    @SerializedName("urban")
//    URBAN,
//
//    @SerializedName("local-indie")
//    LOCAL_INDIE,
//
//    @SerializedName("classical")
//    CLASSICAL,
//
//    @SerializedName("folk")
//    FOLK,
//
//    @SerializedName("rock")
//    ROCK,
//
//    @SerializedName("relax")
//    RELAX,
//
//    @SerializedName("jazz")
//    JAZZ,
//
//    @SerializedName("conjazz")
//    CON_JAZZ,
//
//    @SerializedName("blues")
//    BLUES,
//
//    @SerializedName("soundtrack")
//    SOUNDTRACK,
//
//    @SerializedName("latinfolk")
//    LATINFOLK,
//
//    @SerializedName("estrada")
//    ESTRADA,
//
//    @SerializedName("bard")
//    BARD,
//
//    @SerializedName("punk")
//    PUNK,
//
//    @SerializedName("african")
//    AFRICAN,
//
//    @SerializedName("house")
//    HOUSE,
//
//    @SerializedName("lounge")
//    LOUNGE,
//
//    @SerializedName("trance")
//    TRANCE,
//
//    @SerializedName("disco")
//    DISCO,
//
//    @SerializedName("metal")
//    METAL,
//
//    @SerializedName("prog")
//    PROG,
//
//    @SerializedName("videogame")
//    VIDEOGAME,
//
//    @SerializedName("reggae")
//    REGGAE,
//
//    @SerializedName("industrial")
//    INDUSTRIAL
}
