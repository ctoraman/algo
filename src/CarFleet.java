/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */
import java.util.*;

public class CarFleet {
    public static class Node {
        int position, speed;
        Node() {}
        Node(int p, int s) {
            position = p;
            speed = s;
        }
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        //1- sort cars -O(nlogn)
        PriorityQueue<Node> carsSorted = new PriorityQueue<>((x,y) -> Integer.compare(x.position, y.position));
        for(int i=0; i<position.length; i++){
            carsSorted.add( new Node(position[i],speed[i]));
        }

        //2- process each car for fleets -O(n)
        Stack<Node> fleets = new Stack<>();
        while(!carsSorted.isEmpty()){
            Node c = carsSorted.remove();
            if(!fleets.isEmpty()){
                Node f = fleets.peek();
                while( f.speed > c.speed && (c.position + c.speed*Math.abs((float)(f.position - c.position)/(f.speed - c.speed))) <= target){
                    fleets.pop();
                    if( !fleets.isEmpty()) {
                        f = fleets.peek();
                    }else{
                        break;
                    }
                }
            }
            fleets.push(c);
        }

        //3- output is stack's size -O(1)
        return fleets.size();
    }

    public static void main(String[] args) {
//        int target = 12;
//        int[] position = {10,8,0,5,3};
//        int[] speed = {2,4,1,1,3};
//        int target = 100;
//        int[] position = {0,2,4};
//        int[] speed = {4,2,1};
//        int target = 10;
//        int[] position = {0,4,2};
//        int[] speed = {2,1,3};
//        int target = 12;
//        int[] position = {10,8,0,5,3};
//        int[] speed = {2,4,1,1,3};
//        int target = 12;
//        int[] position = {4,0,5,3,1,2};
//        int[] speed = {6,10,9,6,7,2}; //expected:4
        int target = 13;
        int[] position = {10,2,5,7,4,6,11};
        int[] speed = {7,5,10,5,9,4,1}; //expected:2
        int output = carFleet(target, position, speed);
        System.out.println(output);
        //Runtime: 106 ms, faster than 29.84% of Java online submissions for Car Fleet.
        //Memory Usage: 50.4 MB, less than 80.87% of Java online submissions for Car Fleet.
    }
}
