package pemdacom.mycompany.proyekpemdaskel10;
import java.util.Scanner;

public class MainMenu {
    Scanner input = new Scanner(System.in);
    Transaksi transaksi = new Transaksi();
    Nasabah currentNasabah;
    //Mendapatkan nasabah saat ini
    public void setNasabah (Nasabah nb){
        currentNasabah = nb;
    }
    //Menjalankan seluruh transaksi
    public void runMainMenu(){
        int pilihan;
        do {
        System.out.print("Halo Tuan/Nyonya "+currentNasabah.getNama()+"\nNo. Rek: "+currentNasabah.getRek()+"\n1. Cek Saldo\n2. Transfer\n3. Setor Tunai Tanpa Kartu\n4. Mutasi Rekening\n5. Log Out\nSilahkan pilih transaksi yang ingin anda lakukan: ");
        pilihan = input.nextInt();
        input.nextLine();
        switch (pilihan){
            case 1 -> //Membaca saldo
                currentNasabah.ReadSaldo();
            case 2 -> TF();
            case 3 -> CL();
            case 4 -> {
                //Mutasi Rekening
                System.out.println("Ini mutasi rekening anda");
                currentNasabah.cetakMutasi();
                System.out.println();
                }
            case 5 -> {
                System.out.println("Anda Telah Keluar, sampai jumpa Tuan/Nyonya "+currentNasabah.getNama()+"\n");
                return;
                }
            default -> {
                }
            } 
        }while (pilihan!=5);   
    }
    //Transfer
    public void TF(){
        System.out.print("Anda hendak melakukan Transfer, silahkan masukkan rekening tujuan: ");
        String NasabahTujuan = input.nextLine();
        if (NasabahTujuan.equals(currentNasabah.getNama())){
            System.out.println("Tidak bisa transfer ke rekening sendiri!\n");
            return;
        }
        if (DatabaseNasabah.cekNasabah(NasabahTujuan))//Cek nasabahnnya ada apa ngga
        {
            System.out.print ("Transfer ke Rekening: "+NasabahTujuan+"\nMasukkan nominal yang ingin anda transfer: ");
            int jumlah = input.nextInt();
            input.nextLine();
            
            System.out.print ("Tolong masukkan password anda: ");
            String pass = input.nextLine();
            if (!pass.equals(currentNasabah.getPass())){
                System.out.print ("Pin anda salah, coba lagi!\n\n");
                return;
            }
            
            if (jumlah<=0) {
                System.out.println("Nominal tidak valid mohon masukkan ulang!\n");
                return;
            }
            Nasabah targetNasabah = DatabaseNasabah.getNasabahByName(NasabahTujuan);
            transaksi.Transfer(currentNasabah, targetNasabah, jumlah);
            //Tambah Mutasi Rekening
            MutasiRekening MR = new MutasiRekening("Transfer", transaksi.getDate(), NasabahTujuan,jumlah);
            currentNasabah.addMutasi(MR);
        }
        else {
            System.out.print("Nasabah tidak ditemukan\n\n");
        }    
    }
    //Card less
    public void CL(){
        System.out.print("Anda hendak melakukan setor tunai tanpa kartu,\nmasukkan kode ini ke ATM terdekat: "+transaksi.CardLessCode());
        System.out.print("\n(Demonstrasi) Masukkan Nominal yang anda ingin masukkan: ");
        int nominal = input.nextInt();
        input.nextLine();
        if (nominal<=0) {
            System.out.println("Nominal tidak valid mohon masukkan ulang!");
            return;
        }
        System.out.print("Berhasil setor tunai sebesar Rp. "+nominal+"\n\n");
        //Tambah ke mutasi rekening
        transaksi.deposit(currentNasabah, nominal);
        MutasiRekening MR = new MutasiRekening("Setor Tunai", transaksi.getDate(),nominal);
        currentNasabah.addMutasi(MR);
    }
}