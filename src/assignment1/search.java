/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.*;

/**
 *
 * @author lvzheng
 */
public class search {
	
	Node first_node;
	Node poll_node;
	List<ArrayList<Float>> CostList;
	ArrayList<Float> sum_cost;
	PriorityQueue<Node> queue;
	ArrayList<Node> finalPath;

	
	public search (int start_id, int target_id, int size, float[][] matrix) {
		
		sum_cost = new ArrayList<Float>();
		queue = new PriorityQueue<>();
		finalPath = new ArrayList<>();
		CostList = new ArrayList<ArrayList<Float>>();
		first_node = new Node(start_id, 0, 0);
		long startTime = System.currentTimeMillis();

		for(int i = 0; i < size + 1; i++) sum_cost.add((float) 0);
		

		queue.add(first_node);
		poll_node = queue.poll();
		while(poll_node.get_id() != target_id) {
			
			int currIndex = poll_node.get_id();
			sum_cost.set(currIndex, poll_node.get_sum_cost() + sum_cost.get(currIndex)); 
			
			for(int i = 0; i < size; i++) {
				
				if(matrix[poll_node.get_id() - 1][i] != 0) {
					float cost = sum_cost.get(currIndex) + matrix[poll_node.get_id() - 1][i];
					Node childNode = new Node(i + 1, currIndex, cost);

					childNode.set_pre_node(poll_node);
					queue.add(childNode);
					
				}

			}
			
			poll_node = queue.poll();	
		}
		
		System.out.println("Total cost: " + poll_node.get_sum_cost());
		finalPath.add(poll_node);
		
		while(poll_node.get_pre_id() != 0) {
			poll_node = poll_node.get_pre_node();
			finalPath.add(poll_node);
		}
		
		Collections.reverse(finalPath);
		System.out.println("Final path: ");
		for(int i = 0; i < finalPath.size(); i++) {
			System.out.print(finalPath.get(i).get_id());
			if(i != finalPath.size() - 1) System.out.print( " - > ");
		}
		System.out.println();
		long endTime   = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + " ms");
		
	}
	
}
