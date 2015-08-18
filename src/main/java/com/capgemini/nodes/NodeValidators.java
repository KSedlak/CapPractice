package com.capgemini.nodes;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 *     <li>node id should have 4 characters</li>
 *     <li>node description can have maximal 128 characters</li>
 *     <li>no cycle</li>
 *     <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {
    public void validateMethod(List<Node> nodes) {
    	System.out.println("analiza:");
    	HashMap<String, Integer> nodesId = new HashMap<String, Integer>();
    	int counter=0;
    	for(Node n:nodes){
            System.out.println("\n Node nr: "+counter++);
            System.out.println(n);

    		if(!checkIdCharacters(n)){
            	System.out.println("Blad: Id powinno miec 4 znaki");
            }
    		
    		if(!checkMaxDesc(n)){
            	System.out.println("Blad: Opis moze miec maksymalnie 128 znakow");
            }
    		if(hasCycle(nodes)){
    			System.out.println("Blad: Wystapilo zapetlenie");
    		}
    		if(!onlyLastHasTwoSub(nodes,n)){
    			System.out.println("Blad: Nie tylko ostatni ma dwoch nastepnikow");
    		}
    	
    	}

    }
    
    private boolean checkIdCharacters(Node n){
    	return n.getId().length()==4;
    }
    private boolean checkMaxDesc(Node n){
    	return n.getDescription().length()<=128;
    }
    public boolean hasCycle(List<Node> nodes){
		return	(nodes.get(0).getPredecessorId()==nodes.get(nodes.size()-1).getId())	||
		(nodes.get(0).getPredecessorId()==nodes.get(nodes.size()-2).getId());

    }
    public boolean onlyLastHasTwoSub(List<Node> nodes, Node n){
    	String nodePred="";
    	int counter;
    
    		nodePred=n.getPredecessorId();
    		counter=0;
    		for(Node k:nodes){
    			if(nodePred.equals(k.getPredecessorId())){
    				counter++;
    			}
    		}
    		if(counter==2 && !nodePred.equals(nodes.get(nodes.size()-2).getPredecessorId())){
    			return false;
    		}
    	
     return true;
    }
    
}
