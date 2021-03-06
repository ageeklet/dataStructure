# Java版数据结构_学习笔记

##  1、数组

### （1）普通的面向过程的程序

> ArrayApp.java：

```java
public class ArrayApp {
		public static void main(String[] args) {
			long[] arr = new long[100];
			int nElems = 0;
			int j;
			long searchKey;
			
			//给数组中插入几条数据
			arr[0]=77;
			arr[1]=99;
			arr[2]=44;
			arr[3]=55;
			arr[4]=22;
			arr[5]=88;
			arr[6]=11;
			arr[7]=00;
			arr[8]=66;
			arr[9]=33;
			nElems=10;
			
			//显示数组内容
			for(j=0;j<nElems;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println(" ");			
			//查询数组中内容
			searchKey = 66;
			for(j=0;j<nElems;j++) {
				if(arr[j]==searchKey) {
					break;
				}
			}
			if(j==nElems) {
				System.out.println("Can`t find "+searchKey);
			}else {
				System.out.println("Found "+searchKey);
			}
			
			//删除数组中的内容
			searchKey=55;
			for(j=0;j<nElems;j++) {
				if(arr[j]==searchKey) {
					break;
				}
			}
			for(int k=j;k<nElems;k++) {
				arr[k]=arr[k+1];
			}
			nElems--;
			
			//显示删除后的数组内容
			for(j=0;j<nElems;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println(" ");
		}
}

```

> 程序输出如下：

```
77 99 44 55 22 88 11 0 66 33  
Found 66
77 99 44 22 88 11 0 66 33 
```

> 该程序是一个老式的面向过程的程序，使之面向对象化可以让程序更加易懂。
>
> 下面将通过两个步骤逐步的介绍面向对象的方法：
>
> ​	1：将数据存储结构（数组）从程序中分离出来。程序的其他部分称为使用这个结构的用户。
>
> ​	2：改进存储结构和用户之间的通信。

###  （2）将程序划分成类

> LowArray.java：

```java
public class LowArray {
	private long[] a;
	public LowArray(int size) {
		a = new long[size];
	}
	public void setElem(int index,long value) {
		a[index]=value;
	}
	public long getElem(int index) {
		return a[index];
	}
}

```

> LowArrayApp.java：

```java
public class LowArrayApp {
	public static void main(String[] args) {
		LowArray lowArray = new LowArray(100);
		int nElems = 0;
		int j ;
		lowArray.setElem(0, 77);
		lowArray.setElem(1, 99);
		lowArray.setElem(2, 44);
		lowArray.setElem(3, 55);
		lowArray.setElem(4, 22);
		lowArray.setElem(5, 88);
		lowArray.setElem(6, 11);
		lowArray.setElem(7, 00);
		lowArray.setElem(8, 66);
		lowArray.setElem(9, 33);
		nElems = 10;
		//显示数组内容
		for(j=0;j<nElems;j++) {
			System.out.print(lowArray.getElem(j)+" ");
		}
		System.out.println(" ");
		//查询数组中内容
		int searchKey = 26;
		for(j=0;j<nElems;j++) {
			if(lowArray.getElem(j)==searchKey) {
				break;
			}
		}
		if(j==nElems) {
			System.out.println("Can`t find "+searchKey);
		}else {
			System.out.println("Found "+searchKey);
		}
		//删除数组中的内容
		searchKey=55;
		for(j=0;j<nElems;j++) {
			if(lowArray.getElem(j)==searchKey) {
				break;
			}
		}
		for(int k=j;k<nElems;k++) {
			lowArray.setElem(k, lowArray.getElem(k+1));
		}
		nElems--;
		//显示删除后的数组内容
		for(j=0;j<nElems;j++) {
			System.out.print(lowArray.getElem(j)+" ");
		}
		System.out.println(" ");
	}
}
```

> 运行结果：

```java
77 99 44 55 22 88 11 0 66 33  
Can`t find 26
77 99 44 22 88 11 0 66 33 
```

> LowArray.java中实际上将一个普通的Java数组封装进LowArray.java中，类中的数组隐藏了起来，他是私有的，所以只有LowArray.java中的方法才能访问到他。LowArray中有三个方法：setElem()和getElem(),分别是用来插入和检索一个数据项，另外一个方法是构造方法，使用创建一个特定的大小的空数组。
>
> 另一个类LowArrayApp创建了一个LowArray类的对象并用它存储和操作数据，可以将LowArray类想象成工具，LowArrayApp类是工具的使用者。
>
> 用来存储数据对象的类有时被称为容器类，例如LowArray.java中的LowArray类。通常容器类中不仅存放数据，并且提供访问数据的方法和其他诸如排序等复杂的操作。

### （3）类接口

> HighArray.java

```java
public class HighArray {
	private long[] a;
	private int nElems;
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	//查询数组内容
	public boolean find(long searchKey) {
		int j ;
		for(j=0;j<nElems;j++) {
			if(a[j]==searchKey) {
				break;
			}
		}
		if(j==nElems) {
			return false;
		}else {
			return true;
		}
	}
	//向数组中插入数据
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	//删除数组中的数据项
	public boolean delete(long value) {
		int j ;
		for(j=0;j<nElems;j++) {
			if(value==a[j]) {
				break;
			}
		}
		if(j==nElems) {
			return false;
		}else {
			for(int k=j;k<nElems;k++) {
				a[k]=a[k+1];
			}
			nElems--;
			return true;
		}
	}
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println(" ");
	}	
}
```

