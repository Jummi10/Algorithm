package practice.programmers.kakao_2019_recruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율_refactor {
    // https://programmers.co.kr/learn/courses/30/lessons/42889

    static class FailureRate implements Comparable<FailureRate> {
        private final int stageNumber;
        private final float rate;

        FailureRate(int stageNumber, float rate) {
            this.stageNumber = stageNumber;
            this.rate = rate;
        }

        @Override
        public int compareTo(FailureRate o) {
            float compareFailureRate = o.rate - rate; // 내림차순
            if (compareFailureRate > 0) {
                return 1;
            } else if (compareFailureRate < 0) {
                return -1;
            }
            return stageNumber - o.stageNumber; // 실패율이 같다면 스테이지 번호 기준 오름차순
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};    // 3 4 2 1 5
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
        initialize(currentPlayersInStage, allChallengersInStage, stageSize, stages);

        List<FailureRate> failureRates = new ArrayList<>();
        calculateFailureRates(failureRates, currentPlayersInStage, allChallengersInStage, stageSize);
        Collections.sort(failureRates);

        int[] answer = new int[stageSize];
        for (int i = 0; i < stageSize; i++) {
            answer[i] = failureRates.get(i).stageNumber;
        }

        return answer;
    }

    private static void initialize(int[] currentPlayersInStage, int[] allChallengersInStage, int stageSize,
        int[] stages) {
        for (int stage : stages) {
            currentPlayersInStage[stage - 1]++;
        }

        allChallengersInStage[stageSize] = currentPlayersInStage[stageSize];
        for (int i = stageSize - 1; i >= 0; i--) {
            allChallengersInStage[i] = allChallengersInStage[i + 1] + currentPlayersInStage[i];
        }
    }

    private static void calculateFailureRates(List<FailureRate> failureRates, int[] currentPlayersInStage,
        int[] allChallengersInStage, int stageSize) {
        for (int i = 0; i < stageSize; i++) {
            if (currentPlayersInStage[i] == 0 || allChallengersInStage[i] == 0) {
                failureRates.add(new FailureRate(i + 1, 0F));
                continue;
            }
            failureRates.add(new FailureRate(i + 1, (float)currentPlayersInStage[i] / allChallengersInStage[i]));
        }
    }
}
