/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Library_Managment;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Description; Kutuphane sisteminin en genis classidir dosya islemleri icin ve tum bilgileri tutmak icin olusturulmustur.
 * @author ugur
 */
public final class Library
{
    ArrayList<Library_Books> All_Books = new ArrayList<>();
    ArrayList<User> All_Users = new ArrayList<>();
    ArrayList<Staff> All_Staff = new ArrayList<>();
    String userCsv = "user.csv";
    String booksCsv = "books.csv";

    /***
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Library() throws FileNotFoundException, IOException//constrc Burda sanırım ALL_books içine bütün kitapları çekmem gerkior.
    {
        Staff MainStaff = new Staff("admin","1111",this);
        All_Staff.add(MainStaff);
        loadCsvDatabase();
    }
    /**
     *
     * @return boolean   ; Onceden olusturulmus dosya var mı yok mu
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean loadCsvDatabase() throws FileNotFoundException, IOException
    {
        String line = "";
        String cvsSplitBy = ",";


        File f = new File(userCsv);
        File fb = new File(booksCsv);
        if( (f.exists() && !f.isDirectory()) && (fb.exists() && !fb.isDirectory()) )  //Existing Load  varsa okuma
        {
            System.out.println("Load Users,Books CSV file ");
            BufferedReader bruser = new BufferedReader(new FileReader(userCsv));
            BufferedReader brbook = new BufferedReader(new FileReader(booksCsv));

            while ((line = bruser.readLine()) != null)
            {
                String[] UserInfo = line.split(cvsSplitBy);
                int i= UserInfo.length;
                User newUser = new User(UserInfo[0],UserInfo[1],this);
                All_Users.add(newUser);

                for(int j=2; j < i; j+=3)
                {
                    Library_Books newBook = new Library_Books(UserInfo[j],UserInfo[j+1],UserInfo[j+2]);
                    newUser.BarrowBooks.add(newBook);
                }
                System.out.println("Kullanıcısı load edildi => [ Id= " + UserInfo[0] + " , Password=" + UserInfo[1] + "]");
            }

            while ((line = brbook.readLine()) != null)
            {
                String[] BookInfo = line.split(cvsSplitBy);

                All_Books.add(new Library_Books(BookInfo[0],BookInfo[1],BookInfo[2]));

                System.out.println("Kitap load edildi => [ Author= " + BookInfo[0] + " , Name=" + BookInfo[1] +" , Date=" + BookInfo[2] + "]");
            }
            bruser.close();
            brbook.close();

        }
        else
        {
            System.out.println("Mevcut user.csv ve books.csv dosyalari bulunamadi.");
        }

        return false;
    }
    /***
     * Users tutuldugu arraylisti sirasi ile ekrana basar
     */
    public void PrintUser()
    {
        for(User user:All_Users)
            System.out.println("Kullanici ID => "+user.getID()+ " Sifre => "+ user.getPassword());
    }
    /***
     * Books tutuldugu arraylisti sirasi ile ekrana basar
     */
    public void PrintBook()
    {
        for(Library_Books book:All_Books)
            System.out.println("Isim => "+book.getName()+"  Yazar => "+book.getAuthor()+" Basim Tarihi => "+book.getPublishedDate());
    }

    /***
     * Description ; Programdan cikis yapildigi zaman user.csv ve books.csv dosyalarini en guncel haliyle yeniden olusturur.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void SaveCsvDatabase() throws FileNotFoundException, IOException //biterken kayıt
    {
        FileWriter writer = new FileWriter(userCsv);

        StringBuilder sb = new StringBuilder();

        for(User user:All_Users)
        {
            sb.append(user.getID());
            sb.append(",");
            sb.append(user.getPassword());

            for(Library_Books book:user.BarrowBooks)
            {
                sb.append(",");
                sb.append(book.getAuthor());
                sb.append(",");
                sb.append(book.getName());
                sb.append(",");
                sb.append(book.getPublishedDate());
            }
            sb.append("\n");
        }
        writer.append(sb);   //userbilgilerini basiyor
        writer.close();


        FileWriter writerbook = new FileWriter(booksCsv);
        StringBuilder sbbook = new StringBuilder();

        for(Library_Books book:All_Books)
        {
            sbbook.append(book.getAuthor());
            sbbook.append(",");
            sbbook.append(book.getName());
            sbbook.append(",");
            sbbook.append(book.getPublishedDate());
            sbbook.append("\n");
        }
        writerbook.append(sbbook);        //kitap bilgilerini basiyor
        writerbook.close();
    }

    /***
     * Description ; yazari ve ismi bilinen kitabin butun kitaplar arasinda bulunmasini sagliyor.
     * @param Sname  ; kitap ismi
     * @param Sauthor   ; yazar ismi
     * @return  ; bulunan kitabin kendisi obje olarak donuyor.
     */
    public Library_Books SearchBook(String Sname,String Sauthor) //burda library_books objesimi dönmeli normal object mi bilmeidm
    {
        for(Library_Books book:All_Books)
        {
            if(book.getAuthor().equals(Sauthor) && book.getName().equals(Sname))
                return book;
        }
        return null;
    }

}
