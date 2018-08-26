package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort {

	ArrayList<String []> arrList = new ArrayList<String []>();
	String [][] arr =new String[4][4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strList = {"AA#BB#CC#DD",
				             "EE#CC#BB#AA",
				             "AA#CC#BB#AA",
				             "EE#BB#BB#AA"};
		Sort sorter = new Sort();
		sorter.loadData(strList);
		sorter.listSort();
		sorter.printList();
		sorter.arrSort();
		sorter.printArr();
		
	}
	void loadData(String strArr[])
	{
		int i = 0; 
		for(String str: strArr)
		{
			arrList.add(str.split("#"));
			arr[i++]= str.split("#");
		}
	}
	void listSort()
	{
		Collections.sort(arrList, new Comparator<String[]>() {

			@Override
			public int compare(String[] arg0, String[] arg1) {
				// TODO Auto-generated method stub
				return arg0[0].compareTo(arg1[0]);
				//return 0;
			}
			
		});
	}

	void arrSort()
	{
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==null || o2[0]==null)
					return 0;
				return o1[0].compareTo(o2[0]);
			}
			
		});
	}
	void printList()
	{
		for(String [] str: arrList)
		{
			System.out.println(str[0]+" "+str[1]+" "+str[2]);
		}
	}
	void printArr()
	{
		for(String [] str: arr)
		{
			System.out.println(str[0]+" "+str[1]+" "+str[2]);
		}
	}

}
