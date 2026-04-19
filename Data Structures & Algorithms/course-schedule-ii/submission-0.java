class Solution {

    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] order;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        order = new int[numCourses];
        index = 0;

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, new HashSet<>())) {
                return new int[0];
            }
        }

        return order;
        
    }

    private boolean dfs(int course, Set<Integer> visiting) {
        if (visiting.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        visiting.add(course);
        for (int i = 0; i < graph.get(course).size(); i++) {
            if(!dfs(graph.get(course).get(i), visiting)) {
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);
        order[index] = course;
        index++;
        return true;
    }
}
