class Product 
{
    void product(int arr[], int n) 
    {
        int i, temp = 1;
         
        int prod[] = new int[n];

        for(int j=0;j<n;j++)
            prod[j]=1;
 
        for (i = 0; i < n; i++) 
        {
            prod[i] = temp;
            temp *= arr[i];
        }
 
        temp = 1;
 
        for (i = n - 1; i >= 0; i--) 
        {
            prod[i] *= temp;
            temp *= arr[i];
        }
   for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");
 
        return;
    }
 
    public static void main(String[] args) {
        Product pa = new Product();
        int arr[] = {10, 3, 5, 6, 2};
        System.out.println("The product array is : ");
        pa.product(arr, arr.length);
        int arr1[] = {1, 7, 3, 2};
        System.out.println("\n");
        System.out.println("The product array is : ");
        pa.product(arr1, arr1.length);
    }
}