package ybb.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

	public static void main(String[] args) {
		int[] array = {8,7,1,9,6,5};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 插入排序<br/>
	 * <ul>
	 * <li>从第一个元素开始，该元素可以认为已经被排序</li>
	 * <li>取出下一个元素temp，在已经排序的元素序列中从后向前扫描</li>
	 * <li>如果得到的元素大于temp，将该元素移到下一位置</li>
	 * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置j</li>
	 * <li>将新元素插入到该位置中</li>
	 * <li>重复步骤2</li>
	 * </ul>
	 *
	 * @param numbers
	 */
	public static void insertSort(int[] numbers) {
		int size = numbers.length, temp, j;
		for(int i=1; i<size; i++) {
			temp = numbers[i];
			for(j = i; j > 0 && temp < numbers[j-1]; j--){
				numbers[j] = numbers[j-1];
			}
			numbers[j] = temp;
		}
	}


	/**  冒泡法排序<br/>
	 * <li>比较相邻的元素。如果第一个比第二个大，就交换他们两个。</li>  
	 * <li>对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。</li>  
	 * <li>针对所有的元素重复以上的步骤，除了最后一个。</li>  
	 * <li>持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。</li>  

	 *   
	 * @param numbers  
	 *            需要排序的整型数组  
	 */  
	public static void bubbleSort(int[] numbers) {   
	    int temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = 0; j < size -1 - i ; j++) {
	            if (numbers[j] > numbers[j+1] ) { // 交换两数的位置
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
	            }   
	        }   
	    }   
	}


	/**
	 * 选择排序<br/>
	 * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li>
	 * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>
	 * <li>以此类推，直到所有元素均排序完毕。</li>
	 *
	 * @param numbers
	 */
	public static void selectSort(int[] numbers) {
		int size = numbers.length, temp;
		for (int i = 0; i < size; i++) {
			int k = i;
			for (int j = size - 1; j >i; j--)  {
				if (numbers[j] < numbers[k])  k = j;
			}
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
		}
	}
	
	/**  
	 * 快速排序<br/>  
	 * <ul>  
	 * <li>从数列中挑出一个元素，称为“基准”</li>  
	 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
	 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>  
	 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 * @param start  
	 * @param end  
	 */  
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
	    }   
	}
	

	
	

	
	/**  
	 * 归并排序<br/>  
	 * <ul>  
	 * <li>申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列</li>  
	 * <li>设定两个指针，最初位置分别为两个已经排序序列的起始位置</li>  
	 * <li>比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置</li>  
	 * <li>重复步骤3直到某一指针达到序列尾</li>  
	 * <li>将另一序列剩下的所有元素直接复制到合并序列尾</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 */  
	public static void mergeSort(int[] numbers, int left, int right) {   
	    int t = 1;// 每组元素个数   
	    int size = right - left + 1;   
	    while (t < size) {   
	        int s = t;// 本次循环每组元素个数   
	        t = 2 * s;   
	        int i = left;   
	        while (i + (t - 1) < size) {   
	            merge(numbers, i, i + (s - 1), i + (t - 1));   
	            i += t;   
	        }   
	        if (i + (s - 1) < right)   
	            merge(numbers, i, i + (s - 1), right);   
	    }   
	}   
	/**  
	 * 归并算法实现  
	 *   
	 * @param data  
	 * @param p  
	 * @param q  
	 * @param r  
	 */  
	private static void merge(int[] data, int p, int q, int r) {   
	    int[] B = new int[data.length];   
	    int s = p;   
	    int t = q + 1;   
	    int k = p;   
	    while (s <= q && t <= r) {   
	        if (data[s] <= data[t]) {   
	            B[k] = data[s];   
	            s++;   
	        } else {   
	            B[k] = data[t];   
	            t++;   
	        }   
	        k++;   
	    }   
	    if (s == q + 1)   
	        B[k++] = data[t++];   
	    else  
	        B[k++] = data[s++];   
	    for (int i = p; i <= r; i++)   
	        data[i] = B[i];   
	}


	/**
	 * 希尔排序
	 *
	 * @param array
	 * @return
	 */
	public static int[] ShellSort(int[] array) {
		int len = array.length;
		int temp, gap = len / 2;
		while (gap > 0) {
			for (int i = gap; i < len; i++) {
				temp = array[i];
				int preIndex = i - gap;
				while (preIndex >= 0 && array[preIndex] > temp) {
					array[preIndex + gap] = array[preIndex];
					preIndex -= gap;
				}
				array[preIndex + gap] = temp;
			}
			gap /= 2;
		}
		return array;
	}


	//声明全局变量，用于记录数组array的长度；
	static int len;
	/**
	 * 堆排序算法
	 *
	 * @param array
	 * @return
	 */
	public static int[] HeapSort(int[] array) {
		len = array.length;
		if (len < 1) return array;
		//1.构建一个最大堆
		buildMaxHeap(array);
		//2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
		while (len > 0) {
			swap(array, 0, len - 1);
			len--;
			adjustHeap(array, 0);
		}
		return array;
	}
	/**
	 * 建立最大堆
	 *
	 * @param array
	 */
	public static void buildMaxHeap(int[] array) {
		//从最后一个非叶子节点开始向上构造最大堆
		for (int i = (len/2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
			adjustHeap(array, i);
		}
	}
	/**
	 * 调整使之成为最大堆
	 *
	 * @param array
	 * @param i
	 */
	public static void adjustHeap(int[] array, int i) {
		int maxIndex = i;
		//如果有左子树，且左子树大于父节点，则将最大指针指向左子树
		if (i * 2 < len && array[i * 2] > array[maxIndex])
			maxIndex = i * 2;
		//如果有右子树，且右子树大于父节点，则将最大指针指向右子树
		if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
			maxIndex = i * 2 + 1;
		//如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
		if (maxIndex != i) {
			swap(array, maxIndex, i);
			adjustHeap(array, maxIndex);
		}
	}
	/**
	 * 交换数组内两个元素
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}



	/**
	 * 桶排序
	 *
	 * @param array
	 * @param bucketSize
	 * @return
	 */
	public static ArrayList<Integer> BucketSort(ArrayList<Integer> array, int bucketSize) {
		if (array == null || array.size() < 2)
			return array;
		int max = array.get(0), min = array.get(0);
		// 找到最大值最小值
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) > max)
				max = array.get(i);
			if (array.get(i) < min)
				min = array.get(i);
		}
		int bucketCount = (max - min) / bucketSize + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
		ArrayList<Integer> resultArr = new ArrayList<>();
		for (int i = 0; i < bucketCount; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < array.size(); i++) {
			bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
		}
		for (int i = 0; i < bucketCount; i++) {
			if (bucketSize == 1) { // 如果带排序数组中有重复数字时  感谢 @见风任然是风 朋友指出错误
				for (int j = 0; j < bucketArr.get(i).size(); j++)
					resultArr.add(bucketArr.get(i).get(j));
			} else {
				if (bucketCount == 1)
					bucketSize--;
				ArrayList<Integer> temp = BucketSort(bucketArr.get(i), bucketSize);
				for (int j = 0; j < temp.size(); j++)
					resultArr.add(temp.get(j));
			}
		}
		return resultArr;
	}

	/**
	 * 基数排序
	 * @param array
	 * @return
	 */
	public static int[] RadixSort(int[] array) {
		if (array == null || array.length < 2)
			return array;
		// 1.先算出最大数的位数；
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			max = Math.max(max, array[i]);
		}
		int maxDigit = 0;
		while (max != 0) {
			max /= 10;
			maxDigit++;
		}
		int mod = 10, div = 1;
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++)
			bucketList.add(new ArrayList<Integer>());
		for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
			for (int j = 0; j < array.length; j++) {
				int num = (array[j] % mod) / div;
				bucketList.get(num).add(array[j]);
			}
			int index = 0;
			for (int j = 0; j < bucketList.size(); j++) {
				for (int k = 0; k < bucketList.get(j).size(); k++)
					array[index++] = bucketList.get(j).get(k);
				bucketList.get(j).clear();
			}
		}
		return array;
	}

}
