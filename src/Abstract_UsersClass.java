/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Library_Managment;

/**
 * Description; abstract base class for staff and users
 * @author ugur
 */
public abstract class Abstract_UsersClass implements Managment_Users_Interface
{
    private String ID;
    private String Password;
    /***
     * Description; abstract base class for staff and users
     * @param newID  ; acc id
     */
    @Override
    public void setID(String newID){ ID = newID; }
    /***
     * Description; abstract base class for staff and users
     * @return  ; acc id getter
     */
    @Override
    public String getID(){ return ID; }
    /***
     * Description; abstract base class for staff and users
     * @param newPassword ; acc password
     */
    @Override
    public void setPassword(String newPassword){ Password = newPassword;  }
    /***
     * Description; abstract base class for staff and users
     * @return  ; acc password getter
     */
    @Override
    public String getPassword(){ return Password;  }

}
