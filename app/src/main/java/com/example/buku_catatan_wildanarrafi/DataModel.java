package com.example.buku_catatan_wildanarrafi;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataModel implements Parcelable {
    private String nama;
    private String deskripsi;

    public DataModel() {

    }

    protected DataModel(Parcel in) {
        nama = in.readString();
        deskripsi = in.readString();
    }

    public static final Creator<DataModel> CREATOR = new Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel in) {
            return new DataModel(in);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public DataModel(String nama, String deskripsi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(deskripsi);
    }
}
