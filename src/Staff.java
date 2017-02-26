/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Library_Managment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description; Abstract_usersclass indan create edilerek olusturulmustur.
 *              Kutuphanenin tek yoneticisi olan admin kullanicisi icindir
 * @author ugur
 */
public class Staff extends Abstract_UsersClass
{
    private Library system;

    /***
     * Description; 3parameter constructor
     * @param id    ;   staff acc id
     * @param pass  ;   staff acc password
     * @param system ;  library managmetn system
     */
    public Staff(String id,String pass, Library system ) //Veritabanına ıd ve password eklesin 2.yede gitsin ıd yi eklesin kitap eklemesin.
    {
        setID(id);
        setPassword(pass);
        this.system = system;
    }

    /***
     * Description; Staff normal kullanicilar ekleyebilmesi icin Id ve password alarak create ediyor.
     * @return  olusan new user
     */
    public User AddUser() //Veritabanına ıd ve password eklesin 2.yede gitsin ıd yi eklesin kitap eklemesin.
    {
        try //Veritabanına ıd ve password eklesin 2.yede gitsin ıd yi eklesin kitap eklemesin.
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Please new ID\n");
            String ID = bf.readLine();
            System.out.println("Please new Password\n");
            String Password = bf.readLine();

            for(User user:system.All_Users)
            {
                if(user.getID().equals(ID))
                {
                    System.out.println("Bu kullanıcı Id mevcut");
                    return null;
                }
            }
            User newUser = new User(ID, Password,system);
            system.All_Users.add(newUser);
            return newUser;

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    /***
     * Description;  Staff normal kullanicilari silebilmesi icin  Sadece ID alıyor cunku idler tekil
     * @return  true or false
     */
    public boolean RemoveUser() //Veritabanına ıd ve password eklesin 2.yede gitsin ıd yi eklesin kitap eklemesin.
    {
        try //Veritabanına ıd ve password eklesin 2.yede gitsin ıd yi eklesin kitap eklemesin.
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Silmek istediğiniz Kullanıcının ID'si\n");
            String ID = bf.readLine();

            for(User user:system.All_Users)
            {
                if(user.getID().equals(ID))
                {
                    system.All_Users.remove(user);
                    return true;
                }
            }
            return false;
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    /***
     * Description; Staff kutuphaneye yeni kitaplar ekleyebilir. Author,name ve date girerek.
     * @return  yeni eklenen kitap objesi return ediliyor.
     */
    public Library_Books AddBook()
    {
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Eklemek istediğiniz kitabın Yazarı\n");
            String Author = bf.readLine();
            System.out.println("Eklemek istediğiniz kitabın Ismi\n");
            String Name = bf.readLine();
            System.out.println("Eklemek istediğiniz kitabın Basim Tarihi\n");
            String Date = bf.readLine();

            for(Library_Books book:system.All_Books)
            {
                if(book.getAuthor().equals(Author) && book.getName().equals(Name)&& book.getPublishedDate().equals(Date))
                {
                    System.out.println("Bu Kitaptan bulunmaktadır.");
                    return null;
                }
            }
            Library_Books newBook = new Library_Books(Author,Name,Date);
            system.All_Books.add(newBook);
            return newBook;
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    /***
     *  Description; Staff author ,name,date e gore dogru kitabi silebilir.
     * @return  silme isleminin gerceklesip gerceklesmemesine gore.
     */
    public boolean RemoveBook()
    {
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Silmek istediğiniz kitabın Yazarı\n");
            String Author = bf.readLine();
            System.out.println("Silmek istediğiniz kitabın Ismi\n");
            String Name = bf.readLine();
            System.out.println("Silmek istediğiniz kitabın Tarihi\n");
            String Date = bf.readLine();

            for(Library_Books book:system.All_Books)
            {
                if(book.getAuthor().equals(Author) && book.getName().equals(Name)&& book.getPublishedDate().equals(Date))
                {
                    system.All_Books.remove(book);
                    return true;
                }
            }
            return false;
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
