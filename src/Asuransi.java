import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Enum.JenisAsuransi;
import Enum.FrekuensiAsuransi;
import Enum.JenisKelamin;

public class Asuransi {
    private static HashMap<Integer, Prospect> listProspect;
    private static HashMap<String,Nasabah> listCustomer;
    public static HashMap<Integer,Prospect> listProspect() {
        HashMap<Integer, Prospect> listProspect = new HashMap<>();
        return listProspect;
    }

    public static HashMap<Integer, Prospect> getListProspect() {
        return listProspect;
    }

    public static void setListProspect(HashMap<Integer, Prospect> listProspect) {
        Asuransi.listProspect = listProspect;
    }


    public static HashMap<String, Nasabah> getListCustomer() {
        return listCustomer;
    }



    public static void setListCustomer(HashMap<String, Nasabah> listCustomer) {
        Asuransi.listCustomer = listCustomer;
    }

    public static Produk sehatBersamaRemaja(){
        Produk sehatBersamaRemaja = new Produk();
        sehatBersamaRemaja.setNamaProduk("Sehat Bersama");
        sehatBersamaRemaja.setJenisAsuransi(JenisAsuransi.KESEHATAN);
        sehatBersamaRemaja.setFrekuensiAsuransi(FrekuensiAsuransi.BULANAN);
        sehatBersamaRemaja.setIuran(new BigDecimal(200000));
        sehatBersamaRemaja.setManfaat("Claim perawatan kelas 1.");
        sehatBersamaRemaja.setKetentuan("Bisa menanggung keluarga atau diri sendiri dari data nasabah.");
        return sehatBersamaRemaja;
    }
    public static Produk sehatBersamaDewasa(){
        Produk sehatBersamaDewasa = sehatBersamaRemaja();
        sehatBersamaDewasa.setIuran(new BigDecimal(400000));
        return sehatBersamaDewasa;
    }
    public static Produk sehatExtraRemaja(){
        Produk sehatExtraRemaja = new Produk();
        sehatExtraRemaja.setNamaProduk("Sehat Extra");
        sehatExtraRemaja.setJenisAsuransi(JenisAsuransi.KESEHATAN);
        sehatExtraRemaja.setFrekuensiAsuransi(FrekuensiAsuransi.BULANAN);
        sehatExtraRemaja.setIuran(new BigDecimal(300000));
        sehatExtraRemaja.setManfaat("Claim perawatan kelas VIP.");
        sehatExtraRemaja.setKetentuan("Hanya bisa menanggung diri sendiri.");
        return sehatExtraRemaja;
    }
    public static Produk sehatExtraDewasa(){
        Produk sehatExtraDewasa = sehatExtraRemaja();
        sehatExtraDewasa.setIuran(new BigDecimal(500000));
        return sehatExtraDewasa;
    }

    public static Produk lifeKeluargaRemaja(){
        Produk lifeKeluargaRemaja = new Produk();
        lifeKeluargaRemaja.setNamaProduk("Life Keluarga");
        lifeKeluargaRemaja.setJenisAsuransi(JenisAsuransi.JIWA);
        lifeKeluargaRemaja.setFrekuensiAsuransi(FrekuensiAsuransi.BULANAN);
        lifeKeluargaRemaja.setIuran(new BigDecimal(250000));
        lifeKeluargaRemaja.setManfaat("endapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung.");
        lifeKeluargaRemaja.setKetentuan("Bisa menanggung keluarga atau diri sendiri dari data nasabah.");
        return lifeKeluargaRemaja;
    }
    public static Produk lifeKeluargaDewasa(){
        Produk lifeKeluargaDewasa = lifeKeluargaRemaja();
        lifeKeluargaDewasa.setIuran(new BigDecimal(450000));
        return lifeKeluargaDewasa;
    }

    public static Produk lifeSpesialRemaja(){
        Produk lifeKeluargaRemaja = new Produk();
        lifeKeluargaRemaja.setNamaProduk("Life Special");
        lifeKeluargaRemaja.setJenisAsuransi(JenisAsuransi.JIWA);
        lifeKeluargaRemaja.setFrekuensiAsuransi(FrekuensiAsuransi.TAHUNAN);
        lifeKeluargaRemaja.setIuran(new BigDecimal(3600000));
        lifeKeluargaRemaja.setManfaat("Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung.");
        lifeKeluargaRemaja.setKetentuan("Hanya bisa menanggung diri sendiri.");
        return lifeKeluargaRemaja;
    }
    public static Produk lifeSpesialDewasa(){
        Produk lifeKeluargaDewasa = lifeSpesialRemaja();
        lifeKeluargaDewasa.setIuran(new BigDecimal(4800000));
        return lifeKeluargaDewasa;
    }
    public static Produk protection(){
        Produk protection = new Produk();
        protection.setNamaProduk("Protection");
        protection.setJenisAsuransi(JenisAsuransi.KENDARAAN);
        protection.setFrekuensiAsuransi(FrekuensiAsuransi.TAHUNAN);
        protection.setIuran(new BigDecimal(2000000));
        protection.setManfaat("endapat ganti rugi sampai 100.000.000 bila terjadi sesuatu.");
        protection.setKetentuan("Hanya bisa menanggung kendaraan.");
        return protection;
    }
    public static Produk protectionPlus(){
        Produk protectionPlus = new Produk();
        protectionPlus.setNamaProduk("Protection");
        protectionPlus.setJenisAsuransi(JenisAsuransi.KENDARAAN);
        protectionPlus.setFrekuensiAsuransi(FrekuensiAsuransi.TAHUNAN);
        protectionPlus.setIuran(new BigDecimal(2500000));
        protectionPlus.setManfaat("Mendapat ganti rugi total lost bila terjadi sesuatu.");
        protectionPlus.setKetentuan("Hanya bisa menanggung kendaraan.");
        return protectionPlus;
    }
    public static List<Produk> listProduk(){
        List<Produk> produk = new LinkedList<>();
        produk.add(protection());
        produk.add(protectionPlus());
        produk.add(sehatBersamaDewasa());
        produk.add(sehatBersamaRemaja());
        produk.add(sehatExtraDewasa());
        produk.add(sehatExtraRemaja());
        produk.add(lifeKeluargaDewasa());
        produk.add(lifeKeluargaRemaja());
        produk.add(lifeSpesialRemaja());
        produk.add(lifeSpesialDewasa());
        return produk;
    }

}
