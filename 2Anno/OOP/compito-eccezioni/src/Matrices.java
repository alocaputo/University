public class Matrices {
	
	/**
	 * MatrixBoundException checks that every column of the matrix m have the same length
	 */

	public static class MatrixBoundException extends Exception{
		public MatrixBoundException(){
		    super();
		} 
		public MatrixBoundException(String exc){
	        super(exc);
	    }
		public MatrixBoundException(String exc, Throwable cause) { 
			super(exc, cause); 
		}
		public MatrixBoundException(Throwable cause) { 

			super(cause); 
		}
	}

	/** 
	 * The mission of this class is to provide a number of * standalone procedures that 
	 * can be useful for manipulating * n x m matrices of floats. 
	 * @throws MatrixBoundException 
	 **/

	public static void main (String args[]) throws MatrixBoundException { 

		float[][] arr1 = { { 1,2,3,4},{11,12,13,14},{21,22,23,24}};
		float[][] arr2 = { { 1},{2,2},{3,3},{0,0}};
		float[][] arr3 = { { 1,2,3,4},{11,12,13,14},{21,22,23,24},{ 7,5,58,47}};
		float[][] res = null;
		float[][] res2 = null;	

		try{
		 res = transpose(arr2);
		 //res2 = multiply(arr1,arr2);
		}catch(MatrixBoundException e){
			throw new MatrixBoundException("Every column of the matrix m must have the same length",e);
		}

		

		System.out.println("Transposed: ");

		printmatrix(res);

		System.out.println();

		System.out.println("Mupltiplication: ");

		//printmatrix(res2);	

	}

	/**
	 * transpose perform the transpose of a matrix(swap rows with columns)
	 * @param m the matrix to be transposed, REQUIRE m not to be null
	 * @return temp the transposed matrix (temp[i,j]=m[j,i]). REQUIRE number of temp rows = m columns and temp columns = m rows 
	 */

	public static float[][] transpose (float[][] m) throws MatrixBoundException{

		assert (m!=null) : "m is not expected to be null";

		float[][] temp = new float[m[0].length][m.length];

	//Every column of the matrix m must have the same length

		for(int i = 0;i<m.length;i++){
			if(m[i].length != m[0].length){
				throw new MatrixBoundException("Every column of the matrix m must have the same length");
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

	public static float[][] multiply (float[][] m1, float[][] m2) throws MatrixBoundException{

		assert (m1!=null) : "m1 and m2 are not expected to be null";
		assert (m2!=null) : "m1 and m2 are not expected to be null";
		assert (m1[0].length == m2.length) : "number of m1 columns must be the same of m2 rows";

		float[][] temp = new float[m1.length][m2[0].length]; 
		
		//Every column of the matrix m1 must have the same length

		for(int i = 0;i<m1.length;i++){
			if(m1[i].length != m1[0].length){
				throw new MatrixBoundException();
			}
		}

		//Every column of the matrix m2 must have the same length

		for(int i = 0;i<m2.length;i++){
			if(m2[i].length != m2[0].length){
				throw new MatrixBoundException();
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

	 * printmatrix print on the standard output a float[][] matrix m

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