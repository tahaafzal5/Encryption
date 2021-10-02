import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

/* Desc     : This program asks user whether he wants to encrypt or decrypt a file 
              and based on the users answer the program flow goes towards that.
  Input     : Accepts the number 1 for encryt and 2 for decrypt 
*/
public class Encryption {
    /*
     Desc      : Encrypt a file.
     Input     : The user supplies the name of a disk file via the keyboard and the file must exist.
     Output    : The text in the specified file encrypt and written to "encrypted.txt".
     Throw     : FileNotFoundException if the input source file does not exist, or encrypted.txt cannot be created
     */
    public static void encrypt() throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        Scanner inFile = new Scanner(new File(keyboard.nextLine()));
        inFile.useDelimiter("");

        PrintWriter outFile = new PrintWriter("encrypted.txt");

        while (inFile.hasNext()) {
            char character = inFile.next().charAt(0);
            character = convert(character);
            outFile.print(character);
        }

        keyboard.close();
        inFile.close();
        outFile.close();
    }

    /*
    Desc      : Convert a character to another secret character.
    Return    :The predecessor of ch in the Unicode set.
    */
    public static char convert (char character) {
        if (character == 'Z')
            return 'A';
        else if (character == 'z')
            return 'a';
        else if ((character >= 'A' && character <= 'Y') || (character >= 'a' && character <= 'y'))
            return (char)(character + 1);
        else if (character == '0')
            return '9';
        else if (character <= '9' && character >= '1')
            return (char)(character - 1);

        return character;
        
    }

     /* Desc      : Decrypts a file.
        Input     : The user supplies the name of a disk file via the keyboard and the file must exist.
        Output    : The text in the specified file decrypted and written to "decrypted.txt".
        Throw     : FileNotFoundException if the input source file does not exist, or decrypted.txt cannot be created
     */
    public static void decrypt() throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        char character ='a';
        System.out.print("Enter file name: ");
        Scanner inFile = new Scanner(new File(keyboard.nextLine()));
        inFile.useDelimiter("");

        PrintWriter outFile = new PrintWriter("decrypted.txt");

        while (inFile.hasNext()) {
            character = inFile.next().charAt(0);
            character = inverseConvert(character);
            outFile.print(character);
        }

        keyboard.close();
        inFile.close();
        outFile.close();
    }

    /*
     Desc      : Convert a character to another character.
     Return    : The successor of ch in the Unicode set.
     Pseudocode:
    */
    public static char inverseConvert(char character) {
        if (character == 'A')
            return 'Z';
        else if (character == 'a')
            return 'z';
        else if ((character >= 'B' && character <= 'Z') || (character >= 'b' && character <= 'z'))
            return (char)(character - 1);
        else if (character == '9')
            return '0';
        else if (character <= '8' && character >= '0')
            return (char)(character + 1);

        return character;
    }
}