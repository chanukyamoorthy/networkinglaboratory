#include<bits/stdc++.h>
using namespace std;
struct Node{
	    int data;
        bool isToken_holder;
        struct Node* next;
};
int num=0;
Node* head=NULL;


void print_active_node()
{
   bool flag=true;
   Node* temp=head;
   while(temp)
   {
	cout<<temp->data;
	if(temp->isToken_holder)
		cout<<"(Master of Ring)";
	cout<<"-->";
        flag=false;
	temp=temp->next;
   }
   if(flag)
	cout<<"NULL";
   cout<<endl;
}
void insert_node(int x)
{
    Node* temp=new Node;
    temp->data=x;
    temp->isToken_holder=false;
    temp->next=NULL;
    if(head==NULL)
    {
	head=temp;
	head->isToken_holder=true;
	return;
    }
    Node* ptr=head;
    while(ptr->next)
	ptr=ptr->next;
    ptr->next=temp; 
    num++;  
}
void delete_node(int x)
{
   if(head==NULL)
   {
	cout<<"No node is active.";
	return;
   }
   Node* temp=head;
   if(head->data==x)
   {
	if(head->isToken_holder)
		if(head->next)
			head->next->isToken_holder=true;	
	head=head->next;
	delete(temp);
	return;
   }

   Node* prev;
   while(temp)
   {
	if(temp->data==x && temp->isToken_holder)
	{
	    if(temp->next)
	    {
		temp->next->isToken_holder=true;
            }
	    else
	    {
		head->isToken_holder=true;
            }
	}
	if(temp->data==x)
	{
	  prev->next=temp->next;
          delete(temp);
	  return;
	}
	
        prev=temp;
	temp=temp->next;
   }
}
void pass_token()
{
   if(head==NULL)
   {
	cout<<"No one is active."<<endl;
	return;
   }
   Node* temp=head;
   while(temp)
   {
	if(temp->isToken_holder)
	{
	   temp->isToken_holder=false;
	   if(temp->next)
		temp->next->isToken_holder=true;
	   else
		head->isToken_holder=true;
	   return;
	}
	temp=temp->next;
   }
}
int main()
{
   while(1)
   {
   	cout<<"The logical ring present now is : ";
   	print_active_node();
   	cout<<"What do you want to do ?"<<endl;
   	cout<<"1. Insert node"<<endl;
   	cout<<"2. Delete node"<<endl;
	cout<<"3. Pass token"<<endl;
   	int k;
   	cin>>k;
   	int x;
   
   	switch(k)
   	{
		    case 1 : cout<<"which one u want to make active ? ";
                     cin>>x;
                 	 insert_node(x);
                 	 break;

        	case 2 : cout<<"which node u want to delelte ? ";
                 	cin>>x;
                 	delete_node(x);
                 	break;
		    case 3 :cout<<"Passing the token to next ready node \n";
			        pass_token();
			        break;
        	default: break;
   	}
   }
   return 0;
}
