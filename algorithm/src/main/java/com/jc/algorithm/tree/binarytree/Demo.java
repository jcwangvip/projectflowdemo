package com.jc.algorithm.tree.binarytree;

/**
 * 给定一个二叉搜索树(BST)，找到树中第 K 小的节点
 * <p>
 * 如果按照中序遍历的顺序遍历一棵二叉搜索树，遍历序列的数值是递增排序的。
 * 上图中的二叉搜索树的中序遍历序列为{2,3,4,5,6,7,8}，
 * 因此，只需要用中序遍历算法遍历一棵二叉搜索树，就很容易找出它的第k大结点。
 *
 * @author jiancheng
 * @date 2019-10-24
 */
public class Demo {

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        BinaryTreeNode root = demo.new BinaryTreeNode(5);
        BinaryTreeNode a = demo.new BinaryTreeNode(3);
        BinaryTreeNode b = demo.new BinaryTreeNode(7);
        BinaryTreeNode c = demo.new BinaryTreeNode(2);
        BinaryTreeNode d = demo.new BinaryTreeNode(4);
        BinaryTreeNode e = demo.new BinaryTreeNode(6);
        BinaryTreeNode f = demo.new BinaryTreeNode(8);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        BinaryTreeNode k = KthNode(root, 3);
        System.out.println(k.val);
    }

    static int index = 0;

    static BinaryTreeNode KthNode(BinaryTreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        return getKthNode(pRoot, k);
    }

    private static BinaryTreeNode getKthNode(BinaryTreeNode pRoot, int k) {
        BinaryTreeNode KthNode = null;
        //如果该节点有左孩子，就一直递归到左叶子节点
        if (pRoot.left != null) {
            KthNode = getKthNode(pRoot.left, k);
        }
        if (KthNode == null) {
            index++;  //中序遍历的计数
            if (k == index) {
                KthNode = pRoot;
            }
        }

        //如果该节点有右孩子，就递归到右孩子
        if (KthNode == null && pRoot.right != null) {
            KthNode = getKthNode(pRoot.right, k);
        }
        return KthNode;
    }

}
