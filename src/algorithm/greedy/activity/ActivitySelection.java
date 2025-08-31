package algorithm.greedy.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    void activitySelection(ArrayList<Activity> activityList){
        // 람다식을 이용한 Comparator 생성
        Comparator<Activity> finishTimeComparator = (o1, o2) -> o1.getFinishTime() - o2.getFinishTime(); // 람다식을 이용한 Comparator 생성
        Collections.sort(activityList, finishTimeComparator);   // 종료 시간을 기준으로 오름차순 정렬

        Activity previousActivity = activityList.get(0);    // 첫 번째 활동은 무조건 선택
        System.out.println("\n\nRecommended Schedule:\n" + activityList.get(0)); // 첫 번째 활동 출력

        // 이전 활동과 현재 활동을 비교하여 선택
        for (int i = 0; i < activityList.size(); i++) {
            Activity activity = activityList.get(i); // 현재 활동
            if(activity.getStartTime() >= previousActivity.getFinishTime()){ // 현재 활동의 시작 시간이 이전 활동의 종료 시간보다 크거나 같다면
                System.out.println(activity);  // 활동 선택
                previousActivity = activity;    // 이전 활동 갱신
            }
        }
    }
}
