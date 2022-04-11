package practice.inflearn.section5_stack_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main8_sol {
    public static void main(String[] args) {
        Main8_sol main = new Main8_sol();

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
        Queue<Patient> treatment = new LinkedList<>();
        for (int i = 0; i < patientNumbers; i++) {
            treatment.offer(new Patient(i, waitingList[i]));
        }

        int order = 0;
        boolean isSmaller;

        while (!treatment.isEmpty()) {
            Patient poll = treatment.poll();
            isSmaller = false;
            for (Patient p : treatment) {
                if (poll.risk < p.risk) {
                    isSmaller = true;
                    treatment.offer(poll);
                    break;
                }
            }

            if (isSmaller) {     // 나보다 위험도가 큰 환자가 있으면 대기 순서를 뒤로 미룬다.
                continue;
            }

            order++;    // 위험도가 가장 크면 진료를 본다.
            if (poll.id == targetPatient) {
                break;
            }
        }

        return order;
    }

    static class Patient {
        int id;
        int risk;

        public Patient(int id, int risk) {
            this.id = id;
            this.risk = risk;
        }

        @Override
        public String toString() {
            return "Patient{" +
                    "id=" + id +
                    ", risk=" + risk +
                    '}';
        }
    }
}

