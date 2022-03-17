package mainPack;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Astro
 */
public class Terminal {

    Parser parser = new Parser();
    //I created that variable to keep track of the current path
    String currentPath = System.getProperty("user.dir");
//Implement each command in a method, for example:

    public void echo(String[] args) {
        System.out.println(args[0]);
    }

    public void pwd() {
        //testing argument
        System.out.println(currentPath);
    }
    
    public void ls(String[] args) {
        //testing argument
        File f = new File(currentPath);
        String[] ar = f.list();
        try{
        if(args[0].equals("-r")){
            for(int i=ar.length-1;i>=0;i--)
                System.out.print(ar[i] + "  ");
            System.out.print("\n");
        }else{
            System.out.println( "bad arguments" );
        }
        }catch(NullPointerException e){
            for(int i=0;i<ar.length;i++)
                System.out.print(ar[i] + "  ");
            System.out.print("\n");
        }
    }
// ...
//This method will choose the suitable command method to be called

    public void chooseCommandAction() {
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String input = in.nextLine();
        boolean valid = parser.parse(input);
        if (valid) {
            //switch between commands
            switch (parser.getCommandName()) {
                case "echo":
                    this.echo(parser.getArgs());
                    break;
                case "pwd":
                    this.pwd();
                    break;
                case "ls":
                    this.ls(parser.getArgs());
                    break;
                case "exit":
                    throw new IllegalStateException();
                default:
                    System.out.println("error has occured!");
                    break;
            }
        }else{
            if(parser.getIsArgProblem())
            System.out.println("arguments number is not right");
        }
    }

    public static void main(String[] args) {
        while (true) {
            Terminal t = new Terminal();
            try{
                t.chooseCommandAction();
            }catch(IllegalStateException e){
                break;
            }
        }
    }
}
