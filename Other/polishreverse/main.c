#include <stdio.h>
#include<string.h>
int main(void) {
 char q[400],stack[400],str[400],ch;
 int n,top,i,front;
 scanf("%d",&n);
 while(n--)
 {
 front  = 0;
 top = 0;
 scanf("%s ",str);
 for(i=0;i<strlen(str);i++)
 {
           if(str[i]!='+'&&str[i]!='-'&&str[i]!='*'&&str[i]!='/'&&str[i]!='^'&&str[i]!='('&&str[i]!=')')
           {
              q[front++] = str[i];
           }
           else
           {
               if(str[i]=='+')
               {
                  while(top>0)
                  {
                   ch = stack[top-1];
                   if(ch != '(')
                   {
                      q[front++] = ch;
                      top--;
                   }
                   else
                     break;
                  }
               }
               else if(str[i]=='-')
               {
                  while(top>0)
                  {
                   ch = stack[top-1];
                   if(ch != '+'&&ch != '(')
                   {
                       q[front++] = ch;
                       top--;
                   }
                   else
                      break;
                  }
               }
               else if(str[i]=='*')
               {
                  while(top>0)
                  {
                   ch = stack[top-1];
                   if(ch != '+'&&ch != '-'&&ch != '(')
                   {
                       q[front++] = ch;
                       top--;
                   }
                   else
                     break;
                  }
               }
               else if(str[i]=='/')
               {
                  while(top>0)
                  {
                   ch = stack[top-1];
                   if(ch != '+'&&ch != '-'&&ch != '*'&&ch != '(')
                   {
                       q[front++] = ch;
                       top--;
                   }
                   else
                     break;
                  }
               }
               else if(str[i]=='^')
               {
                  while(top>0)
                  {
                   ch = stack[top-1];
                   if(ch != '+'&&ch != '-'&&ch != '*'&&ch != '/'&&ch != '(')
                   {
                       q[front++] = ch;
                       top--;
                   }
                    else
                      break;
                  }
               }
               else if(str[i]==')')
               {
                  while(stack[top-1]!='(')
                  {
                   ch = stack[top-1];
                   q[front++] = ch;
                   top = top -1;
                  }
                  top = top - 1;
               }
               if(str[i] !=')')
                  stack[top++] = str[i];
           }
 }
 while(top>0)
 {
    q[front++] =  stack[top-1] ;
    top = top-1;
 }
 q[front] = ' ';
 printf("%s\n",q);
 }
 return 0;
}
