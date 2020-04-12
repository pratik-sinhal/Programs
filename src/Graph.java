import java.util.*;

class Graph
{
    int V;
    List<Integer>[] adj;
    int maxDist;
    int maxDistanceVertex;

    public Graph(int V) {
        this.V = V;
        adj = new List[V+1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        Graph g = new Graph(V);
        while(V-- > 1)
            g.addEdge(s.nextInt(),s.nextInt());
        g.longestDistance();
        System.out.println(g.maxDist);
    }

    public void longestDistance() {
        dfs(1);
        dfs(maxDistanceVertex);
    }

    private void dfs(int s) {
        boolean[] visited = new boolean[V+1];
        Arrays.fill(visited, false);
        dfsUtil(s, visited, 1);
    }

    private void dfsUtil(int s, boolean[] visited, int dist) {
        visited[s] = true;
        for (int v: adj[s]){
            if(!visited[v]) {
                dfsUtil(v, visited, dist+1);
                if(dist > maxDist) {
                    maxDist = dist;
                    maxDistanceVertex = v;
                }
            }
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
}