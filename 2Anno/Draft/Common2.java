  import java.util.*;
public class common {
  
  static int temp;
  
  public static void main (String[] args) {    

    int[] a = {94,77,2,37,32,89,15,5,38,51,58,3,66,27,3,1,58,77,11,36};
    div(a,med(a));
    
  }
    public static int med(int[] a){
    int c=0;
    int m;
    int l = a.length;
    for(int i=0;i<l;i++){
      c = c + a[i];
    }
    
    m = c/l;
    return m;
    }
    
    public static void div(int[] a,int m){
      
      int q = a.length-1;
      int l = a.length;
      int[] b = new int[l];
      int p = 0;
      if( l>2){
      for(int i=0;i<l;i++){
        if(a[i]<=m){
          p = p + 1;
          b[p-1] = a[i];
        }else{
          q= q -1;
          b[q+1] = a[i];
        }
      }
      int[] sb = Arrays.copyOfRange(b, 0, p);
      int[] sc = Arrays.copyOfRange(b, p, l);
      div(sb,med(sb));
      div(sc,med(sc));
      }else if(l==2 && a[0]==a[1]){
        System.out.print(a[0]+", ");
        }
    }

}
