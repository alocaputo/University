#include <stdio.h>

int main()
{
    int x,y,i;

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
    for(i=0;i<=y-1;i++){
      c[i+x] = b[i];
    }
    
    int l = x +y;        // length[c]
    comm(c,med(c,l),l);

    return 0;
}

//-------Calcolo valore medio------------
int med(int a[],int l){     
    int c=0,m=0,i=0;
    
    for(i=0;i<l;i++){
      c = c + a[i];         
    }
    
    m = c/l;;
    return m;
    return 0;
}

int comm(int a[],int m,int l){
    int i=0,p=0,c=0;
    int q= l-1;
    int sa[p],sb[l-p];
    
    
    if(l>2){
        for(i=0;i<l;i++){
           if(a[i]<=m){         
              sa[p] = a[i];     //Array contenete valori <= m
               p = p + 1;
        }else{
              sb[c] = a[i];     //Array contenete valori > m
              c = c + 1;
              q= q -1;
        }
      }

    int la = p;                 //length[sa]
    int lb = l-p;               //length[sb]
     comm(sa,med(sa,la),la);
     comm(sb,med(sb,lb),lb);

    
    }else if(l==2 && a[0]==a[1]){   //Numero comune
        printf("Common values are: ");
        printf("%d ",a[0]);
        }
        return 0;
}
