// l the possible secretsharing intervals have occurred
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Qno2b {

    public static List<Integer> determineKnownPersons(int totalPersons, int[][] sharingIntervals, int startingPerson) {
        Set<Integer> knownPersonsSet = new HashSet<>();
        knownPersonsSet.add(startingPerson);

        for (int[] interval : sharingIntervals) {
            int intervalStart = interval[0];
            int intervalEnd = interval[1];
            for (int personId = intervalStart; personId <= intervalEnd; personId++) {
                if (personId < totalPersons) { 
                    knownPersonsSet.add(personId);
                }
            }
        }

        List<Integer> knownPersonsList = new ArrayList<>(knownPersonsSet);
        knownPersonsList.sort(null);
        return knownPersonsList;
    }

    public static void main(String[] args) {
        int totalPersons = 5;
        int[][] sharingIntervals = { { 0, 2 }, { 1, 3 }, { 2, 4 } };
        int startingPerson = 0;

        List<Integer> knownPersons = determineKnownPersons(totalPersons, sharingIntervals, startingPerson);
        System.out.println("Set of individuals who know the secret is " + knownPersons);
    }
}
