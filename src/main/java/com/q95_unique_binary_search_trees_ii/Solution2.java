package com.q95_unique_binary_search_trees_ii;

import com.q101_symmetric_tree.TreeNode;

import javax.swing.*;
import java.util.Random;

public class Solution2 {

	Random random = new Random(System.currentTimeMillis());

	//根据数组随机生成一棵二叉树
	public TreeNode generateTree(int[] array){
		randomArray(array);
		return dfs(array,0);
	}

	private TreeNode dfs(int[] array,int index){
		TreeNode node = new TreeNode(array[index]);
		if(index == array.length -1){
			return node;
		}
		node.left = dfs(array,index + 1);
		node.right = dfs(array,index +1);
		return node;
	}


	private void randomArray(int[] array){
		//bobo老师的公众号的随机算法
		for(int i = array.length -1; i >= 0; i --){
			swap(array,i,random.nextInt( i +1));
		}
	}

	private void swap(int[] array,int aIndex, int bIndex){
		int c = array[aIndex];
		array[aIndex] = array[bIndex];
		array[bIndex] = c;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,4,5};
		Solution2 solution2 = new Solution2();
		TreeNode node = solution2.generateTree(array);
		System.out.println(node);
	}


}
