/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taglinkcreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gazi
 */
public class TagLinkCreator {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList <String> tagList = new ArrayList<String>();
        
        Scanner scanner = new Scanner(new File("/home/gazi/NetBeansProjects/TagLinkCreator/tags.csv"));
        scanner.useDelimiter(";|\n|\"");
        String item;
        
        while(scanner.hasNext()){
            item = scanner.next();
            item.trim();
            
            if(item.length()>0)
            item = checkForQuotes(item);
 
           if(!tagList.contains(item) && !item.isEmpty() && !item.matches("Automatic Tags") && !item.matches("^\\s*$")){
           tagList.add(item);
           }
           }
           
        for (String str : tagList){
            System.out.println(str);
        }
   
        scanner.close();
        
        String[][] newTagList = createCompleteTagList(tagList);
        
        createWeightedTagGraph();
        
    }
    
    public static String checkForQuotes(String item){
        String newItem;
        
        if(item.charAt(0)=='"')
            newItem = item.substring(1);
        else if(item.charAt(item.length()-1)=='"')
            newItem = item.substring(0,item.length()-1);
        else
            newItem = item;
        
        return newItem.trim();
    }
    
    public static String [][] createCompleteTagList(ArrayList<String> tagList){
        String[][] completeList = new String [tagList.size()][2];
        for(int i=0;i<tagList.size();i++){
            completeList[i][0]="id";
            completeList[i][1]=tagList.get(i);
        }
        return completeList;
    }
    
    public static WeightedGraph createWeightedTagGraph(){
        
        WeightedGraph wg = new WeightedGraph();
        
        try{
         Scanner scanner = new Scanner(new File("/home/gazi/NetBeansProjects/TagLinkCreator/tags.csv"));
         
         String line;
         scanner.nextLine(); //skip the first Line
         
         while(scanner.hasNextLine()){
             line = scanner.nextLine();
             String [] listArr = line.split(";");
             
             for(int i=0;i<listArr.length-1;i++){
                 String srcConnectionStr = listArr[i];
                 wg.addNewNode(srcConnectionStr);
                 WeightedConnections wc = wg.retrieveSingleNode(srcConnectionStr);
                 
                 for(int j=i+1;j<listArr.length;j++){
                     if(wc.connectionWeight.contains(listArr[j])){
                         wc.incrementConnection(listArr[j]);
                     }
                     else{
                         wc.addNewConnection(listArr[j]);
                     }
                 }
                 
             }
            
         }
         
         
         scanner.close();
         
        }
        catch(Exception E){
            System.out.println(E.getMessage());
        }
        return wg;
    }
}
