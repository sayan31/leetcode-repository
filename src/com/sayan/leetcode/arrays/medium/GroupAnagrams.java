package com.sayan.leetcode.arrays.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedInpMap = new HashMap<>();

        for(String currStr: strs){
            char[] input = currStr.toCharArray();
            Arrays.sort(input);
            String sortedInput = new String(input);

            if(sortedInpMap.containsKey(sortedInput)){
                sortedInpMap.get(sortedInput).add(currStr);
            }else{
                sortedInpMap.put(sortedInput,new ArrayList<>(Stream.of(currStr).collect(Collectors.toList())));
            }
        }
        return new ArrayList<>(sortedInpMap.values());
    }

    public void printAnswer(List<List<String>> answer){
        answer.forEach(list -> {
            list.forEach(element -> System.out.print(element+" "));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> answer = obj.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        obj.printAnswer(answer);
    }
}
