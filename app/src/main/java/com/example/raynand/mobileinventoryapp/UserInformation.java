package com.example.raynand.mobileinventoryapp;

public class UserInformation {

    int id;
    String  LastName,FirstName ,username,password , email;


    public void setId (int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }
    //id

    public void setLastName (String LastName)
    {
        this.LastName = LastName;
    }

    public String getLastname()
    {
        return this.LastName;
    }
    //Last Name

    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getFirstName()
    {
        return FirstName;
    }
    //First Name

    public void setUsername(String username)
    {
            this.username = username;
    }
    public String getUsername()
    {
        return this.username;
    }
        //username

    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }
    //password


    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
    //email
}

//https://www.youtube.com/watch?v=NT1qxmqH1eM
// part 1 of the database tutorial for SQL in android