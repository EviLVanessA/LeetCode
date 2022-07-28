package com.study.competition.competition303;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jianghui
 * @date 2022-07-24 10:37
 */
public class FoodRatings {
    Map<String, Node> rateMap = new HashMap<>();
    TreeMap<String, PriorityQueue<Node>> map = new TreeMap<>();

    static class Node {
        String food;
        String cuisines;
        int rate;

        public Node(String food, String cuisines, int rate) {
            this.food = food;
            this.cuisines = cuisines;
            this.rate = rate;
        }

        public String getFood() {
            return food;
        }

        public void setFood(String food) {
            this.food = food;
        }

        public String getCuisines() {
            return cuisines;
        }

        public void setCuisines(String cuisines) {
            this.cuisines = cuisines;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Node node = new Node(foods[i], cuisines[i], ratings[i]);
            map.putIfAbsent(cuisines[i], new PriorityQueue<>(((o1, o2) -> {
                if (o1.getRate() == o2.getRate()) {
                    return o1.getFood().compareTo(o2.getFood());
                }
                return o2.getRate() - o1.getRate();
            })));
            rateMap.put(foods[i], node);
            map.get(cuisines[i]).add(node);
        }
    }

    public void changeRating(String food, int newRating) {
        Node node = rateMap.get(food);
        map.get(node.getCuisines()).remove(node);
        node.setRate(newRating);
        map.get(node.getCuisines()).add(node);
    }


    /**
     * 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且
     * 1/2 的概率返回 1
     * 1/4 的概率返回 2
     * 1/8 的概率返回 3 以此类推
     */
    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().getFood();
    }
}
