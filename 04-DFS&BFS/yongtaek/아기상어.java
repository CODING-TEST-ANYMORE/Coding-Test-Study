import java.io.*;
import java.util.*;

public class 아기상어 {
    static int graph[][];
    static int[] moveX = {-1, 1, 0 ,0};
    static int[] moveY = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static int sharkSize = 2;
    static int eat = 0;
    static int time = 0;
    static int n;

    public static class Point{
        int x,y,dist;

        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void eat() {
        while(true) {
            LinkedList<Point> fish = new LinkedList<>();
            int[][] distance = new int[n][n];

            while(!queue.isEmpty()) {
                Point pointData = queue.poll();
    
                int currX = pointData.x;
                int currY = pointData.y;
    
                for(int i = 0; i < 4; i++) {
                    int newX = currX + moveX[i];
                    int newY = currY + moveY[i];
    
                    if(newX <= -1 || newY <= -1 || newX >= n || newY >= n) {
                        continue;
                    }
    
                    distance[newX][newY] = distance[currX][currY] + 1;
                    queue.add(new Point(newX, newY, distance[newX][newY]));
                    if(graph[newX][newY] != 0 && graph[newX][newY] < sharkSize) {
                        fish.add(new Point(newX, newY, distance[newX][newY]));
                    }
                }
            }

            if(fish.size() == 0) {
                System.out.println(time);
                return;
            }

            Point currentFish = fish.get(0);
            for(int i = 1; i < fish.size(); i++){
                if(currentFish.dist > fish.get(i).dist) {
                    currentFish = fish.get(i);
                }
                else if(currentFish.dist == fish.get(i).dist) {
                    if(currentFish.x > fish.get(i).x) currentFish = fish.get(i);
                    else if(currentFish.x == fish.get(i).x){
                        if(currentFish.y > fish.get(i).y) currentFish = fish.get(i);   
                    }
                }   
            }
             
            time += currentFish.dist;
            eat++;
            graph[currentFish.x][currentFish.y] = 0;
            if(eat == sharkSize) {
                sharkSize++;
                eat = 0;
            }
            queue.add(new Point(currentFish.x, currentFish.y, 0));
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int tileValue = Integer.parseInt(st.nextToken());

                if(tileValue == 9) {
                    queue.add(new Point(i,j,0));
                    graph[i][j] = 0;
                    continue;
                }

                graph[i][j] = tileValue;
            }
        }

        eat();
    }
}
