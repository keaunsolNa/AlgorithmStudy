import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 확장자를 저장하기 위한 리스트
    private static List<String> extensionList = new ArrayList<>();
    // 파일 클래스
    public static class File implements Comparable<File> {

        // 파일의 이름
        String file;
        // 파일의 확장자
        String extension;
        // 확장자 허용 여부
        int inList;

        File(String file, String extension, int inList) {
            this.file = file;
            this.extension = extension;
            this.inList = inList;
        }

        @Override
        public int compareTo(File o) {

            // 파일의 이름이 같다면
            if(o.file.equals(this.file)) {
                // 둘 다 허용된다면
                if(this.inList == o.inList)
                    // 확장자로 오름차순
                    return this.extension.compareTo(o.extension);

                return Integer.compare(o.inList, this.inList);

            }
            return this.file.compareTo(o.file);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 우선순위 큐로 풀이
        PriorityQueue<File> pq = new PriorityQueue<>();
        // 중복 제거를 위한 Set
        HashSet<String> set = new HashSet<>();
        String[] fileArr = new String[n];

        for(int i = 0; i < n; i++) fileArr[i] = br.readLine();

        for(int i = 0; i < m; i++) set.add(br.readLine());

        for(int i = 0; i < n; i++) {

            String file = fileArr[i];
            String name = file.split("[.]")[0];
            String extension = file.split("[.]")[1];

            int inList = set.contains(extension) ? 1 : 0;
            pq.add(new File(name, extension, inList));

        };


        while(!pq.isEmpty()) {

            File file = pq.poll();

            sb.append(file.file).append(".").append(file.extension).append("\n");
        }

        System.out.print(sb);
    }
}