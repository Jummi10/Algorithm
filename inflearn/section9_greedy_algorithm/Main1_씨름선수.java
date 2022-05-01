package practice.inflearn.section9_greedy_algorithm;

import java.util.Scanner;

public class Main1_씨름선수 {
    public static void main(String[] args) {
        Main1_씨름선수 main = new Main1_씨름선수();

        Scanner in = new Scanner(System.in);
        int applicantCount = in.nextInt();
        Applicant[] applicants = new Applicant[applicantCount];
        for (int i = 0; i < applicantCount; i++) {
            applicants[i] = new Applicant(in.nextInt(), in.nextInt());
        }

        int solution = main.solution(applicantCount, applicants);
        System.out.println(solution);
    }

    public static int solution(int applicantCount, Applicant[] applicants) {
        int count = 0;
        boolean canBeAthlete;
        for (Applicant applicant : applicants) {
            canBeAthlete = true;
            for (Applicant otherApplicant : applicants) {
                if (applicant == otherApplicant) {
                    continue;
                }
                if (applicant.height < otherApplicant.height && applicant.weight < otherApplicant.weight) {
                    canBeAthlete = false;
                    break;
                }
            }

            if (canBeAthlete) {
                count++;
            }
        }

        return count;
    }

    static class Applicant {
        private final int height;
        private final int weight;

        public Applicant(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
