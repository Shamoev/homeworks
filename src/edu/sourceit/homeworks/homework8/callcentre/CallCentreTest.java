package edu.sourceit.homeworks.homework8.callcentre;

import edu.sourceit.homeworks.homework8.callcentre.impl.Call;
import edu.sourceit.homeworks.homework8.callcentre.impl.CallCentre;

import java.util.*;

public class CallCentreTest {
    private static final int TOTAL_CALLS = 10;
    private static final String OPERATOR = "Operator";

    public static void main(String[] args) {
        List<Call> calls = new LinkedList<>();

        for (int i = 0; i < TOTAL_CALLS; i++) {
            calls.add(CallCentre.produceCall());
        }

        System.out.println(Arrays.toString(calls.toArray()));

        Map<String, List<Integer>> callDurations = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1Number = o1.substring(OPERATOR.length());
                int o1IntNumber = Integer.parseInt(o1Number) - 1;
                String o2Number = o2.substring(OPERATOR.length());
                int o2IntNumber = Integer.parseInt(o2Number) - 1;
                return o1IntNumber - o2IntNumber;
            }
        });

        for (Call call : calls) {
            if (!callDurations.containsKey(call.getOperator())) {
                callDurations.put(call.getOperator(), new ArrayList<>(Arrays.asList(call.getDuration())));
            } else {
                callDurations.get(call.getOperator()).add(call.getDuration());
            }
        }

        for (Map.Entry<String, List<Integer>> entry : callDurations.entrySet()) {
            System.out.println(entry.getKey() + " helped " + entry.getValue().size() +
                    (entry.getValue().size() > 1 ? " customers for " : " customer for ") +
                    calcSumDuration(entry.getValue()) + " seconds.");
        }
    }
    private static int calcSumDuration(List<Integer> list) {
        int result = 0;
        for (Integer duration : list) {
            result += duration;
        }
        return result;
    }
}
