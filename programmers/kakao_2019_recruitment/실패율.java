package practice.programmers.kakao_2019_recruitment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 실패율 {
    // https://programmers.co.kr/learn/courses/30/lessons/42889
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] solution = solution(n, stages);
        for (int s : solution) {
            System.out.print(s + " ");
        }
    }

    private static int[] solution(int stageSize, int[] stages) {
        /*
        실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        전체 스테이지의 개수 stageSize, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
         */
        int[] currentPlayersInStage = new int[stageSize + 1]; // (idx+1) stage에 있는 사용자 수
        int[] allChallengersInStage = new int[stageSize + 1]; // (idx+1) stage에 도전한 사용자 수 = players를 거꾸로 dp
        // stages = {2, 1, 2, 6, 2, 4, 3, 3}
        // currentPlayersInStage
        // 1 2 3 4 5 / 6    stage 번호
        // 1 3 2 1 0 / 1    해당 stage에 있는 사용자 수
        // 8 7 4 2 1 1      allChallengersInStage, dp
        for (int stage : stages) {
            currentPlayersInStage[stage - 1]++;
        }

        allChallengersInStage[stageSize] = currentPlayersInStage[stageSize];
        for (int i = stageSize - 1; i >= 0; i--) {
            allChallengersInStage[i] = allChallengersInStage[i + 1] + currentPlayersInStage[i];
        }

        Map<Integer, Float> failureRates = new HashMap<>();
        for (int i = 0; i < stageSize; i++) {
            if (currentPlayersInStage[i] == 0 || allChallengersInStage[i] == 0) {
                failureRates.put(i + 1, 0F);
                continue;
            }
            failureRates.put(i + 1, (float)currentPlayersInStage[i] / allChallengersInStage[i]);
        }

        List<Map.Entry<Integer, Float>> entries = new LinkedList<>(failureRates.entrySet());
        entries.sort((o1, o2) -> {  // new Comparator<Map.Entry<Integer, Float>>()
            int compareValue = o2.getValue().compareTo(o1.getValue());  // 실패율이 높은 스테이지부터 내림차순 정렬
            if (compareValue == 0) { // 실패율이 같다면
                return o1.getKey().compareTo(o2.getKey());  // key(stage 번호) 작은 것부터 오름차순 정렬
            }
            return compareValue;
        });

        int[] answer = new int[stageSize];
        for (int i = 0; i < stageSize; i++) {
            answer[i] = entries.get(i).getKey();
        }

        return answer;
    }
}
