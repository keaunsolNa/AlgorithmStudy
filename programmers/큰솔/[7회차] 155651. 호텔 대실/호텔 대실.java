import java.io.*;
import java.util.*;

class Solution {
    
    private static class RoomTime {

        int startTime;
        int endTime;

        public RoomTime(String startTime, String endTime) {

            this.startTime = stringToInt(startTime);
            this.endTime = stringToInt(endTime) + 10;

        }

        private int stringToInt(String time) {

            int hh = Integer.parseInt(time.split(":")[0]) * 60;
            int mm = Integer.parseInt(time.split(":")[1]);
            return hh + mm;
        }
    }
    
    public int solution(String[][] book_time) {
        
        RoomTime[] roomTimes = new RoomTime[book_time.length];
        for(int i = 0; i < book_time.length; i++) 
            roomTimes[i] = new RoomTime(book_time[i][0], book_time[i][1]);
        

        Arrays.sort(roomTimes, ((Comparator.comparingInt(o -> o.startTime))));

        PriorityQueue<RoomTime> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.endTime));

        for(RoomTime RoomTime : roomTimes) {

            if(pq.isEmpty()) pq.add(RoomTime);

            else {

                RoomTime temp = pq.peek();
                int start = temp.startTime;
                int end = temp.endTime;

                if(RoomTime.startTime >= end) pq.poll();

                pq.add(RoomTime);
            }
        }

        return pq.size();
    }
}