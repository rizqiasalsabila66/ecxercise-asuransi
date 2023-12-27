import java.beans.Customizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Enum.*;

public class Menu {
    public static void menuUtama(HashMap<Integer,Prospect> listProspect,HashMap<String, Nasabah> listCustomer){
        try{
            System.out.println("Pilihlah salah satu menu di bawah ini:");
            System.out.println("1. Menu Prospect\n2. Menu Customer\n3. Exit Application");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    menuProspect(listProspect,listCustomer);
                    break;
                case 2:
                    menuCustomer(listProspect,listCustomer);
                    break;
                case 3:
                    System.out.println("Terimakasih telah menggunakan aplikasi kami");
                    break;
                default:
                    System.out.println("Inputan salah, Pilih 1-3!");
                    menuUtama(listProspect,listCustomer);
            }
        }catch (Exception e){
            System.out.println("Inputan salah,Pilih 1-3!");
            System.out.println(e.getMessage());
            menuUtama(listProspect,listCustomer);
        }
    }

    public static void menuProspect(HashMap<Integer,Prospect>listProspect,HashMap<String, Nasabah> listCustomer){
        if(listProspect.size()==0){
            System.out.println("Belum ada data");
        }else {
            for(Prospect prospect : listProspect.values()){
                prospect.cetakInfoPrspect();
            }
        }
        try{
            System.out.println("Pilihlah salah satu menu di bawah ini:");
            System.out.println("1. Add Prospect\n2. Prospect To Customer\n3. Main Menu\n4. Exit Application");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    tambahProspect(listProspect,listCustomer);
                    break;
                case 2:
                    prospectKeCustomer(listProspect,listCustomer);
                    break;
                case 3:
                    menuUtama(listProspect,listCustomer);
                    break;
                case 4:
                    System.out.println("Terimakasih telah menggunakan aplikasi kami");
                    break;
                default:
                    System.out.println("Inputan salah, Pilih 1-4!");
                    menuProspect(listProspect,listCustomer);
            }
        }catch (Exception e){
            System.out.println("Inputan salah,Pilih 1-4!");
            System.out.println(e.getMessage());
           menuProspect(listProspect,listCustomer);
        }
    }

    public static void menuCustomer(HashMap<Integer,Prospect>listProspect,HashMap<String, Nasabah> listCustomer) {
            if(listCustomer==null){
                System.out.println("Belum ada data");
            }else {
                semuaDataCustomer();
            }
        try{
            System.out.println("Pilih Menu yang ingin dipilih");
            System.out.println("1. Buy Product\n2.  Detail Policy\n3. Main Menu\n4. Exit Application");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    beliProduct(listProspect,listCustomer);
                    break;
                case 2:
                    detailPolicy();
                    break;
                case 3:
                    menuUtama(listProspect,listCustomer);
                    break;
                case 4:
                    System.out.println("Terimakasih telah menggunakan aplikasi kami");
                    break;
                default:
                    System.out.println("Inputan salah, Pilih 1-4!");
                   menuCustomer(listProspect,listCustomer);
            }
        } catch (Exception e) {
            System.out.println("Inputan salah,Pilih 1-4!");
            System.out.println(e.getMessage());
            menuCustomer(listProspect,listCustomer);
        }
    }

    public static void semuaDataProspect(HashMap<Integer,Prospect>listProspect){
        for(Prospect prospect : listProspect.values()){
            prospect.cetakInfoPrspect();
        }
    }

    public static void semuaDataCustomer(){
        for(Nasabah customer : Asuransi.getListCustomer().values()){
            customer.cetakInfoCustomer();
        }

    }

    public static void tambahProspect(HashMap<Integer,Prospect> listProspect,HashMap<String, Nasabah> listCustomer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nama Depan");
        String namaDepan = scanner.nextLine();
        System.out.println("Nama Belakang");
        String namaBelakang = scanner.nextLine();
        System.out.print("Tanggal lahir(dd/MM/yyyy):");
        String tanggalLahir = scanner.nextLine();
        System.out.println("Tempat Lahir:");
        String tempatLahir =scanner.nextLine();
        System.out.println("Jenis Kelamin (P/L):");
        String jenisKelamin =scanner.nextLine();
        System.out.println("Pekerjaan");
        String pekerjaan = scanner.nextLine();
        Prospect prospect = new Prospect();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        prospect.setNamaDepan(namaDepan);
        prospect.setNamaBelakang(namaBelakang);
        prospect.setNomorProspect(listProspect.size()+1);
        prospect.setPekerjaan(pekerjaan);
        prospect.setKotaLahir(tempatLahir);
        prospect.setTanggalLahir(LocalDate.parse(tanggalLahir,dateFormat));
        prospect.setJenisKelamin(JenisKelamin.valueOf(jenisKelamin));
        prospect.setNasabah(false);
        listProspect.put(listProspect.size(),prospect);

        System.out.println("... Menambahkan Prospect Baru");
        menuUtama(listProspect,listCustomer);
    }


    public static void prospectKeCustomer(HashMap<Integer,Prospect> listProspect,HashMap<String, Nasabah> listCustomer){
        System.out.println("Ketik nomor prospect yang ingin dijadikan nasabah.");
        Scanner scanner = new Scanner(System.in);
        int nomorProspect = Integer.parseInt(scanner.nextLine());
        System.out.println("Nomor KTP:");
        String nomorKtp = scanner.nextLine();
        System.out.println("Status KK:");
        String statusKK = scanner.nextLine();
        System.out.println("Metode Pembayaran(CC/AC/VP)");
        System.out.println("(CC adalah Credit Card, AC adalah Auto Collection, VP adalah Voucher Point)");
        String metodePembayaran = scanner.nextLine();
        Nasabah nasabah =new Nasabah();
        nasabah.setProspect(listProspect.get(nomorProspect));
        nasabah.setTanggalMenjadiNasabah(LocalDate.now());
        nasabah.setMetodePembayaran(MetodePembayaran.AC);
        nasabah.setStatusKeluarga(statusKK);
        nasabah.setNomorKTP(nomorKtp);
        listProspect.get(nomorProspect).setNasabah(true);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nomorNasabah = dateFormat.format(nasabah.getTanggalMenjadiNasabah()).substring(3)+
                nasabah.getProspect().getNomorProspect();
        nasabah.setNomorNasabah(nomorNasabah);
        listCustomer.put(nasabah.getNomorNasabah(),nasabah);
        System.out.println("Nasabah berhasil di input");
        menuUtama(listProspect,listCustomer);
    }

    public static void beliProduct(HashMap<Integer,Prospect> listProspect,HashMap<String, Nasabah> listCustomer){
        System.out.println("Pilih Nomor Customer:");
        Scanner scanner = new Scanner(System.in);
        String nomorCustomer = scanner.nextLine();
        System.out.println("Pilih Nama Produk:");
        String namaProduct = scanner.nextLine();
        Nasabah nasabah = listCustomer.get(nomorCustomer);
        Polis polis = new Polis();
        polis.setPemilikPolis(nasabah);
        polis.setTanggalMulaiPolis(LocalDate.now());
        for(Produk produk : Asuransi.listProduk()){
            if(produk.getNamaProduk().equals(namaProduct)){
                polis.setProduk(produk);
                if(produk.getJenisAsuransi().getDeskripsi().equals("Kendaraan")){
                    tertanggungKendaraan(polis);
                }
                else {
                    tertanggungCustomer(polis,listCustomer);
                }
            }

        }

    }

    public static void tertanggungCustomer(Polis polis,HashMap<String, Nasabah> listCustomer){
        System.out.println("Pilih Nomor Customer Tertanggung:");
        Scanner scanner = new Scanner(System.in);
        String nomorCustomerTertanggung = scanner.nextLine();
        System.out.println("(Tanggal mulai polis dijalankan adalah hari ini)");
        polis.setCustomerTertanggung(listCustomer.get(nomorCustomerTertanggung));

    }

    public static void tertanggungKendaraan(Polis polis){
        System.out.println("Input Data Kendaraan:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jenis Kendaraan:");
        String jenisKendaraan = scanner.nextLine();

        System.out.println("Nomor Polisi:");
        String nomorPolisi = scanner.nextLine();

        System.out.println("Nomor STNK");
        String nomorSTNK = scanner.nextLine();

        System.out.println("Merk Kendaraan:");
        String merk = scanner.nextLine();

        System.out.println("Model Kendaraan:");
        String model = scanner.nextLine();

        System.out.println("Warna Kendaraan:");
        String warna = scanner.nextLine();
        Kendaraan kendaraan = new Kendaraan();
        kendaraan.setNomorPolisi(nomorPolisi);
        kendaraan.setMerk(merk);
        kendaraan.setModel(model);
        kendaraan.setNomorSTNK(nomorSTNK);
        kendaraan.setWarna(warna);
        kendaraan.setJenisKendaraan(JenisKendaraan.valueOf(jenisKendaraan));
        polis.setKendaraanTertanggung(kendaraan);
    }

    public static void detailPolicy() {
        Scanner scanner = new Scanner(System.in);
        String nomorCustomer = scanner.nextLine();
        System.out.println("====================CUSTOMER INFO=================");
        Nasabah customer = Asuransi.getListCustomer().get(nomorCustomer);
        customer.cetakInfoCustomer();
        System.out.println("====================POLICY INFO=================");
        for (Polis polis : customer.getListPolis()) {
            polis.cetakInfoPolis();
        }

    }
}
