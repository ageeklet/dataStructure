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

