public class Matrices {
	
	public static class matrixException extends Exception{
		 public matrixException()
		    {
		        super();
		    } 
		public matrixException(String exc)
	    {
	        super(exc);
	    }
	   
	}
	
	/** 
	 * The mission of this class is to provide a number of * standalone procedures that 
	 * can be useful for manipulating * n x m matrices of floats. 
	 **/
	public static void main (String args[]) { 
		
		float[][] arr1 = { { 1,2,3,4},{11,12,13,14},{21,22,23,24}};
		//float[][] arr1 = null;
		float[][] arr2 = { { 1,1},{2,2},{3,3},{0,0}};
		//float[][] arr2 = {{2,2},{3,3},{0,0}};
		float[][] res = null;
		float[][] res2 = null;
		
		try{
		 res = transpose(arr1);
		 res2 = multiply(arr1,arr2);
		}catch(matrixException e){
			System.err.print("Every column of the matrix m must have the same length\n");
		}
		
		System.out.println("Transposed: ");
		printmatrix(res);
		System.out.println();
		System.out.println("Mupltiplication: ");
		printmatrix(res2);	
	}
	
	/** compute the transpose matrix of m: result[i,j]=m[j,i] */ 
	/**
	 * transpose perform the transpose of a matrix(swap rows with columns)
	 * @param m the matrix to be transposed, REQUIRE m not to be null
	 * @return temp the transposed matrix (temp[i,j]=m[j,i]). REQUIRE number of temp rows = m columns and temp columns = m rows 
	 */
	public static float[][] transpose (float[][] m) throws matrixException{
		assert (m!=null) : "m is not expected to be null";
		float[][] temp = new float[m[0].length][m.length];
		
		//Every column of the matrix m must have the same length
		for(int i = 0;i<m.length;i++){
			if(m[i].length != m[0].length){
			throw new matrixException();
			}
		}		
		
		for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m[0].length; j++){
                temp[j][i] = m[i][j];
            }
		}
        	
		assert(m[0].length == temp.length) : "the returned matrix must have the same number of columns of m1";
		assert(m.length == temp[0].length) : "the returned matrix must have the same number of rows of m2";
		
		return temp;
	}


	/**
	 * multiply perform the matrix multiplication between m1 and m2
	 * @param m1 is the fist argument(matrix) of the multiplication 
	 * @param m2 is the second argument(matrix) of the multiplication 
	 * @return the result of the matrix multiplication temp[i,j] = sum_over_temp(m1[i,h]*m2[h,j])
	 */
	public static float[][] multiply (float[][] m1, float[][] m2) throws matrixException{
		
		assert (m1!=null) : "m1 and m2 are not expected to be null";
		assert (m2!=null) : "m1 and m2 are not expected to be null";
		assert (m1[0].length == m2.length) : "number of m1 columns must be the same of m2 rows";
		
		float[][] temp = new float[m1.length][m2[0].length]; 
		
		//Every column of the matrix m1 must have the same length
		for(int i = 0;i<m1.length;i++){
			if(m1[i].length != m1[0].length){
			throw new matrixException();
			}
		}
		//Every column of the matrix m2 must have the same length
		for(int i = 0;i<m2.length;i++){
			if(m2[i].length != m2[0].length){
			throw new matrixException();
			}
		}
		
		for (int i = 0; i < m1.length; i++) { // m1Rows
            for (int j = 0; j < m2[0].length; j++) { // m2Columns
                for (int k = 0; k < m1[0].length; k++) { // m1Columns
                    temp[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
		assert(m1[0].length != temp[0].length) : "the returned matrix must have the same number of columns of m1";
		assert(m2.length != temp.length) : "the returned matrix must have the same number of rows of m2";
        return temp;
		
	}
	
//------------------DEBUG-----------------------
	
	/**
	 * printmatrix print on the standard output a float[][] matrix
	 * @param m is the matrix to be printed,REQUIRE m not to be null
	 */
	private static void printmatrix(float[][] m){
		assert (m!=null) : "m is not expected to be null";
		for (int i = 0; i < m.length; i++) {
		    for (int j = 0; j < m[0].length; j++) {
		        System.out.print(m[i][j] + " ");
		    }
		    System.out.print("\n");
		    assert (m!=null) : "m is not expected to be null";
		}
	}
}

