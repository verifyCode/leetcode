package com.q0690_employee_importance;

import java.util.*;

/**
 * @author xjn
 * @since 2020-01-29
 */
public class Solution2 {
    private class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        if (employees == null || employees.size() == 0) {
            return res;
        }
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee remove = queue.remove();
            res += remove.importance;
            List<Integer> subordinates = remove.subordinates;
            for (Integer subId : subordinates) {
                queue.add(map.get(subId));
            }
        }
        return res;
    }
}