> HighArrayApp.java

```java
public class HighArrayApp {
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr = new  HighArray(maxSize);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		
		int searchKey = 55;
		if(arr.find(searchKey)) {
			System.out.println("Found "+ searchKey);
		}else {
			System.out.println("Can`t found "+searchKey);
		}
		
		arr.delete(33);
		arr.delete(00);
		arr.delete(99);
		
		arr.display();
	}
}
```

> 运行结果：

```
77 99 44 55 22 88 11 0 66 33  
Found 55
77 44 55 22 88 11 66  
```

> 从what（什么）中将how（如何）分离出来的过程，即类中的操作如进行，相对什么是类用户可见的，被称为抽象。抽象是软件工程中重要的方面。把类的功能抽象出来后，可以使程序设计更加简单，因为不需要在设计的初期就考虑操作的细节。

### （4）有序数组

> OrderArray.java

```java
/**
 * 在有序数组中，使用二分法查找某一个数
 * @author ageeklet
 *
 */
public class OrderArray {
	private long[] a;
	private int nElems;//数组中内容数量
	
	public OrderArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	
	//二分法查找：searchKey为要查找的数
	public int find(long searchKey) {
		int lowerBound = 0;//最小值
		int upperBound = nElems-1;//最大值
		int curIn;//中间数
		
		while(true) {
			curIn = (lowerBound+upperBound)/2;
			if(a[curIn]==searchKey) {
				return curIn;
			}else if(lowerBound>upperBound) {
				return nElems;
			}else {
				if(a[curIn]<searchKey) {
					lowerBound = curIn+1;
				}else {
					upperBound = curIn-1;
				}
			}
		}
	}
	
	/*
	 *向数组中插入数据
	 *每执行一次insert方法，nElems就会增加1 
	 */
	public void insert(long value) {
		int j ;
		for(j=0;j<nElems;j++) {
			if(a[j]>value) {
				break;
			}
		}
		for(int k=nElems;k>j;k--) {
			a[k] = a[k-1];
		}
		a[j] = value;
		nElems++;
	}
	
	//删除数组中的数据项
	public boolean delete(long value) {
		int j = find(value);
		if(j==nElems) {
			return false;
		}else {
			for(int k=j;k<nElems;k++) {
				a[k]=a[k+1];
			}
			nElems--;
			return true;
		}
	}
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println(" ");
	}
}
```

> OrderArrayApp.java

```java
public class OrderArrayApp {

	public static void main(String[] args) {
		int maxSize = 100;
		OrderArray arr = new OrderArray(maxSize);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		int searchKey = 55;
		if(arr.find(searchKey) != arr.size()) {
			System.out.println("Found "+searchKey);
		}else {
			System.out.println("Can`t found"+searchKey);
		}
		 
		arr.display();
		
		arr.delete(00);
		arr.delete(55);
		arr.delete(99);
		
		arr.display();
	}
}
```

> 有序数组查找速度比无序数组快，但是在执行插入操作时，由于所有的靠后的数据都需要移动空间，所以速度较慢。有序数组和无序数组中的删除操作都很慢，因为数据都必须向前移动来填补已删除的数据项的洞。

### （5）大O表示法

>大O表示法在比较算法时，并不在乎具体的微处理器芯片或编译器；真正需要比较的是对应不同的N值。

> 大O表示法使用大写字母O，可以认为其含义是“order by”（大约是）。我们可以使用大O表示法来描述线性查找使用了O(N)级时间，二分查找使用了O(logN)级时间。向一个无序数组中插入使用了O(1)级时间或常数级时间。

> 大O表示法的实质并不是对运行时间给出实际值，而是表达了运行时间是如何受数据项个数所影响的。

### （6）总结

- Java中的数组是对象，由new操作符创建。
- 无序数组可以提供快速的插入，但查找和删除较慢。
- 将数组封装到类中可以保护数组不被随意改变。
- 类的接口由类用户可访问的方法（有时还有字段）组成。
- 类的接口被设计成使类用户的操作更加简单。
- 有序数组可以使用二分查找。
- 线性查找需要的时间与数组中的数据项的个数成正比。
- 二分查找需要的时间与数组中的数据项的个数的对数成正比。
- 大O表示法为比较算法的速度提供了一种方便的方法。
- O(1)级时间的算法是最好的，O(logN)次之，O(N)一般，以此类推。

## 2、简单排序

### （1）冒泡排序

> 算法思想：重複地走訪過要排序的數列，一次比較兩個元素，如果他們的順序錯誤就把他們交換過來。 走訪數列的工作是重複地進行直到沒有再需要交換，也就是說該數列已經排序完成
>
> 冒泡排序演算法的运作如下：
>
> ​	1、比較相鄰的元素。如果第一個比第二個大，就交換他們兩個。
> 	2、對每一對相鄰元素作同樣的工作，從開始第一對到結尾的最後一對。這步做完後，最後的元素會是最大的數。
> 	3、針對所有的元素重複以上的步驟，除了最後一個。
> 	4、持續每次對越來越少的元素重複上面的步驟，直到沒有任何一對數字需要比較。
>
> ArrayBub.java

```java
//冒泡排序
public class ArrayBub {
	private long[] a;
	private int nElems;
	public ArrayBub(int max){
		a = new long[max];
		nElems = 0;
	}
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println(" ");
	}
	public void bubbleSort() {
		int out,in;
		for(out=nElems-1;out>1;out--) {
			for(in=0;in<out;in++) {
				if(a[in]>a[in+1]) {
					swap(in,in+1);
				}
			}
		}	
	}
	public void swap(int one,int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
```

> BubbleSortApp.java

```java
public class BubbleSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayBub arr = new ArrayBub(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		
		arr.bubbleSort();
		arr.display();
	}
}
```

> 运行结果：

```java
77 99 44 55 22 88 11 0 66 33  
0 11 22 33 44 55 66 77 88 99  	
```

> 无论何时，只要是一个循环嵌套在另一个循环里面，就可以怀疑这个算法的运行时间为O(N^2)级。外层循环执行N次，内部循环对于每一次外层循环都执行N次（或者几分之N次）。这就意味着大约需要执行N*N或者N^2次个基本操作。

### （2）选择排序

> 算法思想：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
>
> 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，因此对  n个元素的表进行排序总共进行至多 n-1次交换。在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
>
> ArraySel.java

```java
public class ArraySel {
	private long[] a;
	private int nElems;
	
