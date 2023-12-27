package Enum;

public enum JenisAsuransi {
    KESEHATAN ("Kesehatan"),
    JIWA ("Jiwa"),
    KENDARAAN("Kendaraan");

    private String deskripsi;

    JenisAsuransi(String isi)//konstractor enum
    {
        this.deskripsi=isi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
