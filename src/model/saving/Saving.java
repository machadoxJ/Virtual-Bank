package model.saving;

import application.Program;
import model.data.Bank;
import model.data.Registration;
import model.register.Loggin;

import java.io.*;
import java.util.Objects;

import static model.data.Registration.*;
import static model.data.Bank.*;

public class Saving {


    public static void readData() {
        File readdata = new File("D:\\dados\\"+ getName());
        String data;

        //Se o nome não existe no login.
        if (!readdata.exists() && getRegister().equals("n")) {
            System.out.println ("O Nome não existe!");
            Loggin registration = new Loggin();
            registration.startLogin();
        }

        //Se o nome não existe na transferencia.
        else if (!readdata.exists() && getRegister().equals("b")) {
            System.out.println ("O Nome não existe ou foi cancelada/bloqueada!");
            Program bank = new Program();
            bank.OptionsBank();
        }

        //Se o nome existir no registro.
        else if (!readdata.exists() && getRegister().equals("s")) {
            String register = "s";
            Registration registerinfo = new Registration();
            registerinfo.setName(register);
            return;
        }

        //Irá ler os dados e depois enviar para o codigo.
        try (BufferedReader readfile = new BufferedReader(new FileReader(readdata))){
            data = readfile.readLine();
            if (readdata.exists()) {
                String[] vet = data.split(",");
                String name = vet[0];
                String password = vet[1];
                String country = vet[3];
                String lineage = vet[2];
                String linebalance = vet[4];
                int age = Integer.parseInt(lineage);
                double balance = Double.parseDouble(linebalance);
                Registration registerinfo = new Registration();
                Bank bankinfo = new Bank();
                registerinfo.setName(name);
                registerinfo.setPassword(password);
                registerinfo.setAge(age);
                registerinfo.setCountry(country);
                bankinfo.setBalance(balance);
            }
        } catch (IOException ex) {
            Bank bankinfo = new Bank();
            bankinfo.setAccount(false);
        }
    }

    public static void recordData() {
        File createdata = new File("D:\\dados\\" + getName());
        String savedate;

        //Irá ler dados e salvará fora do codigo.
        try (BufferedWriter date = new BufferedWriter(new FileWriter("D:\\dados\\" + getName()))){
            createdata.createNewFile();
            //Se a conta estiver bloqueada.
            if (Objects.equals(getBlock(), "y")) {
                savedate = getNameBlock() +
                        "," + getPassword() + getAge() + getNameBlock() + getAge() + getPassword() +
                        "," + getAge() +
                        "," + getCountry() +
                        "," + getBalance();
            }
            //Se for um salvamento normal.
            else {
                savedate = getName() +
                        "," + getPassword() +
                        "," + getAge() +
                        "," + getCountry() +
                        "," + getBalance();
            }
            date.write(savedate);
            date.newLine();

        } catch (IOException ex) {
            System.out.println("ERRO: Impossivel salvar esses dados na base de dados!");
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
