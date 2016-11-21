package assignment1;

import java.util.ArrayList;

public class Node implements Comparable<Node>{

	int id;
	int pre_id;
	float sum_cost;
	int child_num;
	Node pre_node;
	
	public Node(int id, int pre_id, float sum_cost) {
		this.id = id;
		this.pre_id = pre_id;
		this.sum_cost = sum_cost;
	}
	
	public void set_pre_node(Node pre_node) {
		this.pre_node = pre_node;
	}
	
	public Node get_pre_node() {
		return pre_node;
	}
	
	public int get_id() {
		return id;
	}
	
	public int get_pre_id() {
		return pre_id;
	}
	
	public void set_number_of_child(int child) {
		child_num = child;
	}
	

	
	public float get_sum_cost() {
		return sum_cost;
	}
	
	@Override
	public String toString() {
		return ("Node id: " + this.id + " with pre_id: " + this.pre_id +
				 " total cost " + this.sum_cost);
	}
	
	@Override
	public int compareTo(Node anotherNode) {
	    return this.sum_cost > anotherNode.get_sum_cost() ? 1 : -1 ;
	}
}
