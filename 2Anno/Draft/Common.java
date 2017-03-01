public class Common {
  
  static int temp;
  
  public static void main (String[] args) {    

    int[] a = {10,34,2,56,7,67,88};
    int[] b = {12,2,88};
    int[] c = new int[a.length+b.length]; 
    
    for(int i=0;i<=a.length-1;i++){
      c[i] = a[i];
    }
    
    for(int j=0;j<=b.length-1;j++){
      c[j+a.length] = b[j];
    }

    for (int o = 1; o < c.length; o++) {
      for(int p = o ; p > 0 ; p--){
        if(c[p] < c[p-1]){
          temp = c[p];
          c[p] = c[p-1];
          c[p-1] = temp;
        }
      }
    }
      
    for(int k=0;k<c.length-1;k++){
      if(c[k]== c[k+1]){
        System.out.print(c[k] + " ");
      }
    }
  }
}

  
