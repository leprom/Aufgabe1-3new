import java.util.*;

public class Graph {

    // Edge object that is stored for each connection to another node
    public class Edge {
        private TrafficPoint v;
        private int w;
        private int passengers;

        public TrafficPoint getV() {
            return v;
        }

        public int getPassengers() {
            return passengers;
        }

        public void setPassengers(int passangers) {
            this.passengers = passangers;
        }

        public Edge(TrafficPoint v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "(" + v.toString() + "," + w + ")";
        }
    }

    // An array of lists of Edge objects
    private List<Edge> G[]; //graph only initalized

    public List<Edge>[] getG() {
        return G;
    }

    private LinkedList<TrafficPoint> V;


    // Parameterized constructor
    public Graph(int n) {

        G = new LinkedList[n];

        // For each node in the graph, initialize an empty adjacency list
        for (int i = 0; i < G.length; i++) {
            G[i] = new LinkedList<Edge>();
        }

        V = new LinkedList<TrafficPoint>();
    }

    public Graph() {
        G = new LinkedList[16];
        for (int i = 0; i < G.length; i++) {
            G[i] = new LinkedList<Edge>();
        }
        V = new LinkedList<TrafficPoint>();
    }

    // Check if node U is connected to node V
    public boolean isConnected(TrafficPoint u, TrafficPoint v) {

        // Check each edge for this node to see if it connects to node V
        for (Edge i : G[u.getId()]) {
            if (i.v == v) return true;
        }
        return false;
    }

    // For node U, add a new connection to node V, with weight W
    public void addEdge(TrafficPoint u, TrafficPoint v, int w) {
        G[u.getId()].add(new Edge(v, w));
        G[v.getId()].add(new Edge(u, w));
        if(V==null){
            V.add(u);
            V.add(v);
        } else {
            if(!V.contains(u)) V.add(u);
            if(!V.contains(v)) V.add(v);
        }
    }

    public Edge getEdge(int node1, int node2) {
        int i;
        for (i = 0; i < G[node1].size(); i++) {
            if(G[node1].get(i).v.getId() == node2)
                break;
        }
        return G[node1].get(i);
    }

    public int[][] getMatrix(){
        int [][] matrix = new int[16][16];

        V.sort(new Comparator<TrafficPoint>() {
            @Override
            public int compare(TrafficPoint o1, TrafficPoint o2) {
                return o1.getId() - o2.getId();
            }
        });

       for (int i = 0; i < V.size(); i++) {
           for (int j = 0; j < V.size(); j++) {
               if(this.isConnected(V.get(i),V.get(j))) {
                   matrix[i][j] = 1;
                   matrix[j][i] = 1;

               } else {
                   matrix[i][j] = 0;
                   matrix[j][i] = 0;
               }
           }
       }
       return matrix;
    }

    public void printMatrix(){
        int [][] matrix = this.getMatrix();

        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < V.size(); i++) {
            System.out.print(" " + V.get(i));
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(V.get(i)+" ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Override the java default toString() method so we can print
    // our Graph in the format we want
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < G.length; i++)
            result += i +"("+(char)(i + 65) +")" + "=>" + G[i] +"\n";
        return result;
    }