	public ArraySel(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(a[j]+" ");
		}
		System.out.println(" ");
	}
	
	public void selectionSort() {
		int out,in,min;
		for(out=0;out<nElems-1;out++) {
			min = out;
			for(in=out+1;in<nElems;in++) {
				if(a[in]<a[min]) {
					min=in;
				}
			}
			swap(out,min);
		}
	}
	public void swap(int one,int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
```

> SelectSortApp.java

```java
public class SelectSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArraySel arr = new ArraySel(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();
		
		arr.selectionSort();
		
		arr.display();
	}
}
```

> 运行结果

```java
77 99 44 55 22 88 11 0 66 33  
0 11 22 33 44 55 66 77 88 99  
```

> 选择排序的效率：选择排序和冒泡排序执行了相同次数的比较：N*(N-1)/2。N值很大时，比较次数是次要的，所以结论是选择排序和冒泡排序一样运行了O(N^2)时间。但是，选择排序无疑更快，因为它进行的交换少得多。当N值较少时，特别是如果交换的时间级比比较的时间级大得多时，选择排序实际上是相当快的。

### （3）插入排序

> 虽然插入排序算法仍需要O(N^2)的时间，但是在一般情况下，他要比冒泡排序快一倍，比选择排序还要快一点。尽管他比冒泡排序和选择排序算法更麻烦一点，但是他并不复杂。
>
> 设有一组关键字｛K1， K2，…， Kn｝；排序开始就认为 K1 是一个有序序列；让 K2 插入上述表长为 1 的有序序列，使之成为一个表长为 2 的有序序列；然后让 K3 插入上述表长为 2 的有序序列，使之成为一个表长为 3 的有序序列；依次类推，最后让 Kn 插入上述表长为 n-1 的有序序列，得一个表长为 n 的有序序列。
>
> 算法描述：
>
> ​	1、从第一个元素开始，该元素可以认为已经被排序
>
> ​	2、取出下一个元素，在已经排序的元素序列中从后向前扫描	
>
> ​	3、如果该元素（已排序）大于新元素，将该元素移到下一位置
>
> ​	4、重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
>
> ​	5、将新元素插入到该位置后
>
> ​	6、重复步骤 2~5

insertionSort.java

```java
package com.ageeklet.dataStructure.insertionSort;

public class InsertionSort {
	public static void insertionSort_1(int[] arr) {
		for(int i=1;i<arr.length;i++){
			int key = arr[i];  //key为当前索引对应的数组中的值
			int j = i-1;	   //j为当前索引的前一位
			while(j>=0 && arr[j]>key) {  //判断索引i对应的数组中的值是否小于前一位
				arr[j+1] = arr[j];  //   交换前后两个索引对应的数组中的值
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public  static void insertionSort_2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			 //如果将赋值放到下一行的for循环内, 会导致在第10行出现j未声明的错误
			for (; j>=0 && arr[j]>temp ; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}
	public static void main(String[] args) {
		int[] arr = {5, 6, 3, 1, 8, 7, 2, 4};
		insertionSort_1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		insertionSort_2(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}

```

> 运行结果：

```java
1 2 3 4 5 6 7 8 
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
1 2 3 4 5 6 7 8 
```

### （4）对象排序

```java
// TODO
```

### （5）几种简单排序之间的比较

>  一般情况下几乎不太用冒泡排序算法，过于简单。当数据量很小的时候会用一些应用价值。
>
> 选择排序虽然把交换次数降到了最低，但是比较的次数仍然很大。当数据量很小，并且交换数据相对于比较数据更加耗时的情况下，可以应用选择排序。
>
> 在大多数的情况下，假设数据量比较小或者基本上有序时，插入排序算法时三种简单排序算法中最好的选择。对于更大的数据量的排序来说，快速排序通常是最快的方法。		

## 3、栈和队列

### （1）栈

> **栈**（英语：stack）又称为**栈**或**堆叠**，是计算机科学中一种特殊的串列形式的抽象数据类型，其特殊之处在于只能允许在链表或数组的一端（称为堆栈顶端指针，英语：top）进行加入数据（英语：push）和输出数据（英语：pop）的运算。另外栈也可以用一维数组链表的形式来完成。堆栈的另外一个相对的操作方式称为队列。
>
> 由于堆栈数据结构只允许在一端进行操作，因而按照后进先出（LIFO, Last In First Out）的原理运作

> a、栈实例 1 ：单词逆序

> * StackX.java

```java
package com.ageeklet.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 栈实例1：单词逆序
 * @author ageeklet
 */
public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	/*
	 * top的值+1，使他指向原顶端数据项上面的一个位置，并在这个位置存储一个数据项。
	 * top是在插入数据项之前递增的
	 */
	public void push(char j) {
		stackArray[++top] = j;
	}
	
	/*
	 * 返回top标识的数据项值，然后top-1，该方法有效的移出了数据项
	 * 虽然数据项仍然存在数组中（直到有新的数据项压入栈中覆盖这个数据项），但不能再访问他了
	 */
	public char pop() {
		return stackArray[top--];
	}
	
	/*
	 * 返回top所指的数据项的值，不对栈做任何改动
	 */
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top==-1);
	}
	
	public static String getString()throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();//只读取一行数据
		return s;
	}
}

```

> * Reverser.java

```java

