import java.io.*;
import java.util.*;

public class character implements consoleColor {
            String path="";//*if you want to add path for save  worldlist like ("//src//character//");
            int minLength=8;
            Scanner sc= new Scanner(System.in);
            Random rand = new Random();

    private String WorldlistName;
    private String firstname;
    private String lastname;
    private String companyname;
    private String childrenname;
    private String[] childrentab;
    private String age;
    private String girlfriendname;
    private String pet;
    int[] tab=new int[]{0,1,2,3,4,5,6,7,8,9};
    ArrayList<String> list=new ArrayList<String>();
        String[] world;

    public  File file1;
            
            public character(String ch)
            {    
                
                this.WorldlistName=ch;
                System.out.print("\nEnter the firstname: ");
                    this.firstname=sc.nextLine();list.add(this.firstname);// * Firstname |index 0
                System.out.print("\nEnter the Lastname: ");
                    this.lastname=sc.nextLine();list.add(this.lastname);// * lastname |index 1
                System.out.print("\nEnter company name: ");
                    this.companyname=sc.nextLine();list.add(this.companyname);// * company name |index 2
                System.out.print("\nEnter children name \n"+GREEN_BACKGROUND+"(if you have alot of cheldren write like :ahmed,mohammed,sara ): "+RESET);
                    this.childrenname=sc.nextLine();
                    this.childrentab=childrenname.split(",");
                System.out.println("\nEnter years old: ");
                    this.age=sc.nextLine();list.add(age);// * age | index 3
                       
                System.out.print("\nEnter girl friend name: ");
                    this.girlfriendname=sc.nextLine();list.add(this.girlfriendname);// * index 4
                System.out.print("\nEnter pet name: ");
                        this.pet=sc.nextLine();list.add(this.pet);// * index 5
                System.out.print("\nDo you want add some  world ["+GREEN+"Yes"+YELLOW+" or"+RED+" No  ]: ");
                        String rep=sc.nextLine();
                        if(rep.equals("Yes") || rep.equals("yes") ||rep.equals("y") ||rep.equals("Y"))
                        {
                            System.out.println(RED_BOLD+"press Q or q to cancel:"+RESET); 
                                String w;
                            for(int i=0;i<10;i++)
                            {
                                System.out.print("\nEnter the world: ");
                                    w=sc.nextLine();//? Filling a table
                                    list.add(w);
                                    if(w.equals("q")||w.equals("Q")){break;} //! press Q or q to break out the loop
                            }
                             System.out.println(BLACK_BOLD+"..... !\n"+RESET);

                        }
                        else if(rep.equals("No") || rep.equals("no") ||rep.equals("n") ||rep.equals("N"))
                        {
                            System.out.print(RESET);
                        }else
                        {
                            System.out.println(BLACK_BOLD+"Error !"+RESET);
                        }

            }
    
       
            /* can you change the directory path */ //!if you don't change the directory path then it will be in the same directory
        public void makefile()
        {
            try {
                 
                  file1 = new File(path+WorldlistName+".txt"); 
                 
                   System.out.print("Worldlist be create in same directory src ! ");

            } catch (Exception e) {
                 System.out.print("Worldlist be create in same directory src ! ");
                   file1 = new File(WorldlistName+".txt");   

            }
           
        }

        public void writetofile()
        {
            makefile();            
            try{
                int en=0,i,j;
                FileWriter writer = new FileWriter(file1);

                    for( i = 0; i <list.size(); i++)
                        {
                            //System.out.println("Test0");            //! test
                            for( j = 0; j < list.size();j++)
                                { // System.out.println("Test1");            //! test
                                   writer.append(corrector(minLength,list.get(i)+list.get(j))+"\n");
                                   writer.append(corrector(minLength,list.get(i)+list.get(j)+tab[rand.nextInt(tab.length)])+"\n");
                                   if(en==0)
                                    {
                                        for(int h=0;h<childrentab.length;h++)
                                        {        //System.out.println("Test 2");  //! test
                                             writer.append(corrector(minLength,childrentab[h]+list.get(i)+list.get(j))+"\n");
                                             System.out.println("Test2");  
                                             if(h!=0)
                                             {
                                                //System.out.println("Test3");            //! test
                                                 writer.append(corrector(minLength,childrentab[h-1]+childrentab[h])+"\n");
                                             }
                                             else{
                                                 writer.append(corrector(minLength,childrentab[h]+list.get(rand.nextInt(list.size())))+"\n");
                                             }  
                                        }    
                                    } 
                                    en=1;
                                   
                                }
                             if(i%2==0)
                                        {//System.out.println("Test4");              //! test
                                            System.out.println(corrector(minLength,list.get(rand.nextInt(list.size()))+list.get(rand.nextInt(list.size()))+tab[rand.nextInt(tab.length)])+"\n");
                                        }
                                        else
                                        {
                                         //   System.out.println("Test5");              //! test
                                            writer.append(corrector(minLength,list.get(i)+getRandArrayElement()+list.get(rand.nextInt(list.size()))+tab[rand.nextInt(tab.length)])+"\n");
                                            writer.append(corrector(minLength,list.get(rand.nextInt(list.size()))+getRandArrayElement()+tab[rand.nextInt(tab.length)])+"\n");
                                        }         
                        }
                         for( i = 0; i <list.size(); i++)
                            {
                                for( j = 0; j < list.size();j++)
                                {
                                    if(list.get(i).length()>3)
                                        {
                                            System.out.println(corrector(minLength,list.get(i)).substring(0,list.get(i).length()/2)+list.get(j).substring(0,list.get(j).length()/2)+tab[rand.nextInt(tab.length)]);
                                        }
                                }
                            }
                             writer.close();
                          
                
            } catch (Exception e) {
                // TODO: handle exception
                System.out.print(e.getMessage());
            }
        }
        
        public char getRandArrayElement()
        {

            char[] items = new  char[]{'_','-','/','\\','|','@','!','.'};

                Random rand = new Random();

            return items[rand.nextInt(items.length)]; 
       }

       public String corrector(int min,String var)
       {/*String test="";
            if(var.length()<min)
            { while(var.length()<min)
                {
                 test=var+getRandArrayElement()+list.get(rand.nextInt(list.size()))+tab[rand.nextInt(tab.length)];
                }
                return test;
            }
            else{return var;}  */
            return var;
       }

       
    
}
