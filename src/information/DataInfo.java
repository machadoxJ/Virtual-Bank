package information;

import program.Main;
import program.Registration;

import java.io.*;
import java.util.Objects;

import static information.BankInfo.getBalance;
import static information.RegistrationInfo.*;

public class DataInfo {


    public static void readInfo() {
        File readdata = new File("D:\\dados\\"+ getName());
        String data;

        //Se o nome não existe no login.
        if (!readdata.exists() && getRegister().equals("n")) {
            System.out.println ("O Nome não existe!");
            Registration registration = new Registration();
            registration.startLogin();
        }

        //Se o nome não existe na transferencia.
        else if (!readdata.exists() && getRegister().equals("b")) {
            System.out.println ("O Nome não existe ou foi cancelada/bloqueada!");
            Main bank = new Main();
            bank.OptionsBank();
        }

        //Se o nome existir no registro.
        else if (!readdata.exists() && getRegister().equals("s")) {
            String register = "s";
            RegistrationInfo registerinfo = new RegistrationInfo();
            registerinfo.setName(register);
            return;
        }

        //Irá ler os dados e depois enviar para o codigo.
        try {
            FileReader readingdata = new FileReader(readdata);
            BufferedReader readfile = new BufferedReader(readingdata);
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
                RegistrationInfo registerinfo = new RegistrationInfo();
                BankInfo bankinfo = new BankInfo();
                registerinfo.setName(name);
                registerinfo.setPassword(password);
                registerinfo.setAge(age);
                registerinfo.setCountry(country);
                bankinfo.setBalance(balance);
            }
            readingdata.close();
        } catch (IOException ex) {
            System.out.println("Impossivel achar esse nome na base de dados!");
        }
    }

    public static void recorddata() {
        File createdata = new File("D:\\dados\\" + getName());
        String readdate;

        //Irá ler dados e salvará fora do codigo.
        try {
            createdata.createNewFile();

            FileWriter date = new FileWriter("D:\\dados\\" + getName());
            BufferedWriter savingdata = new BufferedWriter(date);
            //Se a conta estiver bloqueada.
            if (Objects.equals(getBlock(), "y")) {
                readdate = getNameBlock() +
                        "," + getPassword() + getAge() + getNameBlock() + getAge() + getPassword() +
                        "," + getAge() +
                        "," + getCountry() +
                        "," + getBalance();
            }
            //Se for um salvamento normal.
            else {
                readdate = getName() +
                        "," + getPassword() +
                        "," + getAge() +
                        "," + getCountry() +
                        "," + getBalance();
            }
            savingdata.write(readdate);
            savingdata.newLine();
            savingdata.close();
            date.close();

        } catch (IOException ex) {
            System.out.println("Impossivel salvar esse nome na base de dados!");
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
