/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Library_Managment;

/**
 * Description; Kutuphanedeki kitaplarin ozelliklerini tutmak icin olusturulmustur.
 * @author ugur
 */
public final class Library_Books
{
    private String BookAuthor;
    private String BookName;
    private String BookPublishedDate;

    /***
     *  Description ; Constructor 3 parameter
     * @param Author    ; kitabin yazari
     * @param Name      ; kitabin ismi
     * @param PublishedDate     ; kitabin basim tarihi
     */
    public Library_Books(String Author,String Name,String PublishedDate)
    {
        setAuthor(Author);
        setName(Name);
        setPublishedDate(PublishedDate);
    }

    /***
     *  Description ; yazari guncellemek icin
     * @param Author
     */
    public void setAuthor(String Author){BookAuthor = Author;}
    /***
     * Description  ; kitap ismini guncellemek icin
     * @param Name
     */
    public void setName(String Name){BookName = Name;}
    /***
     * Description ; kitabin basim tarihini guncellemek icin
     * @param Date
     */
    public void setPublishedDate(String Date){BookPublishedDate = Date;}

    /***
     * Description;
     * @return  String book's author
     */
    public String getAuthor(){return BookAuthor;}
    /***
     * Description;
     * @return string book's name
     */
    public String getName(){return BookName;}
    /***
     * Description;
     * @return  string book's published date
     */
    public String getPublishedDate(){return BookPublishedDate;}

}
