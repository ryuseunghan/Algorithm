import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            boolean assigned = false;

            // 1. 단어의 첫 글자에 단축키 할당 시도
            for (int j = 0; j < words.length; j++) {
                char key = Character.toUpperCase(words[j].charAt(0));
                if (!used.contains(key)) {
                    used.add(key);
                    for (int k = 0; k < words.length; k++) {
                        if (k == j)
                            System.out.print("[" + words[k].charAt(0) + "]" + words[k].substring(1) + " ");
                        else
                            System.out.print(words[k] + " ");
                    }
                    System.out.println();
                    assigned = true;
                    break;
                }
            }

            if (assigned) continue;

            // 2. 전체 문장에서 가능한 단축키 탐색
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c != ' ' && !used.contains(Character.toUpperCase(c))) {
                    used.add(Character.toUpperCase(c));
                    System.out.println(line.substring(0, j) + "[" + c + "]" + line.substring(j + 1));
                    assigned = true;
                    break;
                }
            }

            if (!assigned)
                System.out.println(line);
        }
    }
}
