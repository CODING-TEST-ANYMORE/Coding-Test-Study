// 프로그래머스 - 타겟 넘버
class Solution {
    int answer = 0;
    void dfs(int[] numbers, int target, int depth, int curr) {
        if(depth == numbers.length - 1) {
            int x = curr + numbers[depth];
            int y = curr - numbers[depth];
            if (x == target) answer++;
            if (y == target) answer++;
            return;
        } else {
            int x = curr + numbers[depth];
            int y = curr - numbers[depth];
            dfs(numbers, target, depth + 1, x);
            dfs(numbers, target, depth + 1, y);
        }
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}