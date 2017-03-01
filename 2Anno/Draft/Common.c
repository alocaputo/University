#include <stdio.h>

int main()
{
    int x,y,i,j,temp;

    printf("Length of the arrays A and B: ");
    scanf("%d %d", &x, &y);
    int a[x];
    int b[y];
    int c[x+y];
    
    printf("A array values: ");
    for(i=0;i<x;i++){
        scanf("%d",&a[i]);
    }

    printf("B array values: ");
    for(i=0;i<y;i++){
        scanf("%d",&b[i]);
    }
    
    //-----Merge A and B into C--------
    
    for(i=0;i<=x-1;i++){
      c[i] = a[i];
    }
    for(j=0;j<=y-1;j++){
      c[j+x] = b[j];
    }
 
    //----Do Insertion Sort-------------
    
    for ( i = 1; i < x+y; i++) {
      for( j = i ; j > 0 ; j--){
        if(c[j] < c[j-1]){
          temp = c[j];
          c[j] = c[j-1];
          c[j-1] = temp;
        }
      }
    }
    
    //-----Search for common values------
    printf("The common values are: ");
    for(i=0;i<x+y-1;i++){
      if(c[i]== c[i+1]){
         
        printf("%d, ",c[i]);
      }
    }
    
    return 0;
}
