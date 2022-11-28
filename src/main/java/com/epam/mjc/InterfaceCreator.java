package com.epam.mjc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        Predicate<List<String>> predicate = strings -> {
            for (String s : strings) {
                if (Character.isLowerCase(s.charAt(0)) || Character.isDigit(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
        return predicate;
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        Consumer<List<Integer>> consumer = integers -> {
            List<Integer> temp = new ArrayList<>();
            for (Integer i : integers) {
                if (i % 2 == 0) {
                    temp.add(i);
                }
            }
            integers.addAll(temp);
        };
        return consumer;
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        Supplier<List<String>> supplier = () -> {
            List<String> temp = new ArrayList<>();
            for (String s:values) {
                String[] arr = s.split(" ");
                if(Character.isUpperCase(s.charAt(0)) && s.charAt(s.length()-1)=='.' && arr.length>3){
                    temp.add(s);
                }
            }
            return temp;
        };
        return supplier;
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Function<List<String>, Map<String, Integer>> function = strings -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String s:strings) {
                map.put(s,s.length());
            }
            return map;
        };
        return function;
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
            @Override
            public List<Integer> apply(List<Integer> integers, List<Integer> integers2) {
                List<Integer> list = new ArrayList<>(integers);
                list.addAll(integers2);
                return list;
            }
        };
        return biFunction;
    }
}
