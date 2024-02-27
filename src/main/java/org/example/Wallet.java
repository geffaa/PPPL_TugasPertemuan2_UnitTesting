package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Wallet {
    String owner ;
    ArrayList<String> listKartu;
    ArrayList<Integer> listUangKoin;
    ArrayList<Integer> listUangLembaran;

    public Wallet (String owner){
        this.owner = owner;
        listKartu = new ArrayList<>();
        listUangLembaran = new ArrayList<>();
        listUangKoin = new ArrayList<>();
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public void tambahKartu(String namaKartu){
        this.listKartu.add(namaKartu);
    }

    public String ambilKartu(String namaKartu){
        boolean isDeleted = this.listKartu.remove(namaKartu);
        if (isDeleted){
            return namaKartu;
        }
        return null;
    }

    public void tambahUangRupiah (Integer jumlahUang){
        if (jumlahUang < 0){
            throw new Error("Jumlah uang tidak boleh minus");
        }
        if (jumlahUang > 1000){
            listUangLembaran.add(jumlahUang);
        }
        else {
            listUangKoin.add(jumlahUang);
        }
    }

    public int ambilUang(int jumlahUang){
        boolean isAmbilUangLembarang = this.listUangLembaran.remove(
                Integer.valueOf(jumlahUang));
        if (isAmbilUangLembarang){
            return jumlahUang;
        }

        boolean isAmbilUangKoin = this.listUangKoin.remove(
                Integer.valueOf(jumlahUang));
        if (isAmbilUangKoin){
            return jumlahUang;
        }

        return 0;
    }

    public int tampilkanUang(){
        int totalUang = 0;
        for (Integer uang : listUangKoin){
            totalUang += uang;
        }
        for (Integer uang : listUangLembaran){
            totalUang += uang;
        }
        return totalUang;
    }

    public String getOwner() {
        return this.owner;
    }

    public List<String> getListKartu() {
        return new ArrayList<>(this.listKartu);
    }

    public List<Integer> getListUangLembaran() {
        return new ArrayList<>(this.listUangLembaran);
    }

    public List<Integer> getListUangKoin() {
        return new ArrayList<>(this.listUangKoin);
    }

}