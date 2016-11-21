/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.*;
import java.util.*;
import java.sql.Date;


public class readfile {
    
    private Scanner map_file;
    private Scanner query_file;
    private float[][] map;
    private int [][] query;
    private int dim1;
    private int dim2;
    
    public void openF(String map, String query) {
        try{
            map_file = new Scanner(new File(map));
        }
        catch (Exception error) {
            System.out.println("I did not find file-map");
        }
        
        try{
            query_file = new Scanner(new File(query));
        }
        catch (Exception error) {
            System.out.println("I did not find file-query");
        }
    
    }
    
    public int[] get_size() {
        int[] size = new int[2];
        size[0] = dim1;
        size[1] = dim2;
        return size;
    }
    
    public void load_file() {
        dim1 =  Integer.parseInt(map_file.nextLine());
        dim2 =  Integer.parseInt(query_file.nextLine());
        int i = 0, j = 0;
        map = new float[dim1][dim1];
        query = new int[dim2][3];
        String buffer;
        
        //System.out.println(dim2);
        while(map_file.hasNext()) {
            buffer = map_file.nextLine();
            for (String x: buffer.split(" ")){
                map[j][i] = Float.parseFloat(x);
                i++;
            }
            
            j++;
            i = 0;
        }
        
        
        
        i = 0;
        j = 0;
        
        while(query_file.hasNext()) {
            buffer = query_file.nextLine();
            for (String x: buffer.split(" ")){
                if (x.equals("A*")) {
                    query[j][i] = 1;
                } else if(x.equals("Uniform")) {
                    query[j][i] = 2;
                } else {
                    query[j][i] = Integer.parseInt(x);
                }
                
                i++;
            }
            
            j++;
            i = 0;
        }
        
        
        map_file.close();
        query_file.close();
    }
    
    public float[][] get_map() {
        return map;
    }
    
    public int[][] get_query() {
        return query;
    }
    
    
}
