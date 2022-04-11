package practice.inflearn.section5_stack_queue;

import java.util.Scanner;

public class Main8_오답 {
    public static void main(String[] args) {
        Main8_오답 main = new Main8_오답();

        Scanner in = new Scanner(System.in);
        int patientNumbers = in.nextInt();
        int targetPatient = in.nextInt();
        int[] waitingList = new int[patientNumbers];
        for (int i = 0; i < patientNumbers; i++) {
            waitingList[i] = in.nextInt();
        }

        int solution = main.solution(patientNumbers, targetPatient, waitingList);
        System.out.println(solution);
    }

    public static int solution(int patientNumbers, int targetPatient, int[] waitingList) {
        // 나보다 높은 위험도를 가진 사람들의 수 + 내 앞에 있는 나와 같은 위험도를 가진 사람들 수 + 1(내 순서)
        int higherRiskNumbers = 0;
        int sameRiskNumbers = 0;
        int myRisk = waitingList[targetPatient];

        for (int i = 0; i < patientNumbers; i++) {
            if (i < targetPatient && waitingList[i] == myRisk) {
                sameRiskNumbers++;
            }
            if (waitingList[i] > myRisk) {
                higherRiskNumbers++;
            }
        }

        return higherRiskNumbers + sameRiskNumbers + 1;
    }
}
