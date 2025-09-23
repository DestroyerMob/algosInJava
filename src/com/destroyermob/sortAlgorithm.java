package com.destroyermob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sortAlgorithm {

    public static ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 13, 3, 2, 5));

    public static void terribleShuffleSort(List<Integer> list, int step) {
        if (list.size() <= 1)
            return;

        boolean sorted = true;
        int index = 0;
        ArrayList<Integer> newList = new ArrayList<>(Collections.singletonList(list.getFirst()));

        for (int i = 1; i < list.size(); i++) {
            if (newList.isEmpty()) {
                newList.add(list.get(i));
            } else {
                if (list.get(i) > newList.get(index)) {
                    newList.add(index + 1, list.get(i));
                    index++;
                } else {
                    sorted = false;
                    newList.add(index, list.get(i));
                }
            }
        }

        if (sorted) {
            System.out.println("List: " + newList + ", Steps: " + step);
            return;
        }

        terribleShuffleSort(newList, step + 1);
    }

    public static void main(String[] args) {
        terribleShuffleSort(list, 0);
    }

}
