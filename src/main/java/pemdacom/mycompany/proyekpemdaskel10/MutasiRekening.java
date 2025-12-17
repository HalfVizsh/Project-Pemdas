package pemdacom.mycompany.proyekpemdaskel10;
public class MutasiRekening {
    String jenis;
    String tanggal;
    String tujuan;
    int nominal;
    public MutasiRekening(String j, String t, int n){
        jenis = j;
        tanggal = t;
        nominal = n;
    }
     public MutasiRekening(String j, String t, String p, int n){
        jenis = j;
        tanggal = t;
        nominal = n;
        tujuan = p;
    }
    public void cetakDetail(){
        if (tujuan!=null)System.out.print(jenis+" Sebesar Rp. "+nominal+" Ke rekening "+tujuan+" Tanggal "+tanggal+"\n");
        else System.out.print(jenis+" Sebesar Rp. "+nominal+" Tanggal "+tanggal+"\n");
    }
}
