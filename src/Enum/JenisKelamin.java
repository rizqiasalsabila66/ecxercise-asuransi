package Enum;

public enum JenisKelamin {
    P ("Perempuan"),
    L ("Laki-laki");

    private String deskripsi;

    JenisKelamin(String isi)//konstractor enum
    {
        this.deskripsi=isi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
