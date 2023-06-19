//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> lst=new ArrayList<>();
        int sum=0;
        int i=0,j=0;
         if(s==0){
            lst.add(-1);
            return lst;
        }
       
        while(j<arr.length){
            sum+=arr[j];
            if(sum<s){
                j++;
            }
            else if(sum==s){
                
                lst.add(i+1);
                lst.add(j+1);
                
               // System.out.println(i+" "+j);
                break;
            }

            else if(sum>s){
                while(sum>s){
                    sum=sum-arr[i];
                    i++;
                }

                if(sum==s){
                    lst.add(i+1);
                    lst.add(j+1);
                  // System.out.println(i+" "+j);
                break; 
                }

                j++;
            }
        }
        
        
        
        
        
        if(lst.isEmpty()){
            lst.add(-1);
        }
        
        return lst;
    }
}