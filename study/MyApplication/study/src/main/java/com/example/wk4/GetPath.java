package com.example.wk4;

import java.util.ArrayList;

public class GetPath {

    //Fill in your answer for this method
    public static boolean getPath (int r, int c, ArrayList<Point> path, final int [][] grid) {
        path.add(new Point(0,0));
        return find(0,0,path,grid,r,c);
    }

    public static boolean find(int ri, int ci, ArrayList<Point> path, final int [][] grid, int rg, int cg){
        // base case
        if (ri==rg && ci==cg) {
            if (grid[ri][ci]!=1){
                return true;
            }
            else {
                return false;
            }
        }
        // recursive
        else {
            if (grid[ri][ci]!=1){
                boolean result1 = false;
                boolean result2 = false;
                if (ri<rg){
                    int new_ri=ri+1;
                    path.add(new Point(new_ri,ci));
                    result1 = find(new_ri,ci,path,grid,rg,cg);
                    if (result1 == true) {
                        return true;
                    }
                    path.remove(path.size()-1);
                }
                if (ci<cg){
                    int new_ci=ci+1;
                    path.add(new Point(ri,new_ci));
                    result2 = find(ri,new_ci,path,grid,rg,cg);
                    if (result2 == true) {
                        return true;
                    }
                    path.remove(path.size()-1);
                }
                return false;
            }
            return false;
        }
    }
}

//You do not need to change any code below ---------
class Point {
    int x;
    int y;

    Point (int x, int y) {
        this.x=x;
        this.y=y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}