import java.io.*;
import java.util.*;

public class Number implements consoleColor  {
        String path="";//*if you want to add path for save  worldlist like ("//src//number//");
        Scanner sc =new Scanner(System.in);
        private int start;
        private int end;
        private String WorldlistName;
        private String Numberz;
        private int var=0;
        File file1;

        public Number(String nm)    //? Construct
        {
             this.WorldlistName=nm;
             System.out.print("\nthe list:\n\t1)start 0 like 0000000;\n\t2)start in normal number;\n\n\t what your choice: ");
             int choice=sc.nextInt();
             if(choice==2) 
             {
                    System.out.print("\nEnter number for Start:");
                       this.start=sc.nextInt();var=1;
             }
             else if(choice==1)
             {
                System.out.print("\nEnter number for Start:");
                    this.Numberz=sc.next();
                    var=2;
             }
            System.out.print("\nEnter number for end:");
            this.end=sc.nextInt();
        }
        public void makefile()
        {
            try {
                 file1 = new File(path+WorldlistName+".txt");  
                   
            } catch (Exception e) {System.out.print("Worldlist be create in same directory src ! ");file1 = new File(WorldlistName+".txt");}
        }
        public void Controller()
        {
            makefile();
            if(var==1)
            {
                makeworllist();
                System.out.println(BLUE+"\nyour worldlist between: "+start+" and: "+end+" is created!!!");
            }
            else if(var==2 && isnumber(Numberz))
            {
                makeworllist(Numberz);
                System.out.println(BLUE+"\nyour worldlist between: "+Numberz+" and: "+end+" is created!!!");
            }
            else
            {System.out.println(RED+"verification failed -_- !");}
            System.out.println(RESET);
        }
        //?verification index[0] of the number==0 

        public boolean isnumber(String num)
        {
            char var=num.charAt(0);
            if(var=='0')
                {return true;}
             return false;   
        }
        public void makeworllist()
        {
            try {
                     FileWriter writer =new FileWriter(file1);
                     if(start<end)
                     {
                        for(int i=start;i<=end;i++)
                        {   
                            writer.append(i+"\n");
                        }
                         writer.close();
                     }
                     else
                     {
                        for(int i=start;i>=end;i--)
                        {    
                            writer.append(i+"\n");
                        }
                           writer.close();
                     }
            } 
            catch (Exception e) 
            {e.getMessage();} 
        }
        public void makeworllist(String n)
            {   
                try {
                    int i=1,c=1,t=0;
                      FileWriter writer =new FileWriter(file1);
                        while(n.length()-t!=0 && end!=i-1)
                        {
                            String res=n.substring(0,n.length()-t);
                            if(c>i)
                            {
                                writer.write(res+i+"\n");
                                i++;          
                            }
                            else
                            {
                                c=c*10;
                                t++;
                            }
                        }
                        writer.close();
              }catch(Exception e)
                     {
                        System.out.println(e);
                     }   
            }    
}
