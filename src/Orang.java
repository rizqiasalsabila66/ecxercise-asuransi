import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import Enum.JenisKelamin;

public class Orang {
    private String namaDepan;
    private String namaBelakang;
    private String kotaLahir;
    private LocalDate tanggalLahir;
    private JenisKelamin jenisKelamin;


    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }



    public String getKotaLahir() {
        return kotaLahir;
    }

    public void setKotaLahir(String kotaLahir) {
        this.kotaLahir = kotaLahir;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public long hitungUmur(){
        long umur = ChronoUnit.YEARS.between(tanggalLahir,LocalDate.now());
        return umur;
    }
}
