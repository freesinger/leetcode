package src.backtrack;

import src.backtrack.basebacktrack.BackTrackInterface;
import src.utils.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法求全排列
 */
public class Permutation implements BackTrackInterface {
    private int[] nums;
    private List<LinkedList<Integer>> res;

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4};
        List<LinkedList<Integer>> lists = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        Permutation perm = new Permutation(test, lists);
        //perm.permutation(new LinkedList<>());
        perm.permutationWithMap(new LinkedList<>(), map);
        for (LinkedList<Integer> l : lists) {
            Tools.traceList(l);
        }
    }


    public Permutation(int[] nums, List<LinkedList<Integer>> res) {
        this.nums = nums;
        this.res = res;
    }


    public void permutation(LinkedList<Integer> curPerms) {
        if (curPerms.size() == nums.length) {
            res.add(new LinkedList<>(curPerms));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!curPerms.contains(nums[i])) {
                curPerms.add(nums[i]);
                permutation(curPerms);
                curPerms.removeLast();
            }
        }

    }

    private void permutationWithMap(LinkedList<Integer> curPerm, HashMap<Integer, Boolean> map) {
        if (curPerm.size() == nums.length) {
            res.add(new LinkedList<>(curPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null || !map.get(nums[i])) {
                curPerm.add(nums[i]);
                map.put(nums[i], true);
                permutationWithMap(curPerm, map);
                map.put(nums[i], false);
                curPerm.removeLast();
            }
        }
    }


    @Override
    public void backTrack() {

    }
}