	private String input;
	private String output;
	
	public Reverser(String in) {
		this.input = in;
	}
	
	public String doReverser() {
		int stackSize = input.length();
		//创建一个栈
		StackX theStack = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			//定位输入string中每个字符，并且将其存入到栈中
			char ch = input.charAt(i);
			theStack.push(ch);
		}
		output = "";
		while(!theStack.isEmpty()) {
			//得到栈顶元素，并且将其拼接成一个新的字符串，与原字符串刚好逆序
			char ch = theStack.pop();
			output = output + ch;
		}
		return output;
	}
}
```

> * ReverserApp.java

```java
public class ReverserApp {

	public static void main(String[] args) throws IOException {
		String input,output;
		while(true) {
			System.out.print("Enter a string:");
			System.out.flush();;
			input = getString();
			if(input.isEmpty()) {
				break;
			}
			Reverser theReverser = new Reverser(input);
			output = theReverser.doReverser();
			System.out.println("Reverserd:" + output);
		}
	}

	private static String getString()throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();//只读取一行数据
		return s;
	}
}

```

> * 运行结果

```java
Enter a string:char
Reverserd:rahc
```

> b、栈实例 2 ：分隔符匹配
>
> 栈通常用于解析某种类型的文本串。
>
> 分隔符匹配程序从字符串中不断读取字符，每次读取一个字符。若发现它是左分隔符，将它压入栈中。当从输入中读到一个右分隔符时，弹出栈顶的左分隔符，并且查看它是否和右分隔符项匹配。如果不匹配，则程序报错。如果栈中没有左分隔符和右分隔符匹配，或者一直存在没有匹配的分隔符，程序也报错。分隔符没有被匹配，表现为把所有的字符读入之后，栈中仍有分隔符。

> * BracketChecker.java

```java
public class BracketChecker {
	private String input;
	
	public BracketChecker (String in) {
		this.input = in;
	}
	
	public void check() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
				
			case '}':
			case ']':
			case ')':
				if(!theStack.isEmpty()) {
					char chx = theStack.pop();
					if((ch=='}' && chx!='{') || (ch==']' && chx!='[' )|| (ch==')' && chx!='(')) {
						System.out.println("Error: "+ch+" at "+i);
					}
					break;
				}else {
					System.out.println("Error: "+ch+" at "+i);
				}
				default:
					break;
			}
		}
		if(!theStack.isEmpty()) {
			System.out.println("Error:missing right delimiter");
		}
	}
}

```

> *BracketApp.java

```java
public class BracketApp {
	public static void main(String[] args) throws IOException {
		String input;
		while(true) {
			System.out.print("Enter string cotaining delimiters:");
			System.out.flush();
			input = StackX.getString();
			if(input.equals("")) {
				break;
			}
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check();
		}
	}
}

```

> * 运行结果

```java
Enter string cotaining delimiters:a{b[c)d}e
Error: ) at 5
Enter string cotaining delimiters:
```

* 栈的效率

  StackX类中的实现的栈，数据项入栈和出栈的时间复杂度都为常熟O(1)。这也就是说，栈操作所耗的时间不依赖于栈中的数据项的个数，因此操作时间很短。栈不需要比较和移动操作。

### （2）队列

> **队列**，又称为**伫列**（queue），是先进先出（FIFO, First-In-First-Out）的线性表。在具体应用中通常链表或者数组来实现。队列只允许在后端（称为*rear*）进行插入操作，在前端（称为*front*）进行删除操作。
>
> 队列的操作方式和堆栈类似，唯一的区别在于队列只允许新数据在后端进行添加。

* 

```java
public class Queue {
	private int maxSize;
	private long[] queueArray;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(int s) {
		this.maxSize = s;
		queueArray = new long[s];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	/*
	 * insert()方法运行的前提是队列不满
	 * 一般情况下，插入操作是rear（队尾指针）+1后，在队尾指针所指的位置插入新的数据。但是，当rear指针指向数组的顶端，
	 * 既maxSize-1位置的时候，在插入数据项之前，它必须回绕到数组的低端。回绕操作把rear设置为-1，因此当rear+1后，它等于0，
	 * 是数组低端的下标值。最后，nItems+1；
	 */
	public void insert(long j) {
		if(rear == maxSize - 1) {
			rear = -1;
		}
		queueArray[++rear] = j;
		nItems ++;
	}
	
	/*
	 * remove()方法前提是队列不为空
	 * 移除操作总是由front指针得到队头数据项的值，然后将front+1。但是，如果这样做使front的值超过数组的顶端，
	 * front就必须绕回到数组下标为0的位置上。作这种检验的同时，现将返回值临时存起来。最后nItems-1。
	 */
	public long remove() {
		long temp = queueArray[front++];
		if(front == maxSize) {
			front = 0;
		}
		nItems --;
		return temp;
	}
	
	/*
	 * 返回front指针所指数据项的值。
	 */
	public long peekFront() {
		return queueArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems==0);
	}
	
