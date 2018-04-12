/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.BitSet;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.lang.Math;
import java.util.Stack;
import java.util.ArrayList;
import java.util.AbstractCollection;
import java.util.Queue;
import java.util.LinkedList;



/**
 *
 * @author julliancockerell
 */
public class InterviewMethods {

    //Main function
    public static void main(String[] args) 
    {
        testFindBuildOrder();
    }
 
    //*---------FUNCTIONS-------------*
    public static boolean UniqueCharacters(String input)
    {
        int iHold;
        char cHold;
        HashMap table = new HashMap(128);
        for(int c = 0; c < input.length(); c++)
        {
            cHold = input.charAt(c);
            iHold = (int) cHold;
            if(table.get(iHold))
            {
                table.put(iHold, cHold);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean UniqueCharacters2(String input)
    {
        int size = 128;
        BitSet map = new BitSet(size);
        int iHold;
        char cHold;
        for(int c = 0; c < input.length(); c++)
        {
            cHold = input.charAt(c);
            iHold = (int) cHold;
            if(map.get(iHold % size))
            {
                return false;
            }
            else
            {
                map.set(iHold%size);
            }
        }
        return true;
    }
    
    public static boolean isPermutation(String input1, String input2)
    {
        if(input1.length() != input2.length())
        {
            return false;
        }
        char[] sort1 = input1.toCharArray();
        char[] sort2 = input2.toCharArray();
        java.util.Arrays.sort(sort1);
        java.util.Arrays.sort(sort2);
        String new1 = new String(sort1);
        String new2 = new String(sort2);
        return new1.equals(new2);
    }
    
    public static boolean isPermutation2(String input1, String input2)
    {
        if(input1.length() != input2.length())
        {
            return false;
        }
        int size = 128;
        int key;
        int map[] = new int[size];
        for(int c = 0; c < input1.length(); c++)
        {
            key = input1.charAt(c);
            map[key]++;
        }
        for(int c = 0; c < input2.length(); c++)
        {
            key = input2.charAt(c);
            map[key]--;
            if(map[key] < 0)
            {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome(String input)
    {
        int size = 128;
        char cHold;
        boolean oddFound = false;
        BitSet map = new BitSet(size);
        for(int c = 0; c < input.length(); c++)
        {
            cHold = input.charAt(c);
            map.flip(((int) cHold ) % size);
        }
        for(int c = 0; c < size; c++)
        {
            if(map.get(c))
            {
                if(oddFound)
                {
                    return false;
                }
                oddFound = true;
            }
        }
        return true;
    }
    
    public static String URLify(String input)
    {
        StringBuilder output = new StringBuilder();
        char cHold;
        for(int c = 0; c < input.length(); c++)
        {
            cHold = input.charAt(c);
            if(cHold == ' ')
            {
                output.append("%20");
            }
            else
            {
                output.append(cHold);
            }
        }
        return output.toString();
    }
    
    public static boolean oneEditAway(String input1, String input2)
    {
       boolean difFound = false;
       int lengthDif = Math.abs(input1.length() - input2.length());
       if(lengthDif > 1){return false;}
       
       if(lengthDif == 1)
       {
           String sHold;
           if(input2.length() > input1.length())
           {
               sHold = input2;
               input2 = input1;
               input1 = sHold;
           }
           for(int c = 0, c2 = 0; c < input1.length(); c++, c2++)
           {
               if(input1.charAt(c) != input2.charAt(c2))
               {
                   if(difFound){return false;}
                   difFound = true;
                   c2--;
               }
           }
           return true;
       }
       
       if(lengthDif == 0)
       {
           for(int c = 0; c < input1.length(); c++)
           {
               if(input1.charAt(c) != input2.charAt(c))
               {
                   if(difFound){return false;}
                   difFound = true;
               }
           }
           return true;
       }
       
       return false;
    }
    
    public static String compressString(String input)
    {
        StringBuilder output = new StringBuilder();
        int sCount = 0;
        for(int c = 0; c < input.length(); c++)
        {
            sCount++;
            if(c + 1 >= input.length() || input.charAt(c) != input.charAt(c + 1))
            {
                output.append(input.charAt(c));
                output.append(sCount);
                sCount = 0;
            }
        }
        String output2 = output.toString();
        if(input.length() <= output2.length()){return input;}
        else{return output2;}
    }
    
    public static boolean rotateMatrix(int[][] input)
    {
        printMatrix(input);
        if(input.length < 1 || input.length != input[0].length){return false;}
        int size = input.length;
        int first, last, top, offset;
        for(int layer = 0; layer < size/2; layer++)
        {
            first = layer;
            last = (size - 1) - layer;
            for(int c = first; c < last; c++)
            {
                offset = c - first;
                top = input[first][c];
                input[first][c] = input[last-offset][first];
                input[last-offset][first] = input[last][last-offset];
                input[last][last-offset] = input[c][last];
                input[c][last] = top;
            }
        }
        System.out.println("");
        printMatrix(input);
        return true;
    }
    
    public static void nullifyZeros(int[][] matrix)
    {
        printMatrix(matrix);
        System.out.println("");
        for(int i = 0; i < matrix.length; i++)//finds 0's and stores in first index
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    break;
                }
            }
        }
        printMatrix(matrix);
        System.out.println("");
        for(int i = 1; i < matrix.length; i++)//set all rows to 0
        {
            if(matrix[i][0] == 0)
            {
                for(int j = 0; j < matrix.length; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < matrix.length; j++)//set all columns to 0
        {
            if(matrix[0][j] == 0)
            {
                for(int i = 0; i < matrix.length; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
       
        printMatrix(matrix);
    }
    
    public static void printMatrix(int[][] input)
    {
        for(int i = 0; i < input.length; i++)
        {
            for(int j = 0; j < input[0].length; j++)
            {
                System.out.print(input[i][j]); System.out.print("    ");
                if(j == input[0].length - 1){System.out.println("");}
            }
        }
    }
    
    public static boolean isRotation(String s1, String s2)
    {
        if(s1.length() != s2.length() || s1.length() < 1){return false;}
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }
    
    public static linkedList listDups(linkedList input)
    {
        HashMap map = new HashMap(10);
        listNode temp = input.head;
        listNode prev = null;
        while(temp != null)
        {
            if(map.get(temp.data))
            {
                map.put(temp.data);
                prev = temp;
            }
            else
            {
                prev.next = temp.next;
            }
            temp = temp.next;
        }
        return input;
    }
    
    public static listNode nthToLast(linkedList input, int n)
    {
        listNode one = input.head;
        listNode two = input.head;
        
        for(int c = 0; c < n; c++)
        {
            if(one == null){return null;}
            one = one.next;
        }
        
        while(one != null)
        {
            one = one.next;
            two = two.next;
        }
        
        return two;
    }
    
    public static listNode partition(listNode input, int partition)
    {
       listNode first = input;
       listNode last = input;
       listNode next;
        while(input != null)
        {
            next = input.next;
            if(input.data < partition)
            {
               input.next = first;
               first = input;
            }
            else
            {
                last.next = input;
                last = input;
            }
            input = next;
        }
        last.next = null;
        return first;
    }
    
    public static listNode addLists(listNode a1, listNode a2, int carry)
    {
        listNode sum = addListHelper(a1, a2, carry);
        return sum;
    }
    
    public static listNode addListHelper(listNode a1, listNode a2, int carry)
    {
        listNode result = new listNode();
        int value = carry;
        if(a1 != null)
        {
            value += a1.data;
        }
        if(a2 != null)
        {
            value += a2.data;
        }
        result.data = value % 10;
        
        if(a1 != null || a2 != null || carry != 0)
        {
            listNode nextDigit = addListHelper(a1==null ? null : a1.next, a2==null ? null : a2.next, value > 10 ? 1 : 0);
            result.next = nextDigit;
        }
        return result;
    }
    
    public static listNode padListBefore(listNode input, int diff)
    {
        if(diff > 1)
        {
            input = padListBefore(input, diff - 1);
        }
        listNode node = new listNode(0);
        node.next = input;
        return node;
    }
    
    public static listNode padListAfter(listNode input, int diff)
    {
        listNode temp = new listNode(0);
        for(int i = 0; i < diff; i++)
        {
            input.append(0);
        }
        return input;
    }
    
    public static boolean isPalindrome(listNode input)
    {
        listNode fast = input;
        listNode slow = input;
        Stack pile = new Stack();
        
        while(fast != null && fast.next != null)
        {
            pile.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null)
        {
            slow = slow.next;
        }
        
        while(slow != null)
        {
            int compare = (int) pile.pop();
            if(compare != slow.data){return false;}
            slow = slow.next;
        }
        return true;
    }
    
    public static listNode intersectionNode(listNode one, listNode two)
    {
        listNodeResult result1 = getTailSize(one);
        listNodeResult result2 = getTailSize(two);
        
        if(result1.tail != result2.tail){return null;}
        int len1 = result1.size;
        int len2 = result2.size;
        if(len1 > len2)
        {
            for(int i = 0; i< len1-len2; i++)
            {
                one = one.next;
            }
        }
        if(len2 > len1)
        {
            for(int i = 0; i< len2-len1; i++)
            {
                two = two.next;
            }
        }
        while(one != two)
        {
            one = one.next;
            two = two.next;
        }
        return one;
    }
    
    public static listNodeResult getTailSize(listNode input)
    {
        int size = 0;
        listNode temp = input;
        while(temp.next != null)
        {
            size++;
            temp = temp.next;
        }
        size++;
        return new listNodeResult(temp, size);
    }
    
    public static listNode listLoop(listNode start)
    {
        listNode slow = start;
        listNode fast = start;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                break;
            }
        }
        if(slow != fast){return null;}
        slow = start;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    public static void testMinStack()
    {
        jStackWitMin min = new jStackWitMin();
        min.push(5);
        min.push(7);
        min.push(8);
        min.push(9);
        min.push(10);
        min.push(11);
        min.push(2);
        min.push(1);
        min.push(1);
        min.pop();
        min.pop();
        min.pop();
        min.pop();
        System.out.println(min.min());
    }
    
    public static void testStackSet()
    {
        setOfStacks stacks = new setOfStacks(2);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        
        for(int i = 0; i < 5; i++)
        {
            System.out.println(stacks.pop());
        }
    }
    
    public static void testStackQueue()
    {
        stackQueue<Integer> test = new stackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        for(int i = 0; i <4; i++)
        {
            System.out.println(test.remove());
        }
    }
    
    public static void sortStack(Stack<Integer> input)
    {
        Stack<Integer> output = new Stack<Integer>();
        int tmp;
        while(!input.isEmpty())
        {
            tmp = input.pop();
            while(!output.isEmpty() && output.peek() > tmp)
            {
                input.push(output.pop());
            }
            output.push(tmp);
        }
        while(!output.isEmpty())
        {
            input.push(output.pop());
        }
    }
    
    public static void testSortStack()
    {
        Stack<Integer> test = new Stack<Integer>();
        test.push(20);
        test.push(1);
        test.push(17);
        test.push(5);
        test.push(500);
        test.push(3);
        test.push(3);
        sortStack(test);
        while(!test.isEmpty())
        {
            System.out.println(test.pop());
        }
    }
    
    public static binTreeNode makeTreeFromArray(int[] input)
    {
        return makeTreeFromArray(input, 0, input.length - 1);
    }
    
    public static binTreeNode makeTreeFromArray(int[] input, int start, int end)
    {
        if(end < start){return null;}
        int mid = (start + end)/2;
        binTreeNode n = new binTreeNode(input[mid]);
        n.left = makeTreeFromArray(input, start, mid - 1);
        n.right = makeTreeFromArray(input, mid + 1, end);
        return n;
    }
    
    public static void testMakeTreeFromArray()
    {
        int[] array = new int[20];
        for(int i = 0; i<20; i++)
        {
            array[i] = i+1;
        }
        binTreeNode n = makeTreeFromArray(array);
        printTree(n);
    }
    
    public static void printTree(binTreeNode root)
    {
        
        if(root == null){return;}
        int level = 1;
        int c = 0;
        binTreeNode temp = root;
        Queue<binTreeNode> q = new LinkedList<binTreeNode>();
        q.add(temp);
        while(!q.isEmpty())
        {
            temp = q.remove();
            System.out.print(temp.value + " ");
            if(temp.left != null){q.add(temp.left);}
            if(temp.right != null){q.add(temp.right);}
            c++;
            if(c >= level){level = level*2; System.out.println(""); c = 0;}
        }
    }
    
    public static void testPrintTree()
    {
        binTreeNode root = new binTreeNode(0);
        root.left = new binTreeNode(1);
        root.right = new binTreeNode(2);
        root.left.left = new binTreeNode(3);
        root.left.right = new binTreeNode(4);
        root.right.left = new binTreeNode(5);
        root.right.right = new binTreeNode(6);
        root.left.left.left = new binTreeNode(7);
        printTree(root);
    }
    
    public static binTreeNodeWParent nextNodeInOrder(binTreeNodeWParent root)
    {
        if(root == null)
        {
            return null;
        }
        
        if(root.right != null)
        {
            return leftMostChild(root.right);
        }
        else
        {
            binTreeNodeWParent top = root.parent;
            binTreeNodeWParent bottom = root;
        
            while(top != null && top.left != bottom)
            {
                bottom = top;
                top = bottom.parent;
            }
        
            return top;
        }
    }
    
    public static binTreeNodeWParent leftMostChild(binTreeNodeWParent root)
    {
        if(root == null){return null;}
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    
    public static void testNextNodeInOrder()
    {
     binTreeNodeWParent root = new binTreeNodeWParent(0);   
     root.addNode(1);
     root.addNode(2);
     root.left.addNode(3);
     root.left.addNode(4);
     root.right.addNode(5);
     root.right.addNode(6);
     root.left.left.addNode(7);
     root.left.left.addNode(8);
     root.left.right.addNode(9);
     root.left.right.addNode(10);
     root.right.left.addNode(11);
     root.right.left.addNode(12);
     root.right.right.addNode(13);
     root.right.right.addNode(14);
     
     printTreeParent(root);
     binTreeNodeWParent output = nextNodeInOrder(root.left.left.right);
     System.out.println(output.value);
    }
    
    public static void printTreeParent(binTreeNodeWParent root)
    {
        
        if(root == null){return;}
        int level = 1;
        int c = 0;
        binTreeNodeWParent temp = root;
        Queue<binTreeNodeWParent> q = new LinkedList<binTreeNodeWParent>();
        q.add(temp);
        while(!q.isEmpty())
        {
            temp = q.remove();
            System.out.print(temp.value + " ");
            if(temp.left != null){q.add(temp.left);}
            if(temp.right != null){q.add(temp.right);}
            c++;
            if(c >= level){level = level*2; System.out.println(""); c = 0;}
        }
        
    }
    
    public static void testPrintTreeParent()
    {
        binTreeNodeWParent root = new binTreeNodeWParent(0);   
        root.addNode(1);
        root.addNode(2);
        root.left.addNode(3);
        root.left.addNode(4);
        root.right.addNode(5);
        root.right.addNode(6);
        root.left.left.addNode(7);
        root.left.left.addNode(8);
        root.left.right.addNode(9);
        root.left.right.addNode(10);
        root.right.left.addNode(11);
        root.right.left.addNode(12);
        root.right.right.addNode(13);
        root.right.right.addNode(14);
        printTreeParent(root);
    }
    

        
    public static ArrayList<LinkedList<binTreeNode>> makeListsFromNodeLevels(binTreeNode root)
    {
        if(root == null){return null;}
        int level = 1;
        int c = 0;
        binTreeNode temp = root;
        Queue<binTreeNode> q = new LinkedList<binTreeNode>();
        LinkedList<binTreeNode> current = new LinkedList<binTreeNode>();
        ArrayList<LinkedList<binTreeNode>> result = new ArrayList<LinkedList<binTreeNode>>();
        q.add(temp);
        while(!q.isEmpty())
        {
            temp = q.remove();
            current.add(temp);
            if(temp.left != null){q.add(temp.left);}
            if(temp.right != null){q.add(temp.right);}
            c++;
            if(c >= level)
            {
                level = level*2;
                c = 0;
                result.add(current);
                current = new LinkedList<binTreeNode>();
            }
        }
        if(current.get(0) != null)
        {
            result.add(current);
        }
        return result;
    }
        
    public static void testMakeListsFromNodeLevels()
    {
        binTreeNode root = new binTreeNode(0);
        root.left = new binTreeNode(1);
        root.right = new binTreeNode(2);
        root.left.left = new binTreeNode(3);
        root.left.right = new binTreeNode(4);
        root.right.left = new binTreeNode(5);
        root.right.right = new binTreeNode(6);
        root.left.left.left = new binTreeNode(7);
        
        ArrayList<LinkedList<binTreeNode>> n = makeListsFromNodeLevels(root);
        LinkedList<binTreeNode> one = n.get(0);
        LinkedList<binTreeNode> two = n.get(1);
        LinkedList<binTreeNode> three = n.get(2);
        LinkedList<binTreeNode> four = n.get(3);
        
        System.out.println(one.get(0).value);
        System.out.println(two.get(0).value);
        System.out.println(three.get(0).value);
        System.out.println(four.get(0).value);
    }
    
    public static boolean checkForBalancedTree(binTreeNode root)
    {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
    
    public static int checkHeight(binTreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE){return Integer.MIN_VALUE;}
        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE){return Integer.MIN_VALUE;}
        
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if(heightDiff > 1)
        {
            return Integer.MIN_VALUE;
        }
        else
        {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    public static void testCheckForBalancedTree()
    {
        binTreeNode root = new binTreeNode(0);
        root.left = new binTreeNode(1);
        root.right = new binTreeNode(2);
        root.left.left = new binTreeNode(3);
        root.left.right = new binTreeNode(4);
        root.right.left = new binTreeNode(5);
        root.right.right = new binTreeNode(6);
        root.left.left.left = new binTreeNode(7);
        //root.left.left.left.left = new binTreeNode(13);  //returns false when this line is active and tree becomes unbalanced
        System.out.println(checkForBalancedTree(root));
    }
    
    public static boolean checkIfBST(binTreeNode root)
    {
        return checkIfBST(root, null, null);
    }
    
    public static boolean checkIfBST(binTreeNode node, Integer min, Integer max)
    {
        if(node == null){return true;}
        if((min != null && node.value <= min) || (max != null && node.value > max))
        {
            return false;
        }
        if(!checkIfBST(node.left, min, node.value) || !checkIfBST(node.right, node.value, max))
        {
            return false;
        }
        return true;
    }
    
    public static void testCheckIfBST()
    {
        binTreeNode root = new binTreeNode(20);
        root.left = new binTreeNode(10);
        root.right = new binTreeNode(30);
        root.left.left = new binTreeNode(5);
        root.left.right = new binTreeNode(15);
        root.right.left = new binTreeNode(25);
        root.right.right = new binTreeNode(35);
        root.left.left.left = new binTreeNode(2);
        //root.left.left.right = new binTreeNode(3); //returns false when this line is active and tree breaks rule for binary search tree
        System.out.println(checkIfBST(root));
    }
    
    public static jGraph buildGraph(String[] projects, String[][] dependancies)
    {
        jGraph graph = new jGraph();
        for(String project : projects)
        {
            graph.getOrCreateNode(project);
        }
        String first, second;
        for(String dependancy[] : dependancies)
        {
            first = dependancy[0];
            second = dependancy[1];
            graph.addEdge(first, second);
        }
        return graph;
    }
    
    public static jProject[] orderProjects(ArrayList<jProject> projects)
    {
        jProject[] ordered = new jProject[projects.size()];
        int listEnd = addNonDependent(ordered, projects, 0);
        int toBeProc = 0;
        while(toBeProc < ordered.length)
        {
            jProject current = ordered[toBeProc];
            if(current == null)
            {
                return null;
            }
            ArrayList<jProject> children = current.getChildren();
            for(jProject child : children)
            {
                child.minusDepend();
            }
            listEnd = addNonDependent(ordered, children, listEnd);
            toBeProc++;
        }
        return ordered;
    }
    
    public static int addNonDependent(jProject[] ordered, ArrayList<jProject> projects, int indNum)
    {
        for(jProject project : projects)
        {
            if(project.getDependNum() == 0)
            {
                ordered[indNum] = project;
                indNum++;
            }
        }
        return indNum;
    }
    
    public static jProject[] findBuildOrder(String[] projects, String[][] dependancies)
    {
        jGraph graph = buildGraph(projects, dependancies);
        return orderProjects(graph.getNodes());
    }
    
    public static void testFindBuildOrder()
    {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] depends = new String[][] {{"a" , "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        
        jProject[] ordered = findBuildOrder(projects, depends);
        for(jProject order : ordered)
        {
            System.out.print(order.getName() + " ");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//END BRACKET
