import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*应该符合等价类原则，根据等价类原则应该有
正常输入：
包含多个用户的收藏清单，其中部分清单是其他清单的子集。
所有输入符合题目要求的格式和约束。
边界输入：
输入只有一个用户的收藏清单（没有子集情况）。
输入中所有用户的收藏清单都是其他清单的子集（应返回空列表）。
输入中所有用户的收藏清单都是独立的，没有子集关系（应返回所有索引）。
异常输入：
输入包含空的收藏清单（需要考虑如何处理这种情况）。
输入包含重复的收藏清单（但根据题目说明，用户收藏的公司清单各不相同，这里仅作为测试覆盖的完整性考虑）。
* */

public class L2022211809_6_Test {
    //测试正常清单
    @Test
    public void testNormalInput() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("leetcode", "google", "facebook"));
        favoriteCompanies.add(Arrays.asList("google", "microsoft"));
        favoriteCompanies.add(Arrays.asList("google", "facebook"));
        favoriteCompanies.add(Arrays.asList("google"));
        favoriteCompanies.add(Arrays.asList("amazon"));

        List<Integer> expected = Arrays.asList(0, 1, 4);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }
    //测试单独清单
    @Test
    public void testSingleUser() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("leetcode", "google"));

        List<Integer> expected = Arrays.asList(0);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }
    //测试全子集清单
    @Test
    public void testAllSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("leetcode", "google", "facebook"));
        favoriteCompanies.add(Arrays.asList("google", "facebook"));
        favoriteCompanies.add(Arrays.asList("facebook"));

        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }
    //测试全独立没有子集清单
    @Test
    public void testNoSubsets() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("leetcode"));
        favoriteCompanies.add(Arrays.asList("google"));
        favoriteCompanies.add(Arrays.asList("facebook"));
        favoriteCompanies.add(Arrays.asList("amazon"));

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }
    //测试空清单
    @Test
    public void testEmptyList() {
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(new ArrayList<>());

        List<Integer> expected = Arrays.asList(0);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }
    //测试重复清单
    @Test
    public void testDuplicateLists() {
        // This test case should never happen based on the problem statement,
        // but included for completeness of test coverage.
        Solution6 solution = new Solution6();
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(Arrays.asList("leetcode", "google"));
        favoriteCompanies.add(Arrays.asList("leetcode", "google"));

        List<Integer> expected = Arrays.asList(0); // Or it could be an empty list, depending on interpretation
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        // This is ambiguous since problem statement states lists are unique,
        // but if interpreted strictly, might want to ensure result makes sense.
        assertTrue(result.isEmpty() || result.contains(0) && result.size() == 1);
    }
}