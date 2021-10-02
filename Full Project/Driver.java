import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");

        int userChoice = keyboard.nextInt();

        if (userChoice == 1)
            Encryption.encrypt();
        else if (userChoice == 2)
            Encryption.decrypt();
            
        keyboard.close();
    }
}