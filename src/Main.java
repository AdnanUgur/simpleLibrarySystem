/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Library_Managment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ugur
 */
public class Main
{
    /**
     * Description  ; Login olma islemi ile baslayan bir dongu sistemi
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        int stat = 0;
        Library RunLib = new Library();

        System.out.println("\nINAC Kutuphanesine Hosgeldiniz.");
        System.out.println("Staff bilgileri => ID = admin , Pws = 1111 ");
        System.out.println("Lütfen Kullanıcı Girisi Yapınız.");
        int i,k=0;
        while(true)
        {   i=-1;
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(" ID => ");
            String ID = bf.readLine();

            System.out.println(" Password => ");
            String password = bf.readLine();

            for(Staff loginStaff:RunLib.All_Staff)
            {
                if(loginStaff.getID().equals(ID) && loginStaff.getPassword().equals(password))
                {
                    System.out.println("Admin Girisi Dogrulandı!!");
                    stat = 1;
                }
            }
            if(stat != 1)
            {
                for(User loginUser:RunLib.All_Users)
                {   ++i;
                    if(loginUser.getID().equals(ID) && loginUser.getPassword().equals(password))
                    {   k=i;
                        System.out.println("Kullanici Girisi Dogrulandı!!"+"Siz "+i+" numarali kulanicsiniz.");
                        stat = 2;
                    }

                }
            }
            if(stat == 0)
                System.out.println("Kullanici bilgileriniz yalnis TEKRAR DENEYIN!!\n");


            while(stat == 1) //adminse bu bolgede takilir
            {
                System.out.println("Admin Olarak Neler yapmak istersiniz? Modun degerini secin\n"
                        +" 1)Kullanıcı Ekle\n"
                        +" 2)Kullanıcı Cikar\n"
                        +" 3)Kitap Ekle\n"
                        +" 4)Kitap Cikar\n"
                        +" 5)Butun Kullanicilari Goruntule\n"
                        +" 6)Butun Kitaplari Goruntule\n"
                        +" 7)Kullanicidan Cikis Yapin\n" //stat = 0
                        +" 8)Programdan Cikis Yapin\n");    //stat -1;

                bf = new BufferedReader(new InputStreamReader(System.in));

                System.out.println(" Mod => ");
                int Command = Integer.parseInt(bf.readLine());

                if(Command == 1)
                    RunLib.All_Staff.get(0).AddUser();

                else if(Command == 2)
                    RunLib.All_Staff.get(0).RemoveUser();

                else if(Command == 3)
                    RunLib.All_Staff.get(0).AddBook();

                else if(Command == 4)
                    RunLib.All_Staff.get(0).RemoveBook();

                else if(Command == 5)
                    RunLib.PrintUser();

                else if(Command == 6)
                    RunLib.PrintBook();

                else if(Command == 7)
                {
                    stat = 0;
                    System.out.println("Adminden Cikis Yapildi. Tekrar Login ol!!\n");
                }


                else if(Command == 8)
                    stat = -1;

                else
                    System.out.println("Hatali deger girdiniz. Tekrar Deneyin");
            }

            while(stat == 2) //kullanici bu bolgede takilir
            {
                System.out.println("Kullanici Olarak Neler yapmak istersiniz? Modun degerini secin\n"
                        +" 1)Kitap Ekle\n"
                        +" 2)Kitap Cikar\n"
                        +" 3)Kitap Listenizi Goruntuleyin\n"
                        +" 4)Bütün Kitap Listesini Goruntuleyin\n"
                        +" 5)Kullanicidan Cikis Yapin\n"
                        +" 6)Programdan Cikis Yapin\n");

                bf = new BufferedReader(new InputStreamReader(System.in));

                System.out.println(" Mod => ");
                int Command = Integer.parseInt(bf.readLine());

                if(Command == 1)
                    RunLib.All_Users.get(k).Barrow(); //LogUser.Barrow();
                else if(Command == 2)
                {
                    RunLib.All_Users.get(k).PrintUserBooks();
                    System.out.println("Hangi kitabi iade etmek istiyorsunuz??");
                    RunLib.All_Users.get(k).ReturnBook();
                }
                else if(Command == 3)
                    RunLib.All_Users.get(k).PrintUserBooks();
                else if(Command == 4)
                {
                    RunLib.PrintBook();
                }
                else if(Command == 5)
                {
                    stat = 0;
                    System.out.println("Kullanicidan Cikis Yapildi. Tekrar Login ol!!\n");
                }
                else if(Command == 6)
                    stat = -1;
                else
                    System.out.println("Hatali deger girdiniz. Tekrar Deneyin");


            }

            if(stat == -1)
            {
                System.out.println("Program kapatiliyor. Kayit dosyalari yenilenecek.\n");
                RunLib.SaveCsvDatabase();
                break;
            }
        }

    }
}
