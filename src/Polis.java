import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import Enum.FrekuensiAsuransi;
import Enum.JenisAsuransi;

public class Polis {
    private Nasabah pemilikPolis;
    private Nasabah customerTertanggung;
    private Kendaraan kendaraanTertanggung;
    private Produk produk;
    private LocalDate tanggalMulaiPolis;

    public Nasabah getPemilikPolis() {
        return pemilikPolis;
    }

    public void setPemilikPolis(Nasabah pemilikPolis) {
        this.pemilikPolis = pemilikPolis;
    }

    public Nasabah getCustomerTertanggung() {
        return customerTertanggung;
    }

    public void setCustomerTertanggung(Nasabah customerTertanggung) {
        this.customerTertanggung = customerTertanggung;
    }

    public Kendaraan getKendaraanTertanggung() {
        return kendaraanTertanggung;
    }

    public void setKendaraanTertanggung(Kendaraan kendaraanTertanggung) {
        this.kendaraanTertanggung = kendaraanTertanggung;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public LocalDate getTanggalMulaiPolis() {
        return tanggalMulaiPolis;
    }

    public void setTanggalMulaiPolis(LocalDate tanggalMulaiPolis) {
        this.tanggalMulaiPolis = tanggalMulaiPolis;
    }

    public void cetakInfoPolis(){
        if(getProduk().getJenisAsuransi().equals(JenisAsuransi.JIWA)||
                getProduk().getJenisAsuransi().equals(JenisAsuransi.KESEHATAN)){
            cetakPolisInfoCustomer();
            cetakPayment();
        }
        else if(getProduk().getJenisAsuransi().equals(JenisAsuransi.KENDARAAN)){
            cetakPolisInfoKendaraan();
            cetakPayment();
        }
    }
    public void cetakPolisInfoCustomer(){
        Locale Indonesia = new Locale("id", "ID");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", Indonesia);

        System.out.println("Tertanggung: "+this.getCustomerTertanggung().getProspect().getNamaDepan()+" "+
                getCustomerTertanggung().getProspect().getNamaBelakang());
        System.out.println("Product: "+getProduk().getNamaProduk());
        System.out.println("Tanggal Mulai Dijalankan: "+ formatTanggal.format(getTanggalMulaiPolis()));
        System.out.println("Manfaat: "+getProduk().getManfaat());
        System.out.println("=============================================");
    }

    public  void cetakPayment(){
        Locale Indonesia = new Locale("id", "ID");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", Indonesia);
        String rupiah = NumberFormat.getCurrencyInstance(Indonesia).format(getProduk().getIuran());
        int i ;
        if (getProduk().getFrekuensiAsuransi().equals(FrekuensiAsuransi.BULANAN)) {
            for (i = 0; i < 3; i++) {
                System.out.println(formatTanggal.format(getTanggalMulaiPolis().plusMonths(i)) + ", " + rupiah);
            }
        }
        else if(getProduk().getFrekuensiAsuransi().equals(FrekuensiAsuransi.TAHUNAN)){
            for (i=0; i<3;i++){
                System.out.println(formatTanggal.format(getTanggalMulaiPolis().plusYears(i))+", "+rupiah);
            }
        }
        System.out.println("=====================================================");
    }

    public void cetakPolisInfoKendaraan(){
        Locale Indonesia = new Locale("id", "ID");
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", Indonesia);

        System.out.println("Product: "+getProduk().getJenisAsuransi());
        System.out.println("Tanggal Mulai Dijalankan: "+formatTanggal.format(getTanggalMulaiPolis()));
        getKendaraanTertanggung().cetakInfoKendaraan();
        System.out.println("=============================================");
    }
}
