package com.study.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jianghui
 * @date 2022/6/21
 */
public class SnapshotArray {

    int id = 0;
    List<int[]>[] array;

    public SnapshotArray(int length) {
        array = new ArrayList[length];
        Arrays.fill(array, new ArrayList<>());
    }

    public void set(int index, int val) {
        array[index].add(new int[]{id, val});
    }

    public int snap() {
        int curr = id;
        id++;
        return curr;
    }

    public int get(int index, int snap_id) {
        List<int[]> snaplist = array[index];
        int low = -1, high = snaplist.size() - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (snaplist.get(mid)[0] <= snap_id) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low >= 0 ? snaplist.get(low)[1] : 0;
    }
}
