import java.io.*;

public class 거북이 {
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    //북쪽 0 -> 1 
    //동쪽 1 -> 2 
    //서쪽 3 -> 0 
    //남쪽 2 -> 3
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int direction = 0, currentX = 0, currentY = 0, minX = 0, minY = 0, maxX = 0, maxY = 0;
            String commands = br.readLine();

            for(int j = 0; j < commands.length(); j++) {
                char command = commands.charAt(j);
                
                switch(command) {
                    case 'L': {
                        if(direction == 0) direction = 3;
                        else direction--;
                        break;
                    }
                    case 'R': {
                        if(direction == 3) direction = 0;
                        else direction++;
                        break;
                    }
                    case 'F': {
                        currentX = currentX + dx[direction];
                        currentY = currentY + dy[direction];
                        break;
                    }
                    case 'B': {
                        currentX = currentX - dx[direction];
                        currentY = currentY - dy[direction];
                        break;
                    }
                }

                minX = Math.min(minX, currentX);
                minY = Math.min(minY, currentY);
                maxX = Math.max(maxX, currentX);
                maxY = Math.max(maxY, currentY);
            }
            sb.append((Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY)) + "\n");
        }

        System.out.println(sb.toString());
    }
}