    public static Graph createGraph(int trafficVariation) {
        Graph g1 = new Graph(16);
        if (trafficVariation == 1) {
            TrafficPoint A = new TrafficPoint('A', false);
            TrafficPoint B = new TrafficPoint('B', true);
            TrafficPoint C = new TrafficPoint('C', false);
            TrafficPoint D = new TrafficPoint('D', true);
            TrafficPoint E = new TrafficPoint('E', false);
            TrafficPoint F = new TrafficPoint('F', false);
            TrafficPoint G = new TrafficPoint('G', true);
            TrafficPoint H = new TrafficPoint('H', false);
            TrafficPoint I = new TrafficPoint('I', false);
            TrafficPoint J = new TrafficPoint('J', false);
            TrafficPoint K = new TrafficPoint('K', false);
            TrafficPoint L = new TrafficPoint('L', false);
            TrafficPoint M = new TrafficPoint('M', false);
            TrafficPoint N = new TrafficPoint('N', false);
            TrafficPoint O = new TrafficPoint('O', false);
            TrafficPoint P = new TrafficPoint('P', false);
            g1.addEdge(A, B, 1);
            g1.addEdge(B, C, 1);
            g1.addEdge(C, D, 1);
            g1.addEdge(D, E, 1);
            g1.addEdge(E, F, 1);
            g1.addEdge(F, G, 1);
            g1.addEdge(G, H, 1);
            g1.addEdge(O, P, 1);
            g1.addEdge(P, D, 1);
            g1.addEdge(D, I, 1);
            g1.addEdge(I, G, 1);
            g1.addEdge(N, B, 1);
            g1.addEdge(B, J, 1);
            g1.addEdge(J, K, 1);
            g1.addEdge(K, L, 1);
            g1.addEdge(L, M, 1);
        } else if (trafficVariation == 2) {
            TrafficPoint A = new TrafficPoint('A', true);
            TrafficPoint B = new TrafficPoint('B', false);
            TrafficPoint C = new TrafficPoint('C', false);
            TrafficPoint D = new TrafficPoint('D', false);
            TrafficPoint E = new TrafficPoint('E', false);
            TrafficPoint F = new TrafficPoint('F', true);
            TrafficPoint G = new TrafficPoint('G', true);
            TrafficPoint H = new TrafficPoint('H', false);
            TrafficPoint I = new TrafficPoint('I', false);
            TrafficPoint J = new TrafficPoint('J', false);
            TrafficPoint K = new TrafficPoint('K', false);
            TrafficPoint L = new TrafficPoint('L', false);
            TrafficPoint M = new TrafficPoint('M', false);
            TrafficPoint N = new TrafficPoint('N', false);
            TrafficPoint O = new TrafficPoint('O', false);
            TrafficPoint P = new TrafficPoint('P', false);
            g1.addEdge(A, B, 1);
            g1.addEdge(B, C, 1);
            g1.addEdge(C, D, 1);
            g1.addEdge(D, E, 1);
            g1.addEdge(E, F, 1);
            g1.addEdge(F, G, 1);
            g1.addEdge(G, H, 1);
            g1.addEdge(H, A, 1);
            g1.addEdge(J, A, 1);
            g1.addEdge(A, I, 1);
            g1.addEdge(I, E, 1);
            g1.addEdge(E, K, 1);
            g1.addEdge(K, L, 1);
            g1.addEdge(P, G, 1);
            g1.addEdge(G, M, 1);
            g1.addEdge(M, N, 1);
            g1.addEdge(N, O, 1);
        } else if (trafficVariation == 3) {
            TrafficPoint A = new TrafficPoint('A', false);
            TrafficPoint B = new TrafficPoint('B', true);
            TrafficPoint C = new TrafficPoint('C', false);
            TrafficPoint D = new TrafficPoint('D', false);
            TrafficPoint E = new TrafficPoint('E', false);
            TrafficPoint F = new TrafficPoint('F', false);
            TrafficPoint G = new TrafficPoint('G', true);
            TrafficPoint H = new TrafficPoint('H', false);
            TrafficPoint I = new TrafficPoint('I', false);
            TrafficPoint J = new TrafficPoint('J', false);
            TrafficPoint K = new TrafficPoint('K', true);
            TrafficPoint L = new TrafficPoint('L', false);
            TrafficPoint M = new TrafficPoint('M', false);
            TrafficPoint N = new TrafficPoint('N', false);
            TrafficPoint O = new TrafficPoint('O', false);
            TrafficPoint P = new TrafficPoint('P', false);
            g1.addEdge(A, B, 1);
            g1.addEdge(B, C, 1);
            g1.addEdge(C, D, 1);
            g1.addEdge(D, E, 1);
            g1.addEdge(E, F, 1);
            g1.addEdge(B, M, 1);
            g1.addEdge(M, N, 1);
            g1.addEdge(N, O, 1);
            g1.addEdge(O, P, 1);
            g1.addEdge(P, K, 1);
            g1.addEdge(G, H, 1);
            g1.addEdge(H, I, 1);
            g1.addEdge(I, J, 1);
            g1.addEdge(J, K, 1);
            g1.addEdge(K, L, 1);
        }
        return g1;
    }

}

    class GraphExample {

        public static void main(String[] args) {

            TrafficPoint A = new TrafficPoint('A', false);
            TrafficPoint B = new TrafficPoint('B', true);
            TrafficPoint C = new TrafficPoint('C', false);
            TrafficPoint D = new TrafficPoint('D', true);
            TrafficPoint E = new TrafficPoint('E', false);
            TrafficPoint F = new TrafficPoint('F', false);
            TrafficPoint G = new TrafficPoint('G', true);
            TrafficPoint H = new TrafficPoint('H', false);
            TrafficPoint I = new TrafficPoint('I', false);
            TrafficPoint J = new TrafficPoint('J', false);
            TrafficPoint K = new TrafficPoint('K', false);
            TrafficPoint L = new TrafficPoint('L', false);
            TrafficPoint M = new TrafficPoint('M', false);
            TrafficPoint N = new TrafficPoint('N', false);
            TrafficPoint O = new TrafficPoint('O', false);
            TrafficPoint P = new TrafficPoint('P', false);

            Graph g1 = new Graph(16);
            g1.addEdge(A, B, 1);
            g1.addEdge(B, C, 1);
            g1.addEdge(C, D, 1);
            g1.addEdge(D, E, 1);
            g1.addEdge(E, F, 1);
            g1.addEdge(F, G, 1);
            g1.addEdge(G, H, 1);
            g1.addEdge(O, P, 1);
            g1.addEdge(P, D, 1);
            g1.addEdge(D, I, 1);
            g1.addEdge(I, G, 1);
            g1.addEdge(N, B, 1);
            g1.addEdge(B, J, 1);
            g1.addEdge(J, K, 1);
            g1.addEdge(K, L, 1);
            g1.addEdge(L, M, 1);

            System.out.println(g1.toString());
            System.out.println(g1.isConnected(A,B));

            g1.printMatrix();

            Graph.Edge test = g1.getEdge(2, 3);
            System.out.println(test);
        }
    }
