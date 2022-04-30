class Solution {
    
    Map<String, Map<String, Double>> graph = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        generateGraph(equations, values);
        double[] results = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                results[i] = -1.0;
            }
            else if(dividend == divisor){
                results[i] = 1.0;
            }
            else {
              results[i] = DFS(dividend, divisor, new HashSet<>());  
            }
        }
        return results;
    }
    public void generateGraph(List<List<String>> equations, double[] values){
        for(int i=0; i<equations.size(); i++){
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            Double ratio = values[i];
            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, ratio);
            graph.putIfAbsent(end, new HashMap<>());
            graph.get(end).put(start, 1.0 / ratio);
        }
    }

    public double DFS(String currNode, String targetNode, HashSet<String> visited){
        if(visited.contains(currNode)){
            return -1;
        }
        if(graph.get(currNode).containsKey(targetNode)){
            return graph.get(currNode).get(targetNode);
        }
        
        visited.add(currNode);
        for(String adj : graph.get(currNode).keySet()){
            double accumlitiveProduct = DFS(adj, targetNode, visited);
            if(accumlitiveProduct != -1){
                return accumlitiveProduct * graph.get(currNode).get(adj);
            }
        }
        return -1;
    }
}