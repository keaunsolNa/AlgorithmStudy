import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //센서 개수
        int sensor = Integer.parseInt(br.readLine());
        //집중국 개수
        int concentrate = Integer.parseInt(br.readLine());

        //센서 좌표 배열
        int[] sensorArray = new int[sensor];
        st = new StringTokenizer(br.readLine());
        
        //센서 좌표 배열 생성
        for (int i=0; i<sensor; i++){
            sensorArray[i] = Integer.parseInt(st.nextToken());
        }
        
        //센서 좌표 배열 오름차순 정렬
        Arrays.sort(sensorArray);

        //센서 좌표 차이 배열
        int[] sensorDiffArray = new int[sensor-1];

        //센서 좌표 차이 배열 생성
        for (int j=0; j<sensor-1; j++){
            sensorDiffArray[j] = sensorArray[j+1] - sensorArray[j];
        }

        //센서 좌표 차이 배열 오름차순 정렬
        Arrays.sort(sensorDiffArray);
        
        //집중국의 수신 가능 영역의 길이의 합의 최솟값
        int totalSensor = 0;
        
        //센서 좌표 차이 배열중 큰 값 (집중국의 수 - 1)을 제외한 합
        for (int k=0; k<(sensor-1)-(concentrate-1); k++){
            totalSensor += sensorDiffArray[k];
        }
        
        System.out.print(totalSensor);
    }
}