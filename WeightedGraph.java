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
public class WeightedGraph {
    
    Hashtable<String,WeightedConnections> tagConnections;
  
    
    public WeightedGraph(){
        tagConnections = new Hashtable<String,WeightedConnections>();
    }
    
    public void addNewNode(String newNodeString) throws Exception{
        if(!tagConnections.contains(newNodeString))
        tagConnections.put(newNodeString, new WeightedConnections());
        else{
            throw new Exception("Node already exists");
        }
        
    }
    
    public WeightedConnections retrieveSingleNode(String srcNodeStr) throws Exception{
        if(tagConnections.containsKey(srcNodeStr))
        return tagConnections.get(srcNodeStr);
        else
            throw new Exception("Connection does not Exist");
    }
    
    
    
    
}
