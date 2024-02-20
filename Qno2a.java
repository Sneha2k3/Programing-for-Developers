// 
public class Qno2a{
    public int minMovesToEqualize(int[] machines) {
        int totalDresses = 0;
        int n = machines.length;
        
        for (int dresses : machines) {
            totalDresses += dresses;
        }
        
        if (totalDresses % n != 0) {
            return -1;
        }
        
        int target = totalDresses / n;
        int moves = 0;
        int dressesDiff = 0;
        
        for (int dresses : machines) {
            dressesDiff += dresses - target;
            moves = Math.max(moves, Math.max(Math.abs(dressesDiff), dresses - target));
        }
        
        return moves;
    }
    
    public static void main(String[] args) {
        int[] machines = {2, 1, 3, 0, 2};
        Qno2a manager = new Qno2a();
        System.out.println(manager.minMovesToEqualize(machines));
    }
}
