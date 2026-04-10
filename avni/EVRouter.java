import java.util.*;

class EVRouter {

       static class Edge {
        int dest;
        int dist;

        Edge(int d, int w) {
            dest = d;
            dist = w;
        }
    }

        static class NodeState {
        int node;
        int distance;
        int battery;

        NodeState(int n, int d, int b) {
            node = n;
            distance = d;
            battery = b;
        }
    }

    public static void main(String[] args) {

        int n = 5;

        
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        
        graph.get(0).add(new Edge(1, 4));
        graph.get(1).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(3).add(new Edge(2, 2));
        graph.get(2).add(new Edge(4, 3));

   
        Set<Integer> charge = new HashSet<>();
        charge.add(3);

        int start = 0;
        int end = 4;
        int maxBattery = 10;
        int startBattery = 2;

        solve(graph, charge, start, end, maxBattery, startBattery);
    }

    public static void solve(List<List<Edge>> graph, Set<Integer> charge,
                             int start, int end, int maxBattery, int startBattery) {

        int n = graph.size();

        PriorityQueue<NodeState> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
        );

        int[][] visited = new int[n][maxBattery + 1];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new NodeState(start, 0, startBattery));
        visited[start][startBattery] = 0;

        Map<String, String> parent = new HashMap<>();

        while (!pq.isEmpty()) {
            NodeState curr = pq.poll();

            int node = curr.node;
            int dist = curr.distance;
            int battery = curr.battery;

                       if (node == end) {
                printResult(parent, charge, end, battery, dist);
                return;
            }

                       if (charge.contains(node)) {
                battery = maxBattery;
            }

                        for (Edge e : graph.get(node)) {

                if (battery >= e.dist) {

                    int newBattery = battery - e.dist;
                    int newDist = dist + e.dist;

                    if (visited[e.dest][newBattery] > newDist) {
                        visited[e.dest][newBattery] = newDist;

                        pq.add(new NodeState(e.dest, newDist, newBattery));

                        parent.put(e.dest + "," + newBattery,
                                   node + "," + battery);
                    }
                }
            }
        }

        System.out.println("No feasible path found");
    }

        public static void printResult(Map<String, String> parent,
                                   Set<Integer> charge,
                                   int end, int battery, int totalDist) {

        List<Integer> path = new ArrayList<>();
        List<Integer> stops = new ArrayList<>();

        String curr = end + "," + battery;

        while (curr != null) {
            String[] parts = curr.split(",");
            int node = Integer.parseInt(parts[0]);

            path.add(node);

            if (charge.contains(node)) {
                stops.add(node);
            }

            curr = parent.get(curr);
        }

        Collections.reverse(path);
        Collections.reverse(stops);

        System.out.println("Optimal Path: " + path);
        System.out.println("Charging Stops: " + stops);
        System.out.println("Total Distance: " + totalDist);
        System.out.println("Status: SUCCESS - Feasible EV Route Found");
    }
}