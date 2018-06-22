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





