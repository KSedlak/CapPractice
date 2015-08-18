package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
			NodeValidators nv= new NodeValidators();
			List<Node> nodes  = new ArrayList<Node>();
				
		
			Node n1 =new Node("1117", "desc", "1199");
			Node n2 =new Node("1118", "desc", "1117");
			Node n3 =new Node("119", "raz dwa trzy cztery piec szesc siedem osiem raz dwa trzy cztery piec szesc siedem osiem raz dwa trzy cztery piec szesc siedem osiem", "1118");
			Node n4 =new Node("1110", "aadaaaaaaadddddddraz dwa trzy cztery piec szesc siedem osiem raz dwa trzy cztery piec szesc siedem osiem raz dwa trzy cztery piec", "1119");
			Node n5 =new Node("1111", "desc", "1110");
			Node n6 =new Node("1112", "desc", "1110");
			Node n7 =new Node("1113", "desc", "1112");
			Node n8 =new Node("1114", "desc", "1113");
			Node n9 =new Node("15", "desc", "1113");
			nodes.add(n1);
			nodes.add(n2);
			nodes.add(n3);
			nodes.add(n4);
			nodes.add(n5);
			nodes.add(n6);
			nodes.add(n7);
			nodes.add(n8);
			nodes.add(n9);
		
			
			nv.validateMethod(nodes);
			
			
			
		

	}

}
