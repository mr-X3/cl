/*Philosopher*/
import java.io.IOException;

class Philosopher
{
	
    public static void main(String args[])throws IOException
    {
    	Philo d=new Philo();
		for(int i=0;i<5;i++)
		d.pickup(i);
		for(int i=0;i<5;i++)
		d.putdown(i);
	}
}
=============================
/*Chopstick*/

import java.io.*;
class Philo
{
int state[]=new int[5];
int thinking,eating,hungry;
void Op()
{
	thinking=0;
	eating=1;
	hungry=2;
}
public void pickup(int i)
{
	state[i]=2;
	System.out.println("Philosopher "+i+" is hungry");
	test(i);
	if(state[i]==2)
	System.out.println("Philosopher "+i+" is waiting");
}
public void putdown(int i)
{
	 if(state[i]==1)
     {
       state[i]=0;
       System.out.println("Philosopher"+i+" is thinking");
       test((i+1)%5);
       test((i+5)%5);
	 }
}

public void test(int i)
{
	if(state[i]==2 && state[(i+1)%5]!=1 && state[(i+4)%5]!=1)
    {
        state[i]=1;
        System.out.println("philosopher "+i+" is eating");
     }
}
}
========================================
/*
gescoe@gescoe-OptiPlex-3010:~/Desktop/twi$ javac Chopstick.java
gescoe@gescoe-OptiPlex-3010:~/Desktop/twi$ javac Philosopher.java
gescoe@gescoe-OptiPlex-3010:~/Desktop/twi$ java Chopstick
Error: Could not find or load main class Chopstick
gescoe@gescoe-OptiPlex-3010:~/Desktop/twi$ java Philosopher
Philosopher 0 is hungry
philosopher 0 is eating
Philosopher 1 is hungry
Philosopher 1 is waiting
Philosopher 2 is hungry
philosopher 2 is eating
Philosopher 3 is hungry
Philosopher 3 is waiting
Philosopher 4 is hungry
Philosopher 4 is waiting
Philosopher0 is thinking
Philosopher2 is thinking
philosopher 3 is eating
Philosopher3 is thinking
philosopher 4 is eating
Philosopher4 is thinking
gescoe@gescoe-OptiPlex-3010:~/Desktop/twi$ ^C
gescoe@gescoe-OptiPlex-3010:~/Desktop/twi$ 
*/