	public boolean isFull() {
		return (nItems==maxSize);
	}
	
	public int size() {
		return nItems;
	}
}
```

* QueueApp.java

```java
public class QueueApp {
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		
		queue.remove();
		queue.remove();
		queue.remove();
		
		queue.insert(50);
		queue.insert(60);
		queue.insert(70);
		queue.insert(80);
		
		while(!queue.isEmpty()) {
			long n = queue.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println("");
	}
}

```

* 运行结果

```java
40 50 60 70 80 
```

* 队列的效率：和栈一样，队列中插入数据项和移除数据项的时间复杂度为O(1)。

### （3）双端队列

> 双端队列就是一个两端都是结尾的队列。队列的每一端都可以插入数据项和移除数据项。这些方法可以叫做insertLeft()和insertRight()方法（或相反的另一对方法），它的功能就和队列一样了。
>
> 如果严格禁止调用insertLeft()和removeLeft()方法（或禁用右端的操作），双端队列功能就和栈一样。禁止调用insertLeft()和removeRight()（或相反的另一对方法），它的功能就和队列一样。
>
> 双端队列与栈和队列相比，是一种多用途的数据结构，在容器类中有时会用到双端队列来提供栈和队列的两种功能。

### （4）优先级队列

> 如果我们给每个元素都分配一个数字来标记其优先级，不妨设较小的数字具有较高的优先级，这样我们就可以在一个集合中访问优先级最高的元素并对其进行查找和删除操作了。这样，我们就引入了优先级队列这种。 优先级队列（priority queue） 是0个或多个元素的集合，每个元素都有一个优先权，对优先级队列执行的操作有（1）查找（2）插入一个新元素 （3）删除 一般情况下，查找操作用来搜索优先权最大的元素，删除操作用来删除该元素 。对于优先权相同的元素，可按先进先出次序处理或按任意优先权进行。

* PriorityQueue.java

```java
public class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int nItems;
	
	public PriorityQueue(int s) {
		this.maxSize = s;
		queueArray = new long[s];
		nItems = 0;
	}
	
	/*
	 * insert方法先检查队列中是否有数据项；如果没有，就插入到下标为0的单元里。
	 * 否则，从数组顶部开始上移存在的数据项，直到找到新数据项应当插入的位置。
	 * 然后，插入新数据项，并把nItems+1。
	 * 注意优先级队列可能出现满的情况，应当在用insert()方法之前调用isFull()判断这种可能性。
	 */
	public void insert(long item) {
		int j ;
		if (nItems == 0) {
			queueArray[nItems++] = item;
		}else {
			for(j=nItems-1;j>=0;j--) {
				if(item > queueArray[j]) {
					queueArray[j+1] = queueArray[j];
				}else {
					break;
				}
			}
			queueArray[j+1] = item;
			nItems ++;
		}
	}
	
	public long remove() {
		return queueArray[--nItems];
	}
	
	public long peekMin() {
		return queueArray[nItems-1];
	}
	
	public boolean isEmpty() {
		return (nItems==0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
}
```

* PriorityApp.java

```java
public class PriorityApp {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue(5);
		pq.insert(30);
		pq.insert(50);
		pq.insert(10);
		pq.insert(40);
		pq.insert(20);
		
		while(!pq.isEmpty()) {
			long item = pq.remove();
			System.out.print(item+" ");
		}
		System.out.println("");
	}
}

```

* 运行结果（最小的数据项先移除，所以输出如下所示）

```java
10 20 30 40 50 
```

* 优先级队列的效率：插入操作需要O(N)的时间，删除操作需要O(1)。

## 4、链表

### （1）链结点（Link）

> 在链表中，每个数据项都包含在“链结点”（Link）中。一个链结点是某个类的对象，这个类可以叫做Link。因为一个链表中有许多类似的链结点，所以有必要用一个不同于链表的类来表达链结点。每个Link对象中都包含一个对下一个链结点引用的字段（通常叫做next）。但是链表本身的对象中有一个字段指向对第一个链结点的引用。

### （2）单链表

* Link.java

```java
public class Link {
	public int iData;
	public double dData;
	public Link next;//自引用 包含了一个和自己类型相同的字段
	
	public Link(int id,double dd) {
		this.iData = id;
		this.dData = dd;
	}
	
	public void displayLink() {
		System.out.print("{"+iData+","+dData+"}");
	}
}
```

* LinkList.java

```java
public class LinkList {

	//链表中第一个链结点的引用，是唯一的链表需要维护的永久信息,用以定位其他所有的链结点
	private Link first;
	
