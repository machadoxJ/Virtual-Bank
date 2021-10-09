package info;

import program.Loggin;
import program.Main;

import java.io.*;
import java.util.Objects;

public class Salving {


    public static void lerInfos() {
        File lerdados = new File("D:\\dados\\"+ Loggin.getName());
        String dados;

        if (!lerdados.exists() && Loggin.getRegister().equals("n")) {
            System.out.println ("O Nome não existe!");
            Loggin loggin = new Loggin();
            loggin.Login();
        }

        else if (!lerdados.exists() && Loggin.getRegister().equals("b")) {
            System.out.println ("O Nome não existe ou foi cancelada/bloqueada!");
            Main bank = new Main();
            bank.banco();
        }

        else if (!lerdados.exists() && Loggin.getRegister().equals("s")) {
            String rnome = "s";
            Loggin Loggin = new Loggin();
            Loggin.setName(rnome);
            return;
        }

        try {
            FileReader lendodados = new FileReader(lerdados);
            BufferedReader lerdadoss = new BufferedReader(lendodados);
            dados = lerdadoss.readLine();
            if (lerdados.exists()) {
                String[] vet = dados.split(",");
                String nome = vet[0];
                String senha = vet[1];
                String pais = vet[3];
                String lidade = vet[2];
                String lsaldo = vet[4];
                int idade = Integer.parseInt(lidade);
                double saldo = Double.parseDouble(lsaldo);
                Loggin Loggin = new Loggin();
                Loggin.setName(nome);
                Loggin.setPassword(senha);
                Loggin.setAge(idade);
                Loggin.setCountry(pais);
                Bankinfo bank = new Bankinfo();
                bank.setSaldo(saldo);
            }
            lendodados.close();

        } catch (IOException ex) {
            System.out.println("Impossivel achar esse nome na base de dados!");
        }
    }

    public static void gravarInfos() {
        File dadoscreate = new File("D:\\dados\\" + Loggin.getName());
        String sdados;

        try {
            dadoscreate.createNewFile();

            FileWriter dados = new FileWriter("D:\\dados\\" + Loggin.getName());
            BufferedWriter savededados = new BufferedWriter(dados);
            if (Objects.equals(Loggin.getBlock(), "y")) {
                sdados = Loggin.getNameBlock() +
                        "," + Loggin.getPassword() +
                        Loggin.getAge() +
                        Loggin.getNameBlock() +
                        Loggin.getAge() +
                        Loggin.getPassword() +
                        "," + Loggin.getAge() +
                        "," + Loggin.getCountry() +
                        "," + Bankinfo.getSaldo();
            }
            else {
                sdados = Loggin.getName() +
                        "," + Loggin.getPassword() +
                        "," + Loggin.getAge() +
                        "," + Loggin.getCountry() +
                        "," + Bankinfo.getSaldo();
            }
            savededados.write(sdados);
            savededados.newLine();
            savededados.close();
            dados.close();

        } catch (IOException ex) {
            System.out.println("Impossivel achar esse nome na base de dados!");
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
