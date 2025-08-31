package algorithm.greedy.activity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Activity {
    private String name;
    private int startTime;
    private int finishTime;
}
