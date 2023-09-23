//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> sk=new Stack<>();
        long brr[]=new long[arr.length];
        int i=arr.length-1;
        while(i>=0){
            while(!sk.isEmpty() && sk.peek()<=arr[i]){
                sk.pop();
            }
            
            if(sk.isEmpty()){
                brr[i]=-1;
            }
            
            else{
                brr[i]=sk.peek();
            }
            sk.push(arr[i]);
            i--;
        }
        
        return brr;
    } 
}