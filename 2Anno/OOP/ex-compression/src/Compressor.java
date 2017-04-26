import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Compressor {
	

	/**Compress removes black spaces form a file. 
	 * @param file is the path to the file to compress
	 * @param out if the path to the compressed file
	 * @thows FileNotFoundException if the file does not exists
	 */
	public static void compress(String file, String out) throws FileNotFoundException{
		try{
			FileReader f =new FileReader(file);			
	        PrintWriter writer = new PrintWriter(out, "UTF-8");
            BufferedReader in = new BufferedReader(f);
            
            String line;
            while((line=in.readLine())!=null){
            	writer.println(line.replaceAll("\\s+",""));
            }
            
            in.close();
            writer.close();
            
		} catch(FileNotFoundException fileEx) {
		    throw new FileNotFoundException();
		 } catch (IOException ioe){
	            System.err.println("Something went wrong reading the file");
	     }finally{
	    	 System.out.println("Success!");
	     }
	}
	
	public static void main(String[] args) throws FileNotFoundException {    	
        compress("/home/theloca95/kodi_crashlog-20170315_105212.log","/home/theloca95/compressedoutput.txt");
    }
}
