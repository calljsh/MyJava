package searchtree;

public class Test
{
    public static void main(String[] args) {
        int [] arr= {5,7,2,10,6,3};
        SearchTree searchTree = new SearchTree();
        for(int i=0;i<6;i++)
        {
            searchTree.insert(arr[i]);
        }
        searchTree.remove(7);
        System.out.println("2fer");
    }
}
