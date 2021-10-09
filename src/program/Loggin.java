package program;

import info.Information;
import info.Salving;

import java.util.Objects;
import java.util.Scanner;


public class Loggin {

    private static String nome;
    private static String senha;
    private static String register;
    private static String block;
    private static String nameblock;
    private static String pais;
    private static int idade;
    Main inicio = new Main();

    public Loggin() {

    }
    public Loggin(int age, String pais, String nome, String senha) {
        Loggin.nome = nome;
        Loggin.senha = senha;
        Loggin.pais = pais;
        idade = age;
    }

    public void Registrar() {
        Scanner re = new Scanner(System.in);
        String y;
        do {
            Information info = new Information();
            System.out.println();
            System.out.println("----------Register----------");
            info.regist();
            System.out.println();
            System.out.println("----------Dados----------");
            System.out.println("Seu nome: " + nome);
            System.out.println("Sua senha: " + senha);
            System.out.println("Seu pais: " + pais);
            System.out.println("Sua idade: " + idade);
            System.out.println();
            System.out.println("----------Dados----------");
            System.out.println("Deseja finalizar o cadastro?");
            System.out.println("Digite 's'!");
            y = re.nextLine();
        } while (y.equals("n"));
        Salving.gravarInfos();
        System.out.println("Cadastro feito!!");
        inicio.banco();
    }

    public void setName(String name){ nome = name; }
    public void setPassword(String password){ senha = password; }
    public void setAge(int age){ idade = age; }
    public void setCountry(String country){ pais = country; }
    public void setRegister(String register){ Loggin.register = register; }
    public void setBlock(String block){ Loggin.block = block; }
    public void setNameBlock(String nameblock){ Loggin.nameblock = nameblock; }

    public void Login() {
        Scanner lo = new Scanner(System.in);
        String s;
        String y = "n";
        int a;
        String p;
        int i = 0;
        do {
            System.out.println();
            System.out.println("----------Login----------");
            System.out.println("Nome: ");
            nome = lo.nextLine();
            String noblock = nome;
            setRegister(y);
            Salving.lerInfos();
            String yeblock = "bloqueada" + noblock;
            if (Objects.equals(getName(), yeblock)) {
                System.out.println();
                System.out.println("Essa conta está Bloqueada!!");
                Login();
            }

            System.out.println();
            s = senha;
            System.out.println("Senha: ");
            senha = lo.nextLine();

            if (senha.equals(s)) {
                System.out.println();
                System.out.println("Nome e senha válidos");
            }
            else {
                i++;
                System.out.println();
                System.out.println("Nome ou senha inválidos");
                if (i == 3 || i == 4) {
                    System.out.println();
                    System.out.println("Deseja mudar de senha?");
                    System.out.println("Digite 's'!");
                    y = lo.nextLine();
                    if (Objects.equals(y, "s")) {
                        System.out.println();
                        System.out.println("Responda duas perguntas:");
                        System.out.println();
                        System.out.println("Qual a idade foi colocada no registro?");
                        a = lo.nextInt();
                        if (a != getAge()) {
                            System.out.println();
                            System.out.println("A idade inserida está incorreta!");
                            System.out.println("Conta bloqueada!!!");
                            String block = "bloqueada" + getName();
                            setName(block);
                            Salving.gravarInfos();
                            Login();
                        }
                        System.out.println();
                        System.out.println("Qual o país foi colocado no registro?");
                        p = lo.nextLine();
                        if (!p.equals(getCountry())) {
                            System.out.println();
                            System.out.println("O país inserido está incorreto!");
                            System.out.println("Conta bloqueada!!!");
                            String nameblock = "bloqueada" + getName();
                            setBlock("y");
                            setNameBlock(nameblock);
                            Salving.gravarInfos();
                            Login();
                        }

                        inicio.inicio();
                    }
                } else if (i > 4 && i < 10) {
                    System.out.println();
                    System.out.println("Deseja voltar?");
                    System.out.println("Digite 's'!");
                    y = lo.nextLine();
                    if (Objects.equals(y, "s")) {
                        System.out.println();
                        System.out.println("Voltando...");
                        inicio.inicio();
                    }
                } else if (i >= 10) {
                    System.out.println("Sua conta acabou de ser Bloqueada!!");
                    String nameblock = "bloqueada" + getName();
                    setBlock("y");
                    setNameBlock(nameblock);
                    Salving.gravarInfos();
                    Login();
                    inicio.inicio();
                    Login();
                }
            }
        } while (!senha.equals(s));
        System.out.println();
        System.out.println("Login feito!!");
        inicio.banco();
    }
    public static String getName(){ return nome; }
    public static String getPassword(){ return senha; }
    public static int getAge(){ return idade; }
    public static String getCountry(){ return pais; }
    public static String getRegister(){ return register;}
    public static String getNameBlock(){ return nameblock;}
    public static String getBlock(){ return block;}
}
