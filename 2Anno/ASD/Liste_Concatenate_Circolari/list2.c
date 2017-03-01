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
 gli elementi da standard input. Non Ã¨ necessario che gli elementi
 vengano inseriti nella lista nell'ordine in cui vengono letti.*/
list get_list();

/* La procedura print_standard_list(list l) stampa su standard output gli interi presenti in una lista
 concatentata standard l.*/
void print_standard_list(list);

/* La funzione make_circular_list(list l, int k) trasforma la lista concatenata standard l in una lista
 circolare contentente tutti e soli gli elementi di l e avente prefisso di lunghezza k.
 In particolare, il k+1-esimo elemento della lista l Ã¨ quello che diventa successore di due
 elementi distinti. Se k+1<=0 o k+1 Ã¨ maggiore della
 lunghezza della lista, la lista restituita in output sarÃ  la lista standard l.*/
list make_circular_list(list,int k);


/* La funzione test_is_circular(list l) stabilisce se la lista l Ã¨ circolare o meno.
 Se la lista non Ã¨ circolare viene restituito in output -1. Se la lista Ã¨ circolare viene
 restituito in output un valore maggiore o uguale alla lunghezza del prefisso
 della lista circolare.*/
int test_is_circular_list(list);


/* La procedura print_circular_list(list l, int k) stampa su standard output gli interi contenuti
 nella lista circolare l avente prefisso di lunghezza al piÃ¹ k separandoli in due blocchi:
 i primi k elementi; i successivi j elementi che formano il ciclo. Se k Ã¨ maggiore rispetto alla
 lunghezza del prefisso Ã¨ lecito stampare piÃ¹ volte un elemento.*/
void print_circular_list(list,int k);

/* La procedura free_memory_list(list l) libera la memoria allocata nello heap per la lista l.
 L'implementazione di questa procedura Ã¨ opzionale*/
// void free_memory_list(list);

list get_list()
{
   struct list_el *p, *punt;
   int i, n;

   printf("\n Inserisci la lunghezza della lista: ");
   scanf("%d", &n);

     if(n==0)
   {
      p = NULL; // lista vuota
       } else {
      /* creazione primo elemento */
      p = (struct list_el *)malloc(sizeof(struct list_el));
      printf("\nInserisci il primo valore: ");
      scanf("%d", &p->key);
      punt = p;
            /* creazione elementi successivi */
      for(i=2; i<=n; i++)
      {
         punt->next = (struct list_el *)malloc(sizeof(struct list_el));
         punt = punt->next;
         printf("\nInserisci il %d elemento: ", i);
         scanf("%d", &punt->key);
      } // chiudo il for
      punt->next = NULL; // marcatore fine lista
   } // chiudo l’if-else
   return(p);
} // chiudo la funzione

void print_standard_list(list p)
{
   printf("\nlista: ");

   /* ciclo di scansione */
   while(p != NULL)
   {
      printf("%d", p->key); // visualizza l’informazione
      printf("->");
      p = p->next; // scorre di un elemento
   }

   printf("NULL\n\n");
}

list make_circular_list(list p,int k)
{
    struct list_el *temp = p;
    struct list_el *he = p;
    int i=0;

    while (temp->next != NULL)
    {

        temp = temp->next;
    }
    for(i=0;i<k;i++){
    he = he->next;
    }
    temp->next = he;
    /*After this the singly linked list is now circular*/
    return(p);
}

void print_circular_list(struct list_el *head,int k)
{
    struct list_el *temp = head;
    int i=0;
    printf("lista:  ");
    printf("%d->", temp->key);
    temp = temp->next;
    while (i<k-1)
    {
        printf("%d->", temp->key);
        temp = temp->next;
        i++;
    }
    i=0;
    printf(" then: ");
    while(i<10){
            printf("%d->", temp->key);
        temp = temp->next;
        i++;

    }
}

int test_is_circular_list(list p)
{
   struct list_el *slower, * faster;
   slower = p;
   faster = p->next; //start faster one node ahead
   while(1) {

     // if the faster pointer encounters a NULL element
     if( !faster || !faster->next)
       return -1;
    //if faster pointer ever equals slower or faster's next
    //pointer is ever equal to slow then it's a circular list
     else if (faster == slower || faster->next == slower)
        return 1;
     else{
       // advance the pointers
        slower = slower->next;
        faster = faster->next->next;
      }
   }
}

int main()
{
int c,k;
   struct list_el *lista; // puntatore della lista
   lista = get_list(); // crea la lista
   print_standard_list(lista); // stampa la lista
   printf("\nRendere la lista circolare? (1/0) ");
   scanf("%d", &c);
   if(c==1){
    printf("\nIserisci k ");
    scanf("%d", &k);
    make_circular_list(lista,k);
    print_circular_list(lista,k);
   }else{
   }
   test_is_circular_list(lista);
   //return(0);

}
