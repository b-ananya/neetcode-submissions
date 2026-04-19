class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;

        int left = 0;
        int right = people.length - 1;

        while (right >= left) {
            if (people[left] + people[right] <= limit) {
                count++;
                right--;
                left++;
            } else {
                count++;
                right--;
            }
        }


        return count;
        
    }
}