/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niki.ai;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ADMINN
 */
public class NikiAi {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the path of the directory");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));       
        String directory=br1.readLine();
        //String directory="C:\\Users\\ADMINN\\Desktop\\Test";
        NikiAi.pintnumbers(directory);
    }   

    private static void pintnumbers(String directory) throws FileNotFoundException, IOException {
        File folder = new File(directory);
        File[] listoffiles = folder.listFiles();
        for (File file : listoffiles) {
               if(file.isDirectory()){
                 String directory1=directory+"\\"+file.getName();                
                 NikiAi.pintnumbers(directory1);
               }
               if(file.isFile()){
                   BufferedReader br = new BufferedReader(new FileReader(file));
                   String line;
                   while ((line = br.readLine()) != null) {
                   line = line.replaceAll("\\s+", " ");// replace all extra space by single space
                   line = line.replaceAll("\\,+", " ");// replace all comma(,) by single space
                   line = line.replaceAll("\\/+", " ");// replace all forward slash(/) space by single space
                       for (String retval: line.split(" ")) {
                               if(retval.matches("^(\\+91[\\-\\s]?)?[0]?(91)?(([789]\\d{9})|([ ][789]\\d{9}))$")){
                                   retval=retval.replaceAll("\\+91\\-?","");
                                   if(retval.length()==12){
                                      System.out.println(retval.substring(2,retval.length()));
                                   }else{
                                       if(retval.charAt(0)=='0'){
                                           System.out.println(retval.substring(1,retval.length()));
                                       }
                                       else{                                                
                                           System.out.println(retval);                       
                                       }
                                   }
                               }
                       }
                   }   
               }     
           }
    }
}
    