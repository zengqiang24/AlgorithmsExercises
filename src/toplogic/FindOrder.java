package toplogic;

import java.util.*;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int courseIns[] = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> childrenMap = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Integer> queue = new LinkedList<>();

        //统计入度表， 找出每个根和被其依赖的子树
        for (int i = 0; i < prerequisites.length; i++) {
            courseIns[prerequisites[i][0]] = courseIns[prerequisites[i][0]] + 1;

            ArrayList childrenList = childrenMap.get(prerequisites[i][1]);
            if (childrenList == null) {
                childrenList = new ArrayList();
            }
            childrenList.add(prerequisites[i][0]);
            childrenMap.put(prerequisites[i][1], childrenList);//例如依赖c0的课程有c1，c2; map={0,[1,2]}
        }
        //把课程入度为0，加入队列，准备学习。
        for (int i = 0; i < numCourses; i++) {
            if (courseIns[i] == 0) {
                queue.offer(i);
            }
        }

        while (queue.size() != 0) {
            int cid = queue.poll(); //学习一门课程，这里首先是c0
            result.add(cid); //把c0加入结果序列
            //****** */更新其他依赖c0的课程的入度，入度减去1， 如果更新完毕发现入度为0，则继续加入队列。
            ArrayList<Integer> childrenList = childrenMap.get(cid);
            if (childrenList != null && childrenList.size() != 0) {
                for (int id : childrenList) {
                    courseIns[id] = courseIns[id] - 1;
                    if (courseIns[id] == 0) {
                        queue.offer(id);
                    }
                }
            }
        }

        if (result.size() != numCourses) {
            return new int[]{};
        }

        int[] res = new int[numCourses];
        for (int integer = 0; integer < result.size(); integer++) {
            res[integer] = result.get(integer);
        }
        return res;
    }

    public static void main(String[] args) {
//        int prerequisites[][] = {{1,0},{2,0},{3,1},{3,2}};
        int prerequisites[][] = {{1, 0}, {0, 1}};
        FindOrder order = new FindOrder();
        int[] order1 = order.findOrder(2, prerequisites);
        System.out.println(Arrays.toString(order1));
    }
}
