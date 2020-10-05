import java.util.Arrays;

/**
 * Created by wangxy on 18/3/2.
 */
public class Sorts {

    public static int[] insertValue(int [] array ,int b){

        int i;
        array = Arrays.copyOf(array , array.length+1);
        for(i=array.length-2;i>=0;i--){
            if(array[i]>b){
                array[i+1] = array[i];
            }else {
                break;
            }
        }
        array[i+1] = b;
        return array;
    }

    public static void main(String [] args){
        //int [] a = {10,20,30,40};
        //a = insertValue(a,5);
        int [] a = {2,30,1,50,45,60};
        sorts(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sorts(int [] a){
        int j,t;
        for(int i=1;i<a.length;i++){
             t = a[i];
            for(j=i-1;j>=0;j--){
                if(t < a[j]){
                   a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = t;
        }
    }
}
