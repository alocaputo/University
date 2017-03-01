public class Matrices {
	
/*	
	public class matrixsException extends Exception{
		public static matrixsException(String exc)
	    {
	        super(exc);
	    }
	    public String getMessage()
	    {
	        return super.getMessage();
	    } 
	}
	*/
	/** 
	 * The mission of this class is to provide a number of * standalone procedures that 
	 * can be useful for manipulating * n x m matrices of floats. 
	 **/
	public static void main (String args[]) { 
		//Exception (arr1 || arr2) = null
		//# of rows/column is different (e.g. {{1,2,3},{4,5}}
		float[][] arr1 = { { 1,2,3,4},{11,12,13,14}, {21,22,23,24}};
		//float[][] arr2 = null;
		float[][] arr2 = { { 1,1},{2,2},{3,3},{0,0}};
		
		assert (arr1!=null) : "arr1 is not expected to null";
		assert (arr2!=null) : "arr2 is not expected to null";
		
//		TODO assert and exceptions (throw, catch and try)
		
		float[][] res = transpose(arr1);
		float[][] res2 = multiply(arr1,arr2);
		
		System.out.println("Transposed: ");
		printmatrix(res);
		System.out.println();
		System.out.println("Mupltiplication: ");
		printmatrix(res2);
		
//		TODO assert and exceptions (throw, catch and try) 
		
		}
	/** compute the transpose matrix of m: result[i,j]=m[j,i] */ 
	public static float[][] transpose (float[][] m){
		//throws mEx
	
		
		for(int i = 0;i<m.length;i++){
			if(m[i].length != m[0].length){
		//	throw new matrixsException("Errpre");
			}
		}
		
		float[][] temp = new float[m[0].length][m.length];
		for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                temp[j][i] = m[i][j];
            }}
        return temp;
	}


	/** compute matrix multiplication of m1 with m2: result[i,j] = sum_over_h(m1[i,h]*m2[h,j]) */
	//Expection m1Column != m2Rows
	public static float[][] multiply (float[][] m1, float[][] m2){ 
		float[][] temp = new float[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) { // m1Rows
            for (int j = 0; j < m2[0].length; j++) { // m2Columns
                for (int k = 0; k < m1[0].length; k++) { // m1Columns
                    temp[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return temp;
		
	}
	
//------------------DEBUG-----------------------
	
	public static void printmatrix(float[][] m){
		for (int i = 0; i < m.length; i++) {
		    for (int j = 0; j < m[0].length; j++) {
		        System.out.print(m[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
}
