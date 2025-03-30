package SetsAndMaps_15;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
import java.util.*;

public class EmployeeHierarchy {
    public static Map<String, Integer> countEmployeesUnderManager(Map<String, String> empToManager) {
        Map<String, List<String>> managerToEmps = new HashMap<>();

        // Step 1: Build reverse mapping (manager to list of direct reports)
        for (Map.Entry<String, String> entry : empToManager.entrySet()) {
            String emp = entry.getKey();
            String manager = entry.getValue();

            // Skip if employee is their own manager (CEO case)
            if (!emp.equals(manager)) {
                managerToEmps.computeIfAbsent(manager, k -> new ArrayList<>()).add(emp);
            }
        }

        // Step 2: For each employee, count their total reports (direct + indirect)
        Map<String, Integer> result = new HashMap<>();
        for (String emp : empToManager.keySet()) {
            result.put(emp, getTotalReports(emp, managerToEmps));
        }
        return result;
    }

    // Recursive helper to count total reports
    private static int getTotalReports(String manager, Map<String, List<String>> managerToEmps) {
        if (!managerToEmps.containsKey(manager)) {
            return 0;  // No direct reports
        }

        int total = 0;
        for (String emp : managerToEmps.get(manager)) {
            total += 1 + getTotalReports(emp, managerToEmps);  // 1 (direct) + indirect
        }
        return total;
    }

    public static void main(String[] args) {
        Map<String, String> employees = new HashMap<>();
        employees.put("A", "C");  // A's manager is C
        employees.put("B", "C");  // B's manager is C
        // C manages two employees: A and B
        employees.put("C", "F");  // C's manager is F
        // F manages C and indirectly manages A and B, so 3 so far
        employees.put("D", "E");  // D's manager is E
        employees.put("E", "F");  // E's manager is F
        employees.put("F", "F");  // F is the CEO (manages themselves)

        System.out.println(countEmployeesUnderManager(employees));
    }
}
