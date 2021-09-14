package practice.programmers.kakao_2019_recruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    /*
    https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
    level 2
     */
    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";
    private static final String BLANK = " ";
    private static final String ENTER_STATEMENT = "님이 들어왔습니다.";
    private static final String LEAVE_STATEMENT = "님이 나갔습니다.";

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
            "Change uid4567 Ryan"};
        String[] solution = solution(record);
        for (String result : solution) {
            System.out.println(result);
        }
    }

    private static String[] solution(String[] records) {
        Map<String, String> users = new HashMap<>();    // id : nickname
        List<String[]> orders = new ArrayList<>(); // 들어왔다 나간 id 순서

        for (String record : records) {
            String[] split = record.split(BLANK);
            String command = split[0];
            String id = split[1];

            /*if (command.equals(LEAVE)) {
                orders.add(command + BLANK + id);
            } else {    // Enter or Change
                String nickname = split[2];
                users.put(id, nickname);    // 생성 & 업데이트

                if (command.equals(ENTER)) {
                    orders.add(command + BLANK + id);
                }
            }*/

            if (!command.equals(CHANGE)) {  // Enter or Leave
                orders.add(new String[]{command, id});
            }
            if (!command.equals(LEAVE)) {   // Enter or Change
                String nickname = split[2];
                users.put(id, nickname);    // 생성 & 업데이트
            }
        }

        List<String> result = new ArrayList<>();
        for (String[] order : orders) {
            /*String[] split = order.split(BLANK);
            String command = split[0];
            String id = split[1];*/
            String command = order[0];
            String id = order[1];
            String nickname = users.get(id);

            if (command.equals(ENTER)) {
                result.add(nickname + ENTER_STATEMENT);
            } else {
                result.add(nickname + LEAVE_STATEMENT);
            }
        }

        return result.toArray(new String[0]);
    }
}
