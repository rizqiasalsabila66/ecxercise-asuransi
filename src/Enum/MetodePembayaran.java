package Enum;

public enum MetodePembayaran {
    CC ("Credit Card"),
    AC ("Auto Collection"),
    VP ("Virtual Payment");

    private String deskripsi;

    MetodePembayaran(String isi)//konstractor enum
    {
        this.deskripsi=isi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
