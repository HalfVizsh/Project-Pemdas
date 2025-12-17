package pemdacom.mycompany.proyekpemdaskel10;
import java.util.ArrayList;
public class Nasabah {
    private String Nama;
    private String Password;
    private int noRek;
    private double Saldo = 50000;
    ArrayList<MutasiRekening> Riwayat = new ArrayList<>();
    public Nasabah(String n, String p, int r){
        Nama = n;
        Password = p;
        noRek = r;
    }
    //Setter
    public void setNama(String n){
        Nama = n;
    }
    public void setPass(String p){
        Password = p;
    }
    public void setRek(int r){
        noRek = r;
    }
    public void setSaldo (double s){
        Saldo = s;
    }
    //Getter
    public String getNama(){
        return Nama;
    }
    public String getPass(){
        return Password;
    }
    public int getRek(){
        return noRek;
    }
    public double getSaldo(){
        return Saldo;
    }
    //Method Collection
    public void ReadSaldo(){
        System.out.print("Saldo anda: "+Saldo+"\n\n");
    }
    public void addMutasi(MutasiRekening rwt){
        Riwayat.add(rwt);
    }
    public ArrayList<MutasiRekening> getMutasi(){
        if (Riwayat.size()<=0) System.out.print("Anda belum melakukan transaksi apapun\n");
        return Riwayat;
    }
    public void cetakMutasi(){
        for (MutasiRekening mr : Riwayat){
            mr.cetakDetail();
        }
    }
}