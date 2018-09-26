package com.findat.model;
import java.util.ArrayList;
import java.util.List;

public class UserList {	

    private static final List<User> userList = new ArrayList<User>();
    
    private UserList(){}
    
    static{
    	userList.add(new User("johnsmith","John","Smith","00000001A","john.smith@abc.com"));
    	userList.add(new User("lauraadams","Laura","Adams","00000001B","laura.adams@abc.com"));
        userList.add(new User("peterwilliams", "Peter","Williams","00000003C","peter.williams@abc.com"));
        userList.add(new User("joanasanders", "Joana","Sanders","00000004D","joana.sanders@abc.com"));
        userList.add(new User("johndrake","John","Drake","00000005E","john.drake@abc.com"));
        userList.add(new User("samualwilliams", "Samuel","Williams","00000006F","samuel.williams@abc.com"));
    }
    
    public static List<User> getInstance(){
        return userList;
    }
}


