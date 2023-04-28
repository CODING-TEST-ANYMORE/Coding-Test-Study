import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n ; i++) {
            String method = br.readLine();
            int length = Integer.parseInt(br.readLine());
            
            LinkedList<Integer> array = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), "[],");
            
            for(int k = 0; k < length; k++){
                array.offer(Integer.parseInt(st.nextToken()));
            }
          
            boolean isSeq = true;
            boolean isError = false;

            for(int j = 0; j < method.length(); j++) {
                char task = method.charAt(j);
                if(task == 'R') {
                    isSeq = !isSeq;
                    continue;
                } 
                
                if(isSeq) {
                    if(array.isEmpty()){
                        isError = true;
                        break;
                    }
                    array.pollFirst();
                } else { 
                    if(array.isEmpty()){
                        isError = true;
                        break;
                    }
                    array.pollLast();
                }
            }

            if(isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if(array.size() > 0) {
                    if(isSeq) {
                        sb.append(array.pollFirst());
                    
                        while(!array.isEmpty()) {
                            sb.append(',').append(array.pollFirst());
                        }
                    } else { 
                        sb.append(array.pollLast());	
                    
                        while(!array.isEmpty()) {
                            sb.append(',').append(array.pollLast());
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
