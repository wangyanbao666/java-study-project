package com.example.wk4;

import java.util.ArrayList;

public class RobotTest {
    public static void main(String[] args) {
        final int[][] grid = {
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,1},
                {0,1,0,0},
        };
        ArrayList<Point> path = new ArrayList<>();
        boolean success = GetPath.getPath(3, 2,path, grid);
        System.out.println(success);
        if (success) {System.out.println(path);}
        path.clear();
        final int[][] grid2 = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0}
        };
        success = GetPath.getPath(3, 2,path, grid2);
        System.out.println(success);
        if (success) {System.out.println(path);}
        path.clear();
    }
}
