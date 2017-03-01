#include <stdio.h>
#include <stdlib.h>

// Generico elemento di una lista
typedef struct list_el{
    int key;
    struct list_el* next;
    
}list_element;

// Generica lista
typedef list_element* list;


/* La funzione get_list() costruisce una lista standard di interi leggendone la lunghezza e
 gli elementi da standard input. Non è necessario che gli elementi
 vengano inseriti nella lista nell'ordine in cui vengono letti.*/
list get_list();
    item * curr, * head;
   int i;

   head = NULL;

   for(i=1;i<=10;i++) {
      curr = (item *)malloc(sizeof(item));
      curr->val = i;
      curr->next  = head;
      head = curr;
   }

   curr = head;

   while(curr) {
      printf("%d\n", curr->val);
      curr = curr->next ;
   }

/* La procedura print_standard_list(list l) stampa su standard output gli interi presenti in una lista
 concatentata standard l.*/
void print_standard_list(list);

/* La funzione make_circular_list(list l, int k) trasforma la lista concatenata standard l in una lista
 circolare contentente tutti e soli gli elementi di l e avente prefisso di lunghezza k. 
 In particolare, il k+1-esimo elemento della lista l è quello che diventa successore di due 
 elementi distinti. Se k+1<=0 o k+1 è maggiore della
 lunghezza della lista, la lista restituita in output sarà la lista standard l.*/
list make_circular_list(list, int);


/* La funzione test_is_circular(list l) stabilisce se la lista l è circolare o meno.
 Se la lista non è circolare viene restituito in output -1. Se la lista è circolare viene 
 restituito in output un valore maggiore o uguale alla lunghezza del prefisso
 della lista circolare.*/
int test_is_circular_list(list);


/* La procedura print_circular_list(list l, int k) stampa su standard output gli interi contenuti
 nella lista circolare l avente prefisso di lunghezza al più k separandoli in due blocchi:
 i primi k elementi; i successivi j elementi che formano il ciclo. Se k è maggiore rispetto alla 
 lunghezza del prefisso è lecito stampare più volte un elemento.*/
void print_circular_list(list,int);

/* La procedura free_memory_list(list l) libera la memoria allocata nello heap per la lista l.
 L'implementazione di questa procedura è opzionale*/
// void free_memory_list(list);

int main(){
    
    list my_list=NULL;
//  list your_list;
    int prefix, mag_prefix;
    

/*
    printf("%p \n",&my_list);
    
    printf("%p \n", my_list);
*/

 
 /*   
    printf("%d \n",(*my_list).key);
    
*/
    
    my_list = get_list();
    

/*
    printf("%p \n",&my_list);
    
    printf("%p \n",my_list);
    
    printf("%d \n",(*my_list).key);
    
    printf("%d \n",my_list->key);

*/
    
    print_standard_list(my_list);
    
    printf("Si vuole trasformare la lista standard in una lista circolare avente prefisso di lunghezza? \n");
    
    scanf("%d",&prefix);

    my_list=make_circular_list(my_list,prefix);
    
    if((mag_prefix=test_is_circular_list(my_list))!=-1)
        print_circular_list(my_list, mag_prefix);
    else
        print_standard_list(my_list);
    

    
/*  OPZIONALE
      
    free_memory(my_list);
    
    
    printf("%p \n",&my_list);
    
    printf("%d \n",my_list->key);
    
    printf("%d \n",my_list->next->key);
    
    your_list=malloc(sizeof(list_element));

    your_list->key=100000;
 
    printf("%d \n",my_list->key);

*/
    
    return 0;
}

