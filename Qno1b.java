// building engines in min time
import java.util.PriorityQueue;
public class Qno1b {
    


    public static int calculateMinTimeToBuildEngines(int[] engineTimes, int splitConstructionCost) {
        int totalTime = 0;
        int availableEngineers = 1;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap, [time, engineerCount]

        for (int time : engineTimes) {
            heap.offer(new int[]{time, 1});
        }

        while (!heap.isEmpty()) {
            int[] engineInfo = heap.poll();
            int time = engineInfo[0];
            int engineerCount = engineInfo[1];
            totalTime = Math.max(totalTime, time);

            if (engineerCount > availableEngineers) {
                int splitTime = splitConstructionCost * (engineerCount - availableEngineers);
                totalTime += splitTime;
                availableEngineers += engineerCount - availableEngineers;
            }

            availableEngineers -= engineerCount;
            if (availableEngineers < 1) {
                totalTime += splitConstructionCost;
                availableEngineers += 1;
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int[] engineTimes = {1,2,3};
        int splitConstructionCost = 1;
        System.out.println("Minimum Time to Build All Engines is " + calculateMinTimeToBuildEngines(engineTimes, splitConstructionCost)); // Output: 4
    }
}


