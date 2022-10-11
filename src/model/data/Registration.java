package model.data;

public class Registration {

    //informações --
    private static String name;
    private static String password;
    private static String country;
    private static int age;

    //mudanças --
    private static String register;
    private static String block;
    private static String nameblock;

    public Registration() {

    }

    public void setName(String name){ Registration.name = name; }
    public static String getName(){ return name; }
    public void setPassword(String password){ Registration.password = password; }
    public static String getPassword(){ return password; }
    public void setAge(int age){ Registration.age = age; }
    public static int getAge(){ return age; }
    public void setCountry(String country){ Registration.country = country; }
    public static String getCountry(){ return country; }
    public void setRegister(String register){ Registration.register = register; }
    public static String getRegister(){ return register;}
    public void setBlock(String block){ Registration.block = block; }
    public static String getBlock(){ return block;}
    public void setNameBlock(String nameblock){ Registration.nameblock = nameblock; }
    public static String getNameBlock(){ return nameblock;}


}