	public void LinkList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return 	(first==null);
	}
	
	/*
	 * 在表头插入一个新链结点。以为first已经指向了第一个链结点，为了插入新的链结点，
	 * 只需要使新创建的链结点的next字段等于原来的first值，然后改变first的值，使它
	 * 指向新创建的链结点
	 */
	public void insertFirst(int id,double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}
	
	/*
	 * current开始时指向first，然后通过不断的把自己赋值为current.next,沿着链表向前移动
	 * 在每个链结点处，find()检查链结点的关键值是否与他寻找的相等。如果找到了，它返回对该
	 * 链结点的引用。如果find()到达链表尾端，但没有发现要找的链结点，则返回null
	 */
	public Link find(int key) {
		Link current = first;
		while(current.iData!=key) {
			if(current.next==null) {
				return null;
			}else {
				current = current.next;
			}
		}
		return current;
	}
	
	/*
	 * 先搜索要删除的链结点。然而它需要掌握的不仅是指向当前的链结点（current）的引用，
	 * 还有指向当前链结点的前一个（previous）链结点的引用。
	 * 如果要删除当前的链结点，必须把前一个链结点和后一个链结点连在一起
	 */
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while(current.iData!=key) {
			if(current.next==null) {
				return null;
			}else {
				previous = current;
				current = current.next;
			}
		}
		if(current == first) {
			first = first.next;
		}else {
			previous.next = current.next;
		}
		return current;
	}
	/*
	 * 通过把first重新指向第二个链结点，断开了和第一个链结点的连接
	 * first = first.next; 是从链表中删除一个链结点。最后需要返回一个链结点，为了链表的使用者的方便，
	 * 我们在删除它之前把它存储在temp变量中，并且返回temp值
	 */
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	/*
	 * 为了显示链表，从first开始，沿着引用链从一个链结点到下一个链结点，变量current按顺序指向（引用）每一个链结点。
	 */
	public void displayList() {
		System.out.print("List (first-->last):");
		Link current = first;
		while(current !=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
}
```

* LinkListApp.java

```java
public class LinkListApp {
	public static void main(String[] args) {
		LinkList theList = new LinkList();
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList();
		
		/*while(!theList.isEmpty()) {
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted");
			aLink.displayLink();
			System.out.println(" ");
		}*/
		
		Link f = theList.find(44);
		if(f!=null) {
			System.out.println("Found link with key"+f.iData);
		}else {
			System.out.println("Can not find link");
		}
		
		Link d = theList.delete(66);
		if(d!=null) {
			System.out.println("Deleted link with key:"+d.iData);
		}else {
			System.out.println("Can not delete link");
		}
		
		theList.displayList();
	}
}
```

* 运行结果

```java
List (first-->last):{88,8.99}{66,6.99}{44,4.99}{22,2.99} 
Deleted{88,8.99} 
Deleted{66,6.99} 
Deleted{44,4.99} 
Deleted{22,2.99} 
List (first-->last): 
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
List (first-->last):{88,8.99}{66,6.99}{44,4.99}{22,2.99} 
Found link with key44
Deleted link with key:66
List (first-->last):{88,8.99}{44,4.99}{22,2.99} 
```

### （3）双端链表

> 双端链表与传统的链表非常相似，但是他有一个新增的特性：既对最后一个链结点的引用，就像对第一个链结点的引用一样。
>
> 对最后一个链结点的引用允许像在表头一样，在表尾直接差一个链结点。当然，仍然可以在普通的单链表的表尾插入一个链结点，方法是遍历整个链表知道到达表尾，但是这种方法效率很低。
>
> 像访问表头一样访问表尾的特性，使双端链表更适合于一些普通链表的不方便操作的场合，队列的实现就是这样一个情况。

* Link.java

```java
public class Link {
	public long dData;
	public Link next;
	
	public Link(long d) {
		this.dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData+" ");
	}

```

* FirstLastList.java

```java
public class FirsrLastList {
	private Link first;
	private Link last;
	
	public FirsrLastList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first==null;
	}

	/*
	 * 在表头重复插入会颠倒链结点进入的顺序
	 */
	public void insertFirst(long d) {
		Link newLink = new Link(d);
		/*
		 * 若插入前链表是空的，若isEmpty()为真，
		 * 那么insertFirst()必须把last指向新的链结点
		 */
		if(isEmpty()) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	/*
	 * 在表尾重复插入则保持连接点的进入的顺序
	 * 这个方法在表尾插入一个新的链结点。
	 * 首先改变last.next,使其指向新生成的链结点，然后改变last，使其指向新的链结点
	 */
	public void insertLast(long d) {
		Link newLink = new Link(d);
		/*
		 * 若插入前链表是空的，若isEmpty()为真，
		 * 那么insertLast()必须把first指向新的链结点
		 */
		if(isEmpty()) {//first==null
			first = newLink;
		}else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	public long deleteFirst() {
		long temp = first.dData;
		if(first.next==null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("List(first-->last):");
		Link current = first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
```

* FirstLastApp.java

```java
public class FirstLastApp {
	public static void main(String[] args) {
		FirsrLastList theList = new FirsrLastList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.displayList();
		
		theList.deleteFirst();
		theList.deleteFirst();
		
		theList.displayList();
	}
}
```

* 运行结果

```java
List(first-->last):66 44 22 11 33 55 
List(first-->last):22 11 33 55
```

* 链表的效率：在表头插入和删除速度很快。仅需要改变一两个引用值，所以花费O(1)的时间。

### （4）抽象数据类型

> 抽象数据类型（ADT）：一种考虑数据结构的方式，着重于它做什么，而忽略它是怎么做的。

* Link.java

```java
public class Link {
	public long dData;
	public Link next;
	
	public Link(Long dd) {
		this.dData = dd;
	}
	
	public void displayLink() {
		System.out.print(dData+" ");
	}
}
```

##### a、用链表实现栈

* LinkList.java

```java
public class LinkList {
	private Link first;
	
	public LinkList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(long dd) {
		Link newLink = new Link(dd);
		newLink.next = first;
		first = newLink;
	}
	
	public long deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp.dData;
	}
	
	public void displayList() {
		Link current = first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
```

* LinkStack.java

```java
public class LinkStack {
	private LinkList theList;
	
	public LinkStack() {
		theList = new LinkList();
	}
	
	public void push(long j) {
		theList.insertFirst(j);
	}
	
	public long pop() {
		return theList.deleteFirst();
	}
	
	public boolean isEmpty() {
		return (theList.isEmpty());
	}
	
	public void displayStack() {
		System.out.print("Stack(top-->bottom)");
		theList.displayList();
	}
}

```

* LinkStack.java

```java
public class LinkStackApp {
	public static void main(String[] args) {
		LinkStack theStack = new LinkStack();
		theStack.push(20);
		theStack.push(40);
		
		theStack.displayStack();
		
		theStack.push(60);
		theStack.push(80);
		
		theStack.displayStack();
		
		theStack.pop();
		theStack.pop();
		
		theStack.displayStack();
	}
}
```

* 运行结果

```java
Stack(top-->bottom)40 20 
Stack(top-->bottom)80 60 40 20 
Stack(top-->bottom)40 20 
```

##### b、用链表实现队列

* FirstLastList.java

```java
public class FirstLastList {
	private Link first;
	private Link last;
	
	public FirstLastList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void insertLast(long dd) {
		Link newLink = new Link(dd);
		if(isEmpty()) {
			first = newLink;
		}else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	public long deleteFitst() {
		long temp = first.dData;
		if(first.next==null) {
			last = null;
		}
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		Link current = 	first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
```

* LinkQueue.java

```java
public class LinkQueue {
	private FirstLastList theList;
	
	public LinkQueue() {
		theList = new FirstLastList();
	}
	
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	
	public void insert(long j) {
		theList.insertLast(j);
	}
	
	public long remove() {
		return theList.deleteFitst();
	}
	
	public void displayQueue() {
		System.out.print("Queue(front-->rear)");
		theList.displayList();
	}
}
```

* LinkQueueApp.java

```java
public class LinkQueueApp {
	public static void main(String[] args) {
		LinkQueue theQueue = new LinkQueue();
		theQueue.insert(20);
		theQueue.insert(40);
		
		theQueue.displayQueue();
		
		theQueue.insert(60);
		theQueue.insert(80);
		
		theQueue.displayQueue();
		
		theQueue.remove();
		theQueue.remove();

		theQueue.displayQueue();
	}
}

```

* 运行结果

```java
Queue(front-->rear)20 40 
Queue(front-->rear)20 40 60 80 
Queue(front-->rear)60 80 
```

> ​	LinkStack.java和LinkQueue.java强调栈和队列是概念上的实体，独立与他们的具体实现。用数组或是链表实现栈都是一样的。栈的重要性在于它的push()和pop()操作，以及他们如何使用他们，而不是实现这些操作的内在机制。
>
> ​	什么时候应该使用链表而不是队列来实现栈和队列？这一点要取决于是否能精确的预测栈或队列需要容纳的数据量。如果这点不清楚，链表就比数组表现出更好的适应性。两者都很快，所以速度可能不是考虑的重点。

> ​	在面向对象编程中，一个抽象数据类型是一个类，且不考虑它的实现。它是对类中数据（域）的描述和能够在数据上执行一系列的操作（方法）以及如何使用这些操作的说明。每个方法如何执行任务的细节肯定不包括在内。作为类的用户，只会被告知调用那些方法，如何调用他们，以及可望得到的结果，但是不包括内部如何存储的。
>
> ​	当“抽象数据类型”用于像栈和队列这样的数据结构时，它的意义被进一步扩展了。和其他类一样，它意味着数据和在数据上执行的操作，即便在这种情况下，如何存储数据结构的基本原则对于类用户来说也是不可见的。用户不仅不知道方法怎样运行，也不知道数据如何存储的。

### （5）有序链表

> ​	在有序链表中，数据是按照关键值有序排列的。有序链表的删除常常只限于删除在链表头部的最小（或者最大）的链结点	。
>
> ​	一般，在大多数需要使用有序数组的场合也可以使用有序链表。有序链表优于有序数组的地方是插入的速度（因为元素不需要移动），另外链表可以扩展到全部有效的使用内存，而数组只能局限于	一个固定的大小中。但是，有序链表实现起来比有序数组更困难一些。

##### a、在有序链表中插入一个数据项

* SortedList.java

```java
public class SortedList {
	private Link first;
	
	public SortedList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public void insert(long key) {
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		
		while(current!=null && key>current.dData) {
			previous = current;
			current = current.next;
		}
		if(previous==null) {
			first = newLink;
		}else {
			previous.next = newLink;
		}
		newLink.next = current;
	}
	
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.print("List(first-->last):");
		Link current = first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
```

* SortedListApp.java

```java
public class SortedListApp {
	public static void main(String[] args) {
		SortedList theList = new SortedList();
		theList.insert(20);
		theList.insert(40);
		
		theList.displayList();
		
		theList.insert(10);
		theList.insert(30);
		theList.insert(50);
		
		theList.displayList();
		
		theList.remove();
		
		theList.displayList();
	}
}
```

* 运行结果

```java
List(first-->last):20 40 
List(first-->last):10 20 30 40 50 
List(first-->last):20 30 40 50 
```

* 有序链表的效率：在有序链表插入和删除某一项最多需要O(N)次比较，因为必须沿着链表上一步一步走才能找到正确的位置。然而，可以在O(1)的时间内找到或删除最小值，因为它总在表头。如果一个应用频繁的存取最小项，且不需要快速的插入，那么有序链表是一个有效的方案选择。

##### b、表插入排序

> 在有序链表中没插入一个新的链结点，平均要与一半已存在的数据进行比较，如果插入N个新数据，就进行了N^2/4次比较。每一个链结点只进行两次复制：一次从数组到链表，一次从链表到数组。在数组中插入排序需要N^2次移动，相比之下，2*N次移动更好。

* SortedList2.java

```java
public class SortedList2 {
	private Link first;
	
	public SortedList2() {
		first = null;
	}
	
	public SortedList2(Link[] linkArr ) {
		first = null;
		for (int i = 0; i < linkArr.length; i++) {
			insert(linkArr[i]);
		}
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public void insert(Link k) {
		Link previous = null;
		Link current = first;
		
		while(current!=null && k.dData>current.dData) {
			previous = current;
			current = current.next;
		}
		if(previous==null) {
			first = k;
		}else {
			previous.next = k;
		}
		k.next = current;
	}
	
	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.print("List(first-->last):");
		Link current = first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
```

* SortedListApp.java

```java
public static void main(String[] args) {
		int size = 10;
		Link[] linkArr = new Link[size];
		for (int i = 0; i < size; i++) {
			int n = (int)(Math.random()*99);
			Link newLink = new Link((long) n);
			linkArr[i] = newLink;
 		}
		System.out.print("Unsorted array:");
		for (int i = 0; i < linkArr.length; i++) {
			System.out.print(linkArr[i].dData+" ");
		}
		System.out.println(" ");
		
		SortedList2 theList = new SortedList2(linkArr);
		
		for (int i = 0; i < linkArr.length; i++) {
			linkArr[i] = theList.remove();
		}
		System.out.print("Sorted Array:");
		for (int i = 0; i < linkArr.length; i++) {
			System.out.print(linkArr[i].dData+" ");
		}
		System.out.println("");
	}
```

* 运行结果

```java
Unsorted array:12 18 46 74 80 74 47 77 23 66  
Sorted Array:12 18 23 46 47 66 74 74 77 80 
```

> ​	SotedList2类的新构造方法把Link函数对象的数组作为参数注入，然后把这个数组内容插入到新创建的链表中。
>
> ​	和基于数组插入排序相比，表插入排序有一个缺点，就是他要开辟差不多两倍的空间；数组和链表必须同时存在与内存中。但如果现有的有序链表类可用，那么用表插入排序对不太大的数组排序是比较便利的。

### （6）双向链表

> ​	双向链表既允许向前遍历，也允许向遍历整个链表。其中秘密在于每个链表链结点有两个指向其他链结点的引用，而不是一个第一个像普通链表一样指向下一个链结点。第二个指向前一个链结点。
>
> ​	双向链表的缺点是每次插入或这删除一个链结点的时候，要处理四个链结点的引用，而不是两个：两个连接前一个链结点，两个连接后一个链结点。当然，由于多了两个引用，连接点的额占用空间也变大了一点。

* Link.java

```java
public class Link {
	public long dData;
	public Link previous;
	public Link next;
	
	public Link(long d) {
		this.dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData+" ");
	}
}
```

* DoubleLinkedList.java

```java
public class DoubleLinkedList {
	private Link first;
	private Link last;
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	/*
	 * 在表头插入数据项
	 */
	public void insertFirst(long d) {
		Link newLink = new Link(d);
		if(isEmpty()) {
			last = newLink;
		}else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(long d) {
		Link newLink = new Link(d);
		if(isEmpty()) {
			first = newLink;
		}else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}
	
	public Link deleteFirst() {
		Link temp = first;
		if(first.next==null) {
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}

	public Link deleteLast() {
		Link temp = last;
		if(first.next==null) {
			first = null;
		}else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	
	public boolean	insertAfter(long key,long dd) {
		Link current = first;
		while(current.dData!=key) {
			current = current.next;
			if(current==null) {
				return false;
			}
		}
		Link newLink = new Link(dd);
		if(current==last) {
			newLink.next = null;
			last = newLink;
		}else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}
	
	public Link deleteKey(long key) {
		Link current = first;
		while(current.dData != key) {
			current = current.next;
			if(current==null) {
				return null;
			}
		}
		if(current==first) {
			first = current.next;
		}else {
			current.previous.next = current.next;
		}
		if(current==last) {
			last = current.previous;
		}else {
			current.next.previous = current.previous;
		}
		return current;
	}
	
	public void dispalyForward() {
		System.out.print("List (first-->last):");
		Link current = first;
		while(current!=null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public void displayBackword() {
		System.out.print("List (first-->last):");
		Link current = last;
		while(current!=null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}
}
```

*  DoublyLinkedApp.java

```java
public class DoublyLinkedApp {
	public static void main(String[] args) {
		DoubleLinkedList theList = new DoubleLinkedList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.dispalyForward();
		theList.displayBackword();
		
		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);
		
		theList.dispalyForward();
		
		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);
		
		theList.dispalyForward();
	}
}
```

* 运行结果

```java
List (first-->last):66 44 22 11 33 55 
List (first-->last):55 33 11 22 44 66 
List (first-->last):44 22 33 
List (first-->last):44 22 77 33 88 
```

## 5、递归

###　（１）三角函数















































































