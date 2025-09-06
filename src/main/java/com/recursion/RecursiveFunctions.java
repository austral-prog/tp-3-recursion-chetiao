package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFunctions {

        public static int recursiveIndexOf(List<String> list, String target) {
            return recursiveIndexOfByIndex(list, target, 0);
        }

        public static int recursiveIndexOfByIndex(List<String> list, String target, int index) {
            if (target.equals(list.get(index))) {   // caso base
                return index;
            }
            if (list.size() - 1 == index) {  // si el size es igual al indice entonces no se encontro
                return -1;
            }
            return recursiveIndexOfByIndex(list, target, ++index);  // comienza el bucle con el siguiente
        }

    public static int recursiveIndexOfEmpty(List<String> list) {
//        if (list.get(list.size() - 1) == "") {
//            return list.size() - 1;
//        }
//
//        else {                                    ??????????????????
//            list.remove(list.size() - 1);
//            return recursiveIndexOfEmpty(list);
//        }
        return recursiveIndexOfByIndex(list, "", 0);
        }

    public static int recursivePut(String target, List<String> list) {

        int lugar_vacio = recursiveIndexOfEmpty(list);

        if (lugar_vacio == -1) {            // por si no hay lugar vacio
        return -1;
        }

        list.set(lugar_vacio, target);

        return lugar_vacio;
    }

    public static int recursiveRemove(List<String> list, String target) {
            List<String> norepetidosList = new ArrayList<>(list);       // lista nueva que no tendra elementos repetidos
            return recursiveRemove(list, target, 0, 0, norepetidosList);

    }

    public static int recursiveRemove(List<String> list, String target, int idx, int deleted, List<String> norepetidosList) {
        if (list.get(idx).equals(target)) {
            deleted += 1;                       // elimina el elemento repetido
        }
        else {                              // si no es repetido lo agrega a la lista de no repetidos
            norepetidosList.add(target);
        }
        if (list.size() - 1 == idx) {
            return deleted;
        }
        return recursiveRemove(list, target, ++idx, deleted, norepetidosList);
    }

    public static int recursiveSum(List<Integer> list) {
        int suma = 0;
        if (list.isEmpty()) {
            return suma;
        }
        suma += list.getFirst();
        return suma + recursiveSum(list.subList(1, list.size()));
    }

    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }

    public static int recursivePow(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        return base * recursivePow(base, exponent - 1);
    }

    public static int recursiveFibonacci(int n) {
            if (n <= 1) {
                return n;
            }

            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }


    public static boolean recursivePalindrome(String word) {
            if (word.length() == 1) {
                return true;
            }
            if (word.charAt(word.length()-1) == word.charAt(0)) {
                return recursivePalindrome(word.substring(1, word.length()-1));
            }
            else {
                return false;
            }

    }
    }
