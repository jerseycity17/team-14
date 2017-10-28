/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taglinkcreator;

import java.util.Hashtable;

/**
 *
 * @author gazi
 */
public class WeightedConnections{
       Hashtable<String,Integer> connectionWeight;
        
        public WeightedConnections(){
            connectionWeight = new Hashtable<String,Integer>();
        }
        
        public void addNewConnection(String str){
            connectionWeight.put(str, new Integer(1));
        }
        
        public void incrementConnection(String str){
            connectionWeight.put(str, new Integer(connectionWeight.get(str).intValue()+1));
        }
    }
