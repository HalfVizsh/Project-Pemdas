package pemdacom.mycompany.proyekpemdaskel10;

import java.util.ArrayList;

public class DatabaseNasabah {
    private static ArrayList<Nasabah> listNasabah = new ArrayList<>();
    public static ArrayList<Nasabah> getDBNasabah (){
        return listNasabah;
    } 
    //Menambahkan Nasabah
    public static void addNasabah(String nama, String pass, int noRek){
        Nasabah nb = new Nasabah (nama, pass, noRek);
        listNasabah.add(nb);
    }
    //Mengcek nasabahnya ada atau tidak
    public static boolean cekNasabah(String namaNasabah){
        boolean isExist = false;
        for (int a=0;a<listNasabah.size();a++){
            if (namaNasabah.equals(listNasabah.get(a).getNama())){
                isExist = true;
            }
        }
        return isExist;
    }
    //Autentikasi nama dan Pass
    public boolean nameAndPassCheck(String nama, String pass){
        boolean nasabahAda = false;
        boolean passBenar = false;
        boolean userIsCorrect = false;
        //Apakah Nasabah Ada di Data Base atau Enggak
        for (int i =0; i<listNasabah.size();i++){
            if (nama.equals(listNasabah.get(i).getNama())){
                nasabahAda = true;
                if (pass.equals(listNasabah.get(i).getPass())){
                    passBenar = true;
                }
            }
        }
        if (!nasabahAda){
            System.out.println("Nasabah tidak ditemukan mohon coba lagi\n");
        } else {
            if (!passBenar){
                System.out.println("Password anda salah mohon coba lagi\n");
            }else{
                userIsCorrect = true;
            }
        }
               return userIsCorrect;
    }
    //Mencari Nasabah dengan namanya
    public static Nasabah getNasabahByName(String name){
        Nasabah nsb = null;
        for (int a=0;a<listNasabah.size();a++){
            if (name.equals(listNasabah.get(a).getNama())){
                nsb = listNasabah.get(a);
            }
        }
        return nsb;
    }
}
