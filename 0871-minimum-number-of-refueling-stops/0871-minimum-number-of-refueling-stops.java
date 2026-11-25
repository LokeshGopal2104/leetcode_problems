
class Solution {
    // public int minRefuelStops(int target, int startFuel, int[][] stations) {
    //     int ans = solve(0, 0, target, startFuel, stations);

    //     return ans == Integer.MAX_VALUE ? -1 : ans;
    // }


    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // Max Heap to store fuel from previously passed stations
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int currentFuel = startFuel;
        int currentPosition = 0;
        int stops = 0;

        for (int i = 0; i < stations.length; i++) {

            int distance = stations[i][0] - currentPosition;

            // Refuel until we can reach the current station
            while (currentFuel < distance) {

                if (pq.isEmpty()) {
                    return -1;
                }

                currentFuel += pq.poll();
                stops++;
            }

            // We have reached the station
            currentFuel -= distance;
            currentPosition = stations[i][0];

            // Store this station's fuel for possible future use
            pq.offer(stations[i][1]);
        }

        // Refuel until we can reach the target
        int remainingDistance = target - currentPosition;

        while (currentFuel < remainingDistance) {

            if (pq.isEmpty()) {
                return -1;
            }

            currentFuel += pq.poll();
            stops++;
        }

        return stops;
    }



    public int solve(int index, int currentPosition, int target,
                     int remainingFuel, int[][] stations) {

        // Base case: Destination is reachable
        if (currentPosition + remainingFuel >= target) {
            return 0;
        }

        // No more stations available
        if (index == stations.length) {
            return Integer.MAX_VALUE;
        }

        // Distance required to reach the current station
        int distance = stations[index][0] - currentPosition;

        // Cannot reach this station
        if (remainingFuel < distance) {
            return Integer.MAX_VALUE;
        }

        // Fuel remaining after reaching the station
        int fuelAfterTravel = remainingFuel - distance;

        // Choice 1: Skip refueling
        int skip = solve(
            index + 1,
            stations[index][0],
            target,
            fuelAfterTravel,
            stations
        );

        // Choice 2: Refuel
        int next = solve(
            index + 1,
            stations[index][0],
            target,
            fuelAfterTravel + stations[index][1],
            stations
        );

        // Prevent integer overflow
        int refuel = next == Integer.MAX_VALUE
                     ? Integer.MAX_VALUE
                     : 1 + next;

        return Math.min(skip, refuel);
    }
}
