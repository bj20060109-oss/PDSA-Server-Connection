public class ServerConnection {

    private int[] id;
    private boolean[][] requests;
    private int[] sz;
    private int root;               //root as you can see



    //find root 
    public int find(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    //union
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else { id[j] = i; sz[i] += sz[j]; }
    }
    
    public ServerConnection(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++)
            id[i] = i;

        sz = new int[N];
        for(int i = 0; i < N; i++)
            sz[i] = 1;

        requests = new boolean[N][N];

    }

    public void addConnection(int a, int b) {
        if(a != b){
            requests[a][b] = true; //a -> b

        if(requests[b][a] == true){
            union(a,b);
        }
        }
        
    }

    
    public boolean areConnected(int a, int b) {
        if(find(a) == find(b)){
            return true;
        }
        else{
            return false;
        }
    }

    //1
    public int countGroups() {
        int N = id.length;
        boolean[] counted = new boolean[N];
        int groupCount = 0;

        for(int i = 0; i < N; i++){
            root = find(i);
            if(!counted[root]){
                counted[root] = true;
                groupCount++;
            }
        }

        return groupCount;
    }

    //2
    public int getLargestGroupSize() {
        int N = id.length;
        boolean[] counted = new boolean[N];
        int largestGroupSize;
        if(N >0){
            largestGroupSize = 1;
        }
        else {
            largestGroupSize = 0; 
        }

        for(int i = 0; i < N; i++){
            int root = find(i);
            if(!counted[root]){
                counted[root] = true;
                if(largestGroupSize < sz[root]){
                    largestGroupSize = sz[root];
                }
            }   
        }
        return largestGroupSize;
    }

    public static void main(String[] args) {
        // ´ú¸Õ¥Î¨Ò
    }
}
