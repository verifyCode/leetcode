package com.q599_maximum_depth_of_n_ary_tree;

import java.util.List;

/**
 * @author xjn
 * @since 2019-12-27
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
