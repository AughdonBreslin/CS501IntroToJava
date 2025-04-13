package Trees_17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @CREDIT: https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
 * @created: 4/12/2025, Saturday
 **/
class BTreePrinter {
    public static <E extends Comparable<E>> String printNode(Node<E> root) {
        int maxLevel = BTreePrinter.maxLevel(root);
        StringBuilder sb = new StringBuilder();
        printNodeInternal(sb, Collections.singletonList(root), 1, maxLevel);
        return sb.toString();
    }

    private static <E extends Comparable<E>> void printNodeInternal(StringBuilder sb, List<Node<E>> nodes, int level, int maxLevel) {

        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(sb, firstSpaces);

        List<Node<E>> newNodes = new ArrayList<Node<E>>();
        for (Node<E> node : nodes) {
            if (node != null) {
                sb.append(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                sb.append(" ");
            }

            BTreePrinter.printWhitespaces(sb, betweenSpaces);
        }
        sb.append("\n");

        for (int i = 1; i <= endgeLines; i++) {
            for (Node<E> node : nodes) {
                BTreePrinter.printWhitespaces(sb, firstSpaces - i);
                if (node == null) {
                    BTreePrinter.printWhitespaces(sb, endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (node.left != null)
                    sb.append("/");
                else
                    BTreePrinter.printWhitespaces(sb, 1);

                BTreePrinter.printWhitespaces(sb, i + i - 1);

                if (node.right != null)
                    sb.append("\\");
                else
                    BTreePrinter.printWhitespaces(sb, 1);

                BTreePrinter.printWhitespaces(sb, endgeLines + endgeLines - i);
            }

            sb.append("\n");
        }

        printNodeInternal(sb, newNodes, level + 1, maxLevel);
    }

    private static StringBuilder printWhitespaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(" ");
        return sb;
    }

    private static <E extends Comparable<E>> int maxLevel(Node<E> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <E> boolean isAllElementsNull(List<E> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
