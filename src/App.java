import java.util.*;
import java.util.jar.Attributes.Name;

public class App implements consoleColor {        
    public static void main(String[] args) throws Exception {
        
         Scanner sc =new Scanner(System.in);
        System.out.println(" _    _            _     _   _     _     _        ___  ___      _             \n" + //
               BLUE+ "| |  | |          | |   | | | |   (_)   | |       |  \\/  |     | |            \n" + //
                "| |  | | ___  _ __| | __| | | |    _ ___| |_ ___  | .  . | __ _| | _____ _ __ \n" + //
                YELLOW+"| |/\\| |/ _ \\| '__| |/ _` | | |   | / __| __/ _ \\ | |\\/| |/ _` | |/ / _ \\ '__|\n" + //
                "\\  /\\  / (_) | |  | | (_| | | |___| \\__ \\ ||  __/ | |  | | (_| |   <  __/ |   \n" + //
                " \\/  \\/ \\___/|_|  |_|\\__,_| \\_____/_|___/\\__\\___| \\_|  |_/\\__,_|_|\\_\\___|_|   \n" + //
                "                                                                              \n" + //
                "         \033[1;32m                     Create By "+name+"                                                     " +RESET+ //
                "\n" + //
                "");    
        try
        {
            System.out.print("Enter worldlist name: "); 
            String WorldlistName=sc.next(); 
            
            System.out.print("\nthis worldlist is:\n \t1)Number \n \t2)Character \n"+RED+" press any key to cancel \n"+GREEN+" what your choice:1 or 2 :"+RESET);
                int choice=sc.nextInt();
                switch(choice)
                {
                    case 1:    
                            Number mm=new Number(WorldlistName);
                            mm.Controller();
                        break;
                    case 2:
                             character ch=new character(WorldlistName);     
                             ch.writetofile();         
                        break;
                    default:
                      System.out.println("\033[1;36m \n \t\t Bye!\n");
                      System.exit(3);
                }
                sc.close();
        }catch(Exception e)
        {e.getMessage();}
    }
    
}
