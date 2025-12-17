package pemdacom.mycompany.proyekpemdaskel10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Transaksi {
    //Transfer, mendapatkan nasabah pengirim dan penerima, serta nominalnya
    public void Transfer(Nasabah pengirim, Nasabah penerima, double jumlahTF){
        if (pengirim.getSaldo()>=jumlahTF){
        pengirim.setSaldo(pengirim.getSaldo()-jumlahTF);
        penerima.setSaldo(penerima.getSaldo()+jumlahTF);
        System.out.println("Transaksi Anda Berhasil, Anda Mentransfer Rp."+jumlahTF+" Ke Rekening "+penerima.getNama()+"\n");
        } else{
            System.out.println("Transaksi Anda Gagal Saldo Tidak Cukup\n");
        }
    }
    //Menyimpan uang
    public void deposit(Nasabah penerima, double jumlahTF){
        penerima.setSaldo(penerima.getSaldo()+jumlahTF);
    }
    //Mengembalikan kode untuk melakukan transaksi cardless
    public int CardLessCode(){
        //Dapet kode simpen, masukin input, nambah duit
        Random random = new Random();
        int kode = random.nextInt(100000,999999);
        return kode;
    }
    //Mendapatkan tanggal transaksi untuk keperluan mutasi rekening
    public String getDate(){
        LocalDate hariIni = LocalDate.now();
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return hariIni.format(newFormat);
    }
}
 