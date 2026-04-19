class Solution {

    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i)) {
                return false;
            }
        }

        return true;

    }

    private boolean canFinish(int course) {
        if (visited.contains(course)) {
            return false;
        }

        if(graph.get(course).size() == 0) {
            return true;
        }

        visited.add(course);
        for (int i = 0; i < graph.get(course).size(); i++) {

            if (!canFinish(graph.get(course).get(i))) {
                return false;
            }
        }
        visited.remove(course);
        graph.put(course, new ArrayList<>()); // cleared prereqs required for this course

        return true;
    }
}
