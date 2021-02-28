package ru.job4j.collection.binarytree;

/**
 * Рекурсивный обход бинарного дерева в глубину.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 28.02.2021
 */
public class TreeMain {
    public static void main(String[] args) {
        // Описание бинарного дерева.
        Node root =
                new Node(20,
                        new Node(7,
                                new Node(4, null, new Node(6)), new Node(9)),
                        new Node(35,
                                new Node(31, new Node(28), null),
                                new Node(40, new Node(38), new Node(52))));
        System.out.println("Сумма: " + Node.sumRecursive(root));
    }

    /**
     * Static nested (inner) class.
     * Модель класса узла дерева.
     */
    private static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        /**
         * Рекурсивный метод обхода дерева в глубину и расчёта суммы узлов.
         *
         * @param root Корень дерева.
         * @return Сумма всех узлов.
         */
        public static int sumRecursive(Node root) {
            int summ = root.value;
            if (root.left != null) {
                summ += sumRecursive(root.left);
            }
            if (root.right != null) {
                summ += sumRecursive(root.right);
            }
            return summ;
        }
    }
}
