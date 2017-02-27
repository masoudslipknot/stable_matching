
package project1;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;
import javax.management.Query;
 import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;
import static javax.sound.sampled.AudioSystem.getLine;
public class Project1 {
   

   
    public  static int res[][]=new int[110][1110];
    public static int task[][]=new int[102][1002];    //for understanding which univercity to ask.
    public static int married[]=new int [1110]; //whether univercity is free or not
    public static  int students[][]=new int [1110][1110];
    public static int univercity[][]=new int[1110][1110];
    public static Queue freestudents=new LinkedList(); 
    public static Integer n;
    public static int t;

    public static void  alghorithm() {
        for(int k=1;k<=101;k++){
            for(int o=1;o<=1001;o++){
               task[k][o]=1; 
            }
            
        }
        Scanner test=new Scanner(System.in);
         t=test.nextInt();
         
        for(int i=1;i<=t;i++){
        //Scanner num=new Scanner(System.in);
        
        
        
              n=test.nextInt();
                 
         
        
        for(int j=1;j<=n;j++ ){
            freestudents.add(j);
            
            
            for(int k=1;k<=n;k++){
          //  Scanner stu=new Scanner(System.in);
            
              int temp=test.nextInt();
                
            students[j][k]=temp;
            
                
            
            }
            
        }
        for(int j=1;j<=n;j++){
            for(int k=1;k<=n;k++){
                //Scanner stu=new Scanner(System.in);
              
           
               
            int temp=test.nextInt();
                 
          
            univercity[j][k]=temp;
            
           
            
            }
        }
        
         while(freestudents.size()!=0){
             int nowstudents=(int) freestudents.peek();
             int priority=task[i][nowstudents];
            // System.out.print(priority + " i wonder is it true or not");
             
             int unitogo=students[nowstudents][priority];
             if(married[unitogo]!=1){
             res[i][unitogo]=nowstudents;
             priority=priority+1;
             task[i][nowstudents]=priority;
             freestudents.remove();
             married[unitogo]=1;
             }else if(married[unitogo]==1){
                 int tempstudent=res[i][unitogo];
                 int l=1;
                 while(univercity[unitogo][l]!=nowstudents){
                     l++;
                 }
                 int m=1;
                 while(univercity[unitogo][m]!=tempstudent){
                     m++;
                 }
                 if(l<m){
                     res[i][unitogo]=nowstudents;
                     
                     freestudents.remove();
                     freestudents.add(tempstudent);
                 }
                 else if (l>m){
                     priority=priority+1;
                     task[i][nowstudents]=priority;
                     
                 }
             }
             
             
              
        
             
         }
         System.out.println();
         for(int y=1;y<=1010;y++){
             married[y]=0;
         }
         
        
        
     
       
    }
        for(int b=1;b<=t;b++){
             System.out.println("#"+b);
             for(int j=1;res[b][j]!=0;j++){
             System.out.print(res[b][j]+" ");
             }
             System.out.println();
         }
         System.out.println();
         System.out.println();
         
        
       
    }
    public static void main(String[] args) {
       alghorithm();
    }

    
}
