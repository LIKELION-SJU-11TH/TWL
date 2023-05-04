package jave_2;

public class User {
    String id;
    String name;

    public User(){
        id= "";
        name = "";
    }
    public User(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
