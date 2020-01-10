//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.group4.common.DataTypeTransform;

import java.util.ArrayList;

public class Paging {
    public static int i;

    public Paging() {
    }

    public static ArrayList<ArrayList> getPageByArrayList(int n, ArrayList arrayList) {
        ArrayList<ArrayList> lingshi2 = new ArrayList();
        ArrayList lingshi = new ArrayList();
        System.out.println(arrayList);
        int size = arrayList.size();
        i = size / n + 1;
        if (size % n == 0) {
            i = size / n;
        }

        System.out.println("getPageByArrayList_i:" + i);
        int j;
        if (i >= 2) {
            for(j = 0; j < i; ++j) {
                for(int k = 0; k < n; ++k) {
                    if (n * j + k < size) {
                        lingshi.add(arrayList.get(n * j + k).toString());
                    }
                }

                lingshi2.add(lingshi);
                lingshi = new ArrayList();
            }
        } else {
            for(j = 0; j < size; ++j) {
                lingshi.add(arrayList.get(j).toString());
            }

            lingshi2.add(lingshi);
            System.out.println(lingshi2);
        }

        return lingshi2;
    }

    public static int getArraryListNumber(int n, ArrayList arrayList) {
        int size = arrayList.size();
        int i = size / n + 1;
        if (size % n == 0) {
            i = size / n;
        }

        return i;
    }
}
