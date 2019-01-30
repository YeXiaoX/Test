package Test;

/**
 * Created by yexiaoxin on 2017/8/2.
 */
public class KuaipaiSort {
    public static void sort(int aa[],int start,int end){
        if(start<0||end>=aa.length||start>=end)return;
        int x = start;
        int y = end;
        int z = y;
        while(y>x){
            while(aa[x]<=aa[z]&&x<z)x++;
            if(aa[x]>aa[z]){
                int temp = aa[x];
                aa[x] = aa[z];
                aa[z] = temp;
                z=x;
            }
            while(aa[y]>=aa[z]&&y>z)y--;
            if (aa[y]<aa[z]) {
             int temp = aa[y];
             aa[y] =aa[z];
             aa[z] = temp;
             z=y;
            }
        }
        sort(aa,start,z-1);
        sort(aa,z,end);
    }

    public static void main(String args[]){
        int aa[]={2,1,4,5,22,5,21,12,6};
        sort(aa,0,8);
        for(int i=0;i<aa.length;i++) {
            System.out.println(aa[i]);
        }
    }
}
