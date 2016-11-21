/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.*;
import java.util.*;


public class Comp3702 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[][] map1;
        int [][] query1;

        
        readfile read_file = new readfile();
        read_file.openF("exEnv1.txt", "exQueries1.txt");
        read_file.load_file();
        map1 = read_file.get_map();

        search uniform_search = new search(1, 6, 8, map1);
        query1 = read_file.get_query();
        
    }
    
}
