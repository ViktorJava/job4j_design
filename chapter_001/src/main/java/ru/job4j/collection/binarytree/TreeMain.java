package ru.job4j.collection.binarytree;

import ru.job4j.collection.SimpleQueue;
import ru.job4j.collection.SimpleStack;

/**
 * Рекурсивный обход бинарного дерева в глубину.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 28.02.2021
 */
public class TreeMain {
    public static void main(String[] args) {
        Node root =
                new Node(20,
                        new Node(7,
                                new Node(4, null, new Node(6)), new Node(9)),
                        new Node(35,
                                new Node(31, new Node(28), null),
                                new Node(40, new Node(38), new Node(52))));
        System.out.println("Рекурсивный обход. Сумма дерева: " + Node.sumRecursive(root));
        System.out.println("Обход с применением стека. Сумма дерева: " + Node.sumStack(root));
        System.out.println("Обход с применением очереди. Сумма дерева: " + Node.sumQueue(root));
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

        /**
         * Итеративный метод расчёта суммы всех узлов дерева, путём обхода дерева
         * в глубину на основе Stack.
         * Stack реализован на базе LinkedList.
         *
         * @param root Корень дерева.
         * @return Сумма всех узлов.
         */
        public static int sumStack(Node root) {
            int sum = 0;
            SimpleStack<Node> simpleStack = new SimpleStack<>();
            simpleStack.push(root);
            while (!simpleStack.isEmpty()) {
                Node node = simpleStack.pop();
                sum += node.value;
                System.out.println(node.value);
                if (node.right != null) {
                    simpleStack.push(node.right);
                }
                if (node.left != null) {
                    simpleStack.push(node.left);
                }
            }
            return sum;
        }

        /**
         * Итеративный метод расчёта суммы всех узлов дерева, путём обхода дерева
         * в ширину на основе Queue.
         * Queue реализована на базе двух стеков.
         *
         * @param root Корень дерева.
         * @return Сумма всех узлов.
         */
        public static int sumQueue(Node root) {
            int sum = 0;
            SimpleQueue<Node> simpleQueue = new SimpleQueue<>();
            simpleQueue.push(root);
            while (!simpleQueue.isEmpty()) {
                Node node = simpleQueue.poll();
                sum += node.value;
                System.out.println(node.value);
                if (node.right != null) {
                    simpleQueue.push(node.right);
                }
                if (node.left != null) {
                    simpleQueue.push(node.left);
                }
            }
            return sum;
        }
    }
}
