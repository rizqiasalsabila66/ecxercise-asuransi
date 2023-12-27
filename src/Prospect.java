import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import Enum.JenisKelamin;

public class Prospect extends Orang {
    private int nomorProspect;
    private boolean isNasabah;
    private String pekerjaan;


    public int getNomorProspect() {
        return nomorProspect;
    }

    public void setNomorProspect(int nomorProspect) {
        this.nomorProspect = nomorProspect;
    }

    public boolean isNasabah() {
        return isNasabah;
    }

    public void setNasabah(boolean nasabah) {
        isNasabah = nasabah;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public void cetakInfoPrspect(){
        Locale Indonesia = new Locale("id", "ID");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", Indonesia);
        String nasabah = "";
            if(isNasabah()){
                nasabah = "Nasabah";
            }
            else {
                nasabah = "Prospect";
            }
            System.out.println(String.format("No: %d,%s %s,%s, %s (%s), %s, %s",
                    getNomorProspect(),getNamaDepan(),getNamaBelakang(),
                    getJenisKelamin().getDeskripsi(),formatTanggal.format(getTanggalLahir()),
                    getKotaLahir(), getPekerjaan(),nasabah));
        }

}
