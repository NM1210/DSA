package com.Nikunj.Heaps.Q17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReorganiseString {
    Map.Entry<Character, Integer>[] heap;
    int size;
    ReorganiseString(int n){
        heap = new Map.Entry[n];
        size = 0;
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public int left(int i){
        return (2*i+1);
    }
    public int right(int i){
        return (2*i+2);
    }
    public void swap(int a, int b){
        Map.Entry<Character, Integer> temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    public void heapify(int i){
        int largest = i;
        int l = left(i);
        int r = right(i);
        if (l<size && heap[l].getValue() > heap[largest].getValue()){
            largest = l;
        }
        if (r<size && heap[l].getValue() > heap[largest].getValue()){
            largest = r;
        }
        if (i == largest) return;
        swap(i,largest);
        heapify(largest);
    }
    public Map.Entry<Character, Integer> extract(){
        Map.Entry<Character, Integer> popped = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return popped;
    }
    public void insert(Map.Entry<Character, Integer> element){
        size++;
        heap[size-1] = element;
        int i = size-1;
        while (heap[parent(i)].getValue() < heap[i].getValue()){
            heapify(parent(i));
            i = parent(i);
        }
    }

    public String getString(String str, String str2){
        if (size<=0) return str;
        Map.Entry<Character, Integer> element1 = extract();
        str = str + element1.getKey();
        element1.setValue(element1.getValue()-1);
//        System.out.print(element.getKey()+" "+element.getValue()+" ");
        if (size!=0 && element1.getValue()!=0){
            Map.Entry<Character, Integer> element2 = extract();
            str = str + element2.getKey();
            element2.setValue(element2.getValue()-1);
            if (element2.getValue()!=0){
                insert(element2);
            }
        }
        else if (element1.getValue()!=0) {
            str = str + " ";
        }
        if (element1.getValue()!=0){
            insert(element1);
        }
        return getString(str, str2);
    }

    public static void main(String[] args) {
        String input = "aaabba";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i<input.length(); i++){
            int count = 0;
            if (!input.substring(0,i).contains(String.valueOf(input.charAt(i)))){
                for (int j = i; j<input.length(); j++){
                    if (input.charAt(j) == input.charAt(i)){
                        count++;
                    }
                }
                map.put(input.charAt(i), count);
            }
        }
        System.out.print(map.keySet()+" "+map.values()+" "+map.entrySet()+"\n");
        ReorganiseString maxHeap = new ReorganiseString(map.size());
        Set<Map.Entry<Character, Integer>> setOfEntries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> itr = setOfEntries.iterator();
        while(itr.hasNext()) {
            maxHeap.insert(itr.next());
//            System.out.println(itr.next());
        }
        for (int i = 0; i < maxHeap.size; i++){
            System.out.print(maxHeap.heap[i].getKey() + " " + maxHeap.heap[i].getValue() + " ");
        }
        String ans = maxHeap.getString("", input);
        if (ans.length()==input.length()) System.out.print(ans);
        else System.out.print("not possible");
    }
}
