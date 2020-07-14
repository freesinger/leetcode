package src.backtrack;


import src.backtrack.basebacktrack.BackTrackInterface;
import src.backtrack.basebacktrack.BaseBackTrack;
import src.utils.Tools;

import java.util.LinkedList;
import java.util.List;

class SubSets extends BaseBackTrack implements BackTrackInterface {
    private int[] nums;

    public SubSets() {
    }

    public SubSets(int[] nums) {
        this.nums = nums;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return null;
        List<List<Integer>> results = new LinkedList<>();
        backTrack(nums, 0, new LinkedList<>(), results);
        return results;
    }

    /**
     * 回溯法求所有子集
     *
     * @param nums
     * @param start
     * @param track
     * @param res
     */
    private static void backTrack(int[] nums, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        // res.add(track); 全为[] 堆里只有一个track对象，传参只传对象的引用
        res.add(new LinkedList<>(track)); // res.add(track); 全为[]
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, i + 1, track, res);
            track.removeLast();
        }
    }


    @Override
    public void backTrack() {
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> l : res) Tools.traceList(l);
    }

    public static void main(String[] args) {
        new SubSets(new int[]{1, 3, 2, 4}).backTrack();
    }
}