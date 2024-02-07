import java.io.*;
import java.util.*;

public class Main {

    // 전역 변수 알고리즘 분류, 난이도, 문제 번호
    private static int g, l, p;
    // 문제 정보를 담을 class
    private static class Question implements Comparable<Question> {

        int no;
        int level;
        int g;

        public Question(int no, int level, int g) {

            this.no = no;
            this.level = level;
            this.g = g;
        }

        // 정렬 기준. level 순으로 하되 같다면 문제 번호 순
        @Override
        public int compareTo(Question question) {

            if(this.level == question.level) {
                return Integer.compare(no, question.no);
            }
            return Integer.compare(level, question.level);
        }
    }

    // 문제를 담을 TreeSet
    private static TreeSet<Question> tree;
    // recommend의 종류에 따라 가장 앞이나 뒤의 요소를 꺼내오기 위한 List
    private static List<TreeSet<Question>> listTree;
    // remove 시 문제의 번호로 알고리즘 분류를 가져오기 위한 Map
    private static HashMap<Integer, int[]> hMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        tree = new TreeSet<>();
        listTree = new ArrayList<>();
        hMap = new HashMap<>();

        for(int i = 0; i <= 100; i++) listTree.add(new TreeSet<>());

        // 초기 문제 insert
        while(n --> 0) {

            st = new StringTokenizer(br.readLine());

            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            add();

        }

        int m = Integer.parseInt(br.readLine());

        while(m --> 0) {

            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            int x;

            // 명령 종류에 따른 switch
            switch (order) {

                // add일 경우에는 메서드 실행
                case "add" -> {

                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    g = Integer.parseInt(st.nextToken());
                    add();

                }

                case "recommend" -> {

                    g = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());

                    // x == 1이라면 List의 가장 마지막 요소를 가져와 붙인다.
                    if(x == 1) sb.append(listTree.get(g).last().no).append("\n");
                    // -1이면 List의 가장 앞 요소
                    else sb.append(listTree.get(g).first().no).append("\n");

                }

                case "recommend2" -> {

                    x = Integer.parseInt(st.nextToken());

                    // x == 1 이면 treeSet의 마지막 요소 붙이기
                    if(x == 1) sb.append(tree.last().no).append("\n");
                    // x == -1 이면 treeSet의 가장 앞 요소
                    else sb.append(tree.first().no).append("\n");

                }

                case "recommend3" -> {

                    x = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());
                    if (x == 1) {

                        // tree의 ceiling (주어진 요소보다 크거나 같은 최소 요소 반환) 메서드를 활용한다.
                        if (tree.ceiling(new Question(0, l, 0)) == null) sb.append("-1\n");
                        else sb.append(Objects.requireNonNull(tree.ceiling(new Question(0, l, 0))).no).append("\n");

                    } else {

                        // tree의 ceiling (주어진 요소보다 크거나 같은 최소 요소 반환) 메서드를 활용한다.
                        if (tree.lower(new Question(0, l, 0)) == null) sb.append("-1\n");
                        else sb.append(Objects.requireNonNull(tree.lower(new Question(0, l, 0))).no).append("\n");

                    }
                }

                case "solved" -> {

                    p = Integer.parseInt(st.nextToken());

                    // hMap을 통해 level과 group를 가져온다.
                    if (!hMap.containsKey(p)) continue;;

                    l = hMap.get(p)[0];
                    g = hMap.get(p)[1];

                    // hMap, tree, listTree 모두에서 요소 삭제
                    hMap.remove(p);
                    tree.remove(new Question(p, l, g));
                    listTree.get(g).remove(new Question(p, l, g));
                }
            }
        }

        System.out.println(sb);

    }

    private static void add() {
        listTree.get(g).add(new Question(p, l, g));
        tree.add(new Question(p, l, g));
        hMap.put(p, new int[] {l, g});
    }
}