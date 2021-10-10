package information;

public class RegistrationInfo {

    //informações --
    private static String name;
    private static String password;
    private static String country;
    private static int age;

    //mudanças --
    private static String register;
    private static String block;
    private static String nameblock;

    public RegistrationInfo() {

    }

    public void setName(String name){ RegistrationInfo.name = name; }
    public static String getName(){ return name; }
    public void setPassword(String password){ RegistrationInfo.password = password; }
    public static String getPassword(){ return password; }
    public void setAge(int age){ RegistrationInfo.age = age; }
    public static int getAge(){ return age; }
    public void setCountry(String country){ RegistrationInfo.country = country; }
    public static String getCountry(){ return country; }
    public void setRegister(String register){ RegistrationInfo.register = register; }
    public static String getRegister(){ return register;}
    public void setBlock(String block){ RegistrationInfo.block = block; }
    public static String getBlock(){ return block;}
    public void setNameBlock(String nameblock){ RegistrationInfo.nameblock = nameblock; }
    public static String getNameBlock(){ return nameblock;}


}
