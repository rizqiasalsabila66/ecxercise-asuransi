import Enum.JenisAsuransi;
import  Enum.FrekuensiAsuransi;

import java.math.BigDecimal;


public class Produk
{
    private String namaProduk;
    private JenisAsuransi jenisAsuransi;
    private FrekuensiAsuransi frekuensiAsuransi;
    private BigDecimal iuran;
    private String manfaat;
    private String ketentuan;

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public JenisAsuransi getJenisAsuransi() {
        return jenisAsuransi;
    }

    public void setJenisAsuransi(JenisAsuransi jenisAsuransi) {
        this.jenisAsuransi = jenisAsuransi;
    }

    public FrekuensiAsuransi getFrekuensiAsuransi() {
        return frekuensiAsuransi;
    }

    public void setFrekuensiAsuransi(FrekuensiAsuransi frekuensiAsuransi) {
        this.frekuensiAsuransi = frekuensiAsuransi;
    }

    public BigDecimal getIuran() {
        return iuran;
    }

    public void setIuran(BigDecimal iuran) {
        this.iuran = iuran;
    }

    public String getManfaat() {
        return manfaat;
    }

    public void setManfaat(String manfaat) {
        this.manfaat = manfaat;
    }

    public String getKetentuan() {
        return ketentuan;
    }

    public void setKetentuan(String ketentuan) {
        this.ketentuan = ketentuan;
    }
}
