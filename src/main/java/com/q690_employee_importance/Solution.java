package com.q690_employee_importance;

import java.util.List;

/**
 * @author xjn
 * @since 2020-01-29
 * https://leetcode-cn.com/problems/employee-importance/
 * 90. 员工的重要性
 */
public class Solution {
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
        for (Employee employee : employees) {
            if (employee.id == id) {
                res = employee.importance;
                List<Integer> ids = employee.subordinates;
                for (Integer i : ids) {
                    res += getImportance(employees, i);
                }
            }
        }
        return res;
    }
}
