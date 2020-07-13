package com.q0589;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	class Node {
		public int        val;
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

	private List<Integer> list = new ArrayList<>();

	public List<Integer> preorder(Node root) {
		list.clear();
		helper(root);
		return list;
	}

	private void helper(Node root) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		for (Node node : root.children) {
			helper(node);
		}
	}
}
