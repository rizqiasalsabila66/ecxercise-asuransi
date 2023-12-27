import Enum.MetodePembayaran;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Nasabah {

    private Prospect prospect;
    private String nomorNasabah;
    private String statusKeluarga;
    private MetodePembayaran MetodePembayaran;
    private LocalDate tanggalMenjadiNasabah;
    private List<Polis> listPolis;
    private List<Nasabah> anggotaKeluarga;
    private List<Kendaraan> kendaraan;
    private String nomorKTP;

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public LocalDate getTanggalMenjadiNasabah() {
        return tanggalMenjadiNasabah;
    }

    public void setTanggalMenjadiNasabah(LocalDate tanggalMenjadiNasabah) {
        this.tanggalMenjadiNasabah = tanggalMenjadiNasabah;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public String getNomorNasabah() {
        return nomorNasabah;
    }

    public void setNomorNasabah(String nomorNasabah) {
        this.nomorNasabah = nomorNasabah;
    }

    public String getStatusKeluarga() {
        return statusKeluarga;
    }

    public void setStatusKeluarga(String statusKeluarga) {
        this.statusKeluarga = statusKeluarga;
    }

    public MetodePembayaran getMetodePembayaran() {
        return MetodePembayaran;
    }

    public void setMetodePembayaran(MetodePembayaran metodePembayaran) {
        MetodePembayaran = metodePembayaran;
    }


    public List<Polis> getListPolis() {
        return listPolis;
    }

    public void setListPolis(List<Polis> listPolist) {
        this.listPolis = listPolist;
    }

    public List<Nasabah> getAnggotaKeluarga() {
        return anggotaKeluarga;
    }

    public void setAnggotaKeluarga(List<Nasabah> anggotaKeluarga) {
        this.anggotaKeluarga = anggotaKeluarga;
    }

    public List<Kendaraan> getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(List<Kendaraan> kendaraan) {
        this.kendaraan = kendaraan;
    }

    public void cetakInfoCustomer(){
        Locale Indonesia = new Locale("id", "ID");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", Indonesia);
        System.out.println(String.format("No: %s,%s %s, %s, %s (%s),%s\nKTP: %s, Status di KK %s, Payment Method: %s",
                getProspect().getNomorProspect(),getProspect().getNamaDepan(),
                getProspect().getNamaBelakang(),
                getProspect().getJenisKelamin().getDeskripsi(),
                formatTanggal.format(getProspect().getTanggalLahir()),
                getProspect().getKotaLahir(), getProspect().getPekerjaan(),
                getProspect(),getNomorKTP(),getStatusKeluarga(),
                getMetodePembayaran().getDeskripsi()));
        System.out.println("====================================");
    }
}
