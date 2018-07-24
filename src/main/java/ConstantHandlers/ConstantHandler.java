
package ConstantHandlers;

import Entities.User;

public class ConstantHandler {
    
    public static final String DISCONNECTED_MESSAGE = "Server is DICCONNECTED";
    
    // Constant Variable Handler to save and access information of current user
    public static User user;
    
    // <editor-fold defaultstate="fold" desc="CLASS VARIABLES FOR LOGIN">  
    
    // Constant variable for character allowed in username
    public static final String UNAME_ALLOWED_CHARS = "1234567890-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    
    public static final String INVALIDITY_MESSAGE = "Invalid User Login info";
    public static final String INVALIDITY_TITLE = "ACCESS DENIED";
    
    // dialog messages for valid user info
    public static String WELCOME_MESSAGE = "WELCOME ";
    public static final String WELCOME_TITLE = "ACCESS GRANTED";
    
    //dialog messages for confirmation to exit
    public static final String CONFIRM_EXIT_MESSAGE = "Are you sure you want to cancel / exit the program?";
    public static final String CONFIRM_EXIT_TITLE = "CONFIRM EXIT";
    
    public static final String INCOMPLETE_FORM_MESSAGE = "Please complete log-in form";
    public static final String LESS_THAN_6_CHAR_MESSAGE = "Username and Password must be at least 6 characters";
    public static final String MAX_CHAR_MESSAGE = "Username and Password must only have a maximum 20 characters";
    public static final String SPECIAL_CHAR_MESSAGE = "Special character is not allowed in the User ID and Password";
    // </editor-fold> 

    // <editor-fold defaultstate="fold" desc="CLASS VARIABLES FOR CREATE ACCOUNT">  
    public static final String CONFIRM_SAVE_MESSAGE = "Are you sure you want to create this account?";
    public static final String CONFIRM_SAVE_TITLE = "CONFIRM CREATE ACCOUNT";
    
    // dialog message for unsuccessfully saved user
    public static final String UNSUCCESSFUL_SAVE_MESSAGE = "Data was not successfully added to the database!";
    public static final String UNSUCCESSFUL_SAVE_TITLE = "ERROR OCCURED WHILE SAVING";
    
    // dialog message for successfully saved user
    public static final String SUCCESSFUL_SAVE_MESSAGE = "New user was successfully saved to the database";
    public static final String SUCCESSFUL_SAVE_TITLE = "SAVE SUCCESSFUL";
    // </editor-fold> 
    
}
