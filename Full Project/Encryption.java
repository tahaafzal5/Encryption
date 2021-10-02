import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

/* This is the test I used. It has the boundary/extreme cases (eg a,A,z,Z,0,9) and normal cases (eg c,d,G,6,K,m etc)
   along with symbols that are unchanged.
      

   abcdefghijklmopqrstuvwxyz
   ABCDEFGHIJKLMOPQRSTUVWXYZ
   0123456789
   `-=\][;'/.,/*-+.~!@#$%^&*()_+|}{":?>< */

/* Desc     : This program asks user whether he wants to encrypt or decrypt a file 
              and based on the users answer the program flow goes towards that.
  Input     : Accepts the number 1 for encryt and 2 for decrypt 
  Psuedocode:
            print("1. Encrypt a file")
            print("2. Decrypt a file")
            choice=readChar()
            switch (choice)
            {
                case '1': encrypt(); break
                case '2': decrypt(); break
            }
*/
public class Encryption
{
    /*
     Desc      : Encrypt a file.
     Input     : The user supplies the name of a disk file via the keyboard and the file must exist.
     Output    : The text in the specified file encrypt and written to "encrypted.txt".
     Throw     : FileNotFoundException if the input source file does not exist, or encrypted.txt cannot be created
     psuedocode:
               print "Enter file name: "
               input: file name
               while (input has Next()) 
               {
                   char ch = input.next().charAt(0);
                   ch = call convert(ch)
                   f.print(ch)
               }
               input.close() : close the scanner
               f.close() : close the printer */
    public static void encrypt() throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        Scanner inFile = new Scanner(new File(keyboard.nextLine()));
        inFile.useDelimiter("");

        PrintWriter outFile = new PrintWriter("encrypted.txt");

        while (inFile.hasNext())
        {
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
    Pseudocode:
            if (ch == 'Z') return 'A'
            else if (ch == 'z') return 'a'
            else if ((ch >= 'A' AND ch <= 'Y') OR (ch >= 'a' AND ch <= 'y')) 
                return (char) (ch + 1);
            else if (ch == '0') 
                return '9';
            else if (ch <= '9' && ch >= '1') 
                return (char) (ch - 1);

            return ch */
    public static char convert (char character)
    {
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
        psuedocode:
                    print "Enter file name: "
                    input: file name
                    while (input has Next()) 
                    {
                        char ch = input.next().charAt(0);
                        ch = call inverseConvert(ch)
                        f.print(ch)
                    }
                    input.close() : close the scanner
                    f.close() : close the printer */
    public static void decrypt() throws FileNotFoundException
    {
        Scanner keyboard = new Scanner(System.in);
        char character ='a';
        System.out.print("Enter file name: ");
        Scanner inFile = new Scanner(new File(keyboard.nextLine()));
        inFile.useDelimiter("");

        PrintWriter outFile = new PrintWriter("decrypted.txt");

        while (inFile.hasNext())
        {
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
                if (ch == 'A') 
                    return 'Z'
                else if (ch == 'a')  
                    return 'z'
                else if ((ch >= 'B' AND ch <= 'Z') OR (ch >= 'b' AND ch <= 'z')) 
                    return (char)(ch - 1)
                else if (ch == '9') 
                    return '0'
                else if (ch <= '8' && ch >= '0') 
                    return (char)(ch + 1)
                
                return ch */
    public static char inverseConvert(char character)
    {
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