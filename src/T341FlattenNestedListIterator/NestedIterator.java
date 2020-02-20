package T341FlattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther: snake
 * @date: 2020/2/19 21:11
 */

// 341. 扁平化嵌套列表迭代器
// https://leetcode-cn.com/problems/flatten-nested-list-iterator/
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// list+递归
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> record = new ArrayList<>();
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        index = 0;
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return record.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index != record.size();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                record.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }

}
