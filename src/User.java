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
import java.util.ArrayList;
/**
 * Description; Abstract_usersclass indan create edilerek olusturulmustur.
 *              Kutuphaneyi kullanacak normal kisiler icin vardir.
 * @author ugur
 */
public class User extends Abstract_UsersClass
{
    ArrayList<Library_Books> BarrowBooks = new ArrayList<>();
    Library system;
    private int size;

    /***
     *  Description; 3 parameter constructor
     * @param id    ; new user acc id
     * @param pass  ; new user acc passsword
     * @param system  ; library mangmt system.
     */
    public User(String id,String pass,Library system) //user oluşmalı sanırım const
    {
        setID(id);
        setPassword(pass);
        this.system = system;
        setSize(0);
    }

    /***
     *  Description; bir kullanicinin alabilecegi en fazla kitap sayisini belirler.
     * @param i
     */
    public final void setSize(int i){size=i;}
    public int getSize(){return size;}


    /***
     *  Description;  kisi listesi eger 3den fazla kitap yoksa istedigi kitabi alabilir.
     * @return islemin dogruluk durumu
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean Barrow() throws FileNotFoundException, IOException//user alıcak.
    {
        if( 3 > getSize())
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Almak istediğiniz kitabın Yazarı\n");
            String Author = bf.readLine();
            System.out.println("Almak istediğiniz kitabın Ismi\n");
            String Name = bf.readLine();


            for(Library_Books book:system.All_Books)
            {
                if(book.getAuthor().equals(Author) && book.getName().equals(Name))
                {
                    BarrowBooks.add(book);
                    setSize(getSize()+1);
                    return true;
                }
            }
        }
        else
        {
            System.out.println("Kitap almak hakkınız 3 tanedir.");
            return false;
        }

        System.out.println("Aradığınız Kitap Bulunamamistir.");
        return false;

    }

    /***
     * Description;Kullanicisnin barrowbooks listesi goruntulenir.
     */
    public void PrintUserBooks()
    {
        for(Library_Books book:BarrowBooks)
            System.out.println("Isim => "+book.getName()+"  Yazar => "+book.getAuthor()+" Basim Tarihi => "+book.getPublishedDate());
    }
    /***
     * Description; Kisinin listesi kontrol edilir ve istedigi kitap varsa listeden silinir 1 tane daha alma hakki acilir.
     * @return
     */
    public boolean ReturnBook() //eger bunu sayıya gore yaparsak index arttır azalt
    {
        try //eger bunu sayıya gore yaparsak index arttır azalt
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Iade etmek  istediğiniz kitabın Yazarı\n");
            String Author = bf.readLine();
            System.out.println("Iade etmek istediğiniz kitabın Ismi\n");
            String Name = bf.readLine();

            for(Library_Books book:BarrowBooks)
            {
                if(book.getAuthor().equals(Author) && book.getName().equals(Name))
                {
                    BarrowBooks.remove(book);
                    setSize(getSize()-1);
                    return true;
                }
            }
            System.out.println("Aradığınız Kitap Sizin listenizde Bulunamamistir.");
            return false;
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

}
