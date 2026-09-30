/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Node curr = node;
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> oldToNewNode = new HashMap<>();
        queue.add(curr);
        oldToNewNode.put(curr, new Node(curr.val));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k<size; k++){
                Node oldParent = queue.poll();
                Node newParent = oldToNewNode.get(oldParent);
                List<Node> children = oldParent.neighbors;
                for(int i = 0; i<children.size(); i++){
                    Node oldNode = children.get(i);
                    Node newNode;
                    if(!oldToNewNode.containsKey(oldNode)){
                        newNode = new Node(oldNode.val);
                        queue.add(oldNode);
                        oldToNewNode.put(oldNode, newNode);
                    } else {
                        newNode = oldToNewNode.get(oldNode);
                    }
                    newParent.neighbors.add(newNode);
                }
            }
        }
        return oldToNewNode.get(node);
    }
}