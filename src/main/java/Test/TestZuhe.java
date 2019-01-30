package Test;

import java.util.List;

/**
 * Created by yexiaoxin on 2017/9/14.
 */
public class TestZuhe {
  public static void zuhe(int aa[],int n,List<Integer> list,int start){
      if(list.size()==n){
          System.out.println(list);
      }
      for(int i=start;i<aa.length;i++){
          if(!list.contains(aa[i])){
              list.add(aa[i]);
          }
          start++;
          zuhe(aa,n,list,start);
      }
  }
}
