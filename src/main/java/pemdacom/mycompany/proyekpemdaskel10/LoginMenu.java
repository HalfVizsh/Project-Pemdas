package pemdacom.mycompany.proyekpemdaskel10;
import java.util.Scanner;
import java.util.Random;
public class LoginMenu {
    DatabaseNasabah dbNasabah = new DatabaseNasabah();
    public void loginMechanism () {
       Scanner input = new Scanner(System.in);
       int pilihan;
       do {
       System.out.print("Selamat Datang di Bank Simajuntak\n1.Sign in\n2.Log in\n3.Exit\nSilahkan pilih opsi yang anda inginkan: ");
       pilihan = input.nextInt();
       input.nextLine();
       System.out.println();         
       switch(pilihan){
           case 1:
               //Kumpulin Atribut Nasabah
               System.out.print("Anda hendak mendaftar\nSilahkan masukkan nama anda: ");
               String namaDaf = input.nextLine();//Nama Daftar
               if (dbNasabah.cekNasabah(namaDaf)){
                   System.out.println("Nama sudah anda! mohon masukkan nama lain!\n");
                   break;
               }
               System.out.print("Silahkan masukkan password anda: ");
               String passDaf = input.nextLine();
               Random random = new Random();
               int rekDaf = random.nextInt(100000,999999);
               //Menambahkan nasabah ke database
               dbNasabah.addNasabah(namaDaf, passDaf,rekDaf);
               System.out.println("Selamat anda telah terdaftar, silahkan Login\n");
               break;
           case 2:
               int Attempt = 1;
               do {
               System.out.print("Anda Hendak Masuk\nSilahkan masukkan nama anda: ");
               String namaMas = input.nextLine(); //Nama Masuk
               System.out.print("Silahkan masukkan password anda: ");
               String passMas = input.nextLine();
               //Autentikasi
               if (dbNasabah.nameAndPassCheck(namaMas, passMas)){
                   MainMenu toMenu = new MainMenu();
                   toMenu.setNasabah(dbNasabah.getNasabahByName(namaMas));
                   toMenu.runMainMenu();
                   break;
               }
               Attempt++;
               } while (Attempt<=3);
               if (Attempt>3){
                   System.out.println("Anda Terlalu Banyak Salah! Akun Anda Diblokir Sementara\n");
                   break;
               }
               break;
           case 3:
               System.out.println("Terima kasih telah menggunakan aplikasi Mbanking Simajuntak");
               break;
           default:
               System.out.print("Pilihan anda tidak valid!\n");
               break;
            }
       } while (pilihan!=3);
    }
}
