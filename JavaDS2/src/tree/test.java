package tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class test
{
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        BinaryTree.BTNode root=binaryTree.createBinaryTree();

        System.out.println(binaryTree.tree2str(root));
    }
}
