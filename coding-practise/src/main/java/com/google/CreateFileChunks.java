package com.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateFileChunks {
    public static void main(String[] args) {
        int ar[] =  {6,2,0,5,-1,-1,4};
        CreateFileChunks c = new CreateFileChunks();

        List<List<Integer>> result = c.getFiles(ar);
        System.out.println(result);
    }

    public List<List<Integer>> getFiles(int [] ar) {
    List<List<Integer>> result = new ArrayList<>();

        if (ar. length==0) {
            return result;

        }

        Set<Integer> set = new HashSet<>();
        for (int i =0; i<ar.length;i++) {
            if (ar[i]!=-1){
                set.add(ar[i]);
            }
        }

        for (int i =0;i<ar.length;i++){
            if (!set.contains(i)){
                List<Integer> fileChunks = new ArrayList<>();
                fileChunks.add(i);
                if (ar[i]!=-1){
                    buildFile(ar,fileChunks,i);
                }
                result.add(fileChunks);
            }
        }

        return result;
    }

    void buildFile(int ar[], List<Integer> list, int currentIndex){
        int next=ar[currentIndex];
        if (next==-1){
            return;
        }
        list.add(next);
        buildFile(ar, list, next);
    }
}

/*1 Input:
2
3
0--1--2--3--4--5--6
[6 2 0 5 -1 -1 4]
5
6
7
Output:
1, 2, 0, 6, 4
8
3, 5
9
10
11
12
[6 2 0 5-1-1 4 81
13
14
15 -
class Solution {
16
17
18
10 -
public List<List<Intger> getFiles(int [] ar)t
20
21
List«ListeIntger> result = new ArrayLists>);
22
23
24
if (ar. length==0) {
return result.
25
}
26
27
Set<Integer> set = new HashSet<>();
28
29
30
for (int i=0;isar.length;it+) {
set.add(ar[i]);
31
32
33 -
for (int i = 0;i<ar.length;i++) {
34
35 -
36
37
if (!set.contains (i))f
List«Integer> fileChunks = new ArrayListe>0):
fileChunks.add(i):
38
39 -
40
if (ar[i]!=-1)f
buildFile(ar, fileChunks, i);
41
42
43
result.add(fileChunks)
44
45
)
46
}
47
return result;
48
49
50
51
void buildFile(int ar[], List«Integer> list, int currentIndex) (
52
53
54.
55
int next = ar[currentIndex];
if (next ==-1) {
return;
56
57
58
}
list.add (next) ;
buildFile(ar, list, next) ;
59
60
61
62
63
64 Runtime Complexity:
*/
