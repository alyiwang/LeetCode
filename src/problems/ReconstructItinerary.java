package problems;

import java.util.*;

/**
 * Leetcode: Reconstruct Itinerary
 * Created by alan on 2/23/2016.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> m = new HashMap<>();
        for (String[] ticket : tickets) {
            if (m.containsKey(ticket[0]))
                m.get(ticket[0]).add(ticket[1]);
            else {
                final List<String> ls = new ArrayList<>();
                ls.add(ticket[1]);
                m.put(ticket[0], ls);
            }
        }
        for (String s : m.keySet())
            Collections.sort(m.get(s));
        //System.out.println(Arrays.toString(m.entrySet().toArray()));

        return find(m, "JFK", tickets.length);
    }

    public List<String> find(Map<String, List<String>> m, String start, int count) {
        List<String> it = new ArrayList<>();
        it.add(start);
        if (count == 0 || !m.containsKey(start))
            return it;

        for (int i = 0; i < m.get(start).size(); i++) {
            String s = m.get(start).remove(i);
            List<String> next = find(m, s, count - 1);
            if (next.size() == count) {
                it.addAll(next);
                return it;
            }
            m.get(start).add(i, s); // put s back in order
        }
        return it;
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        //String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};

        System.out.println(Arrays.deepToString(tickets));
        System.out.println(ri.findItinerary(tickets));
    }
}
