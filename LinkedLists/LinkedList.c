#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>

struct LinkedList *addNode(struct LinkedList *, int);
int size(struct LinkedList *);
void printList(struct LinkedList *);
int isEmpty(struct LinkedList *);
struct LinkedList *allocNode();

struct LinkedList{
	int data;
	struct LinkedList *next;
};

int main(){
	struct LinkedList *head;
	head = addNode(head, 5);
	head = addNode(head, 7);
	printList(head);
	
	return 0;
}
struct LinkedList *addNode(struct LinkedList *p, int data){
	if(isEmpty(p)){
		p = allocNode(); //Allocate room in memory
		p->data = data;
		p->next = NULL;
	}
	else{
		p->next = addNode(p->next, data);
	}
	return p;
}
int isEmpty(struct LinkedList *p){
	return (p==NULL);
}
int size(struct LinkedList *p){
	int count = 0;
	
	while(!isEmpty(p)){
		count++;
		p = p->next;
	}
	return count;

}
void printList(struct LinkedList *p){
	int i;
	int x = size(p);
	for(i = 1; i <= x; i++){
		printf("Node %d: %d\n", i, p->data);	
		p = p->next;	
	} 
}
struct LinkedList *allocNode(){
	return (struct LinkedList *) malloc(sizeof(struct LinkedList));
}
