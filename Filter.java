
/**
 * @author John Doe
 */
public final class Filter {

	//Adjust row an col if they are not between 0 and (gray.length-1)
	public static int checkRowCol(int size, int n){
		if(n>=(size)){
    		n=(size-1);
    	}
    	if(n<0){
    		n=0;
    	}
    	return n;
	}
	
    /**
     * Get a pixel without accessing out of bounds
     * @param gray a HxW float array
     * @param row Y coordinate
     * @param col X coordinate
     * @return nearest valid pixel color
     */
    public static float at(float[][] gray, int row, int col) {
        // TODO at
    	row = checkRowCol(gray.length, row);
    	col = checkRowCol(gray[0].length, col);
        return gray[row][col];
    }

    /**
     * Convolve a single-channel image with specified kernel.
     * @param gray a HxW float array
     * @param kernel a MxN float array, with M and N odd
     * @return a HxW float array
     */
    public static float[][] filter(float[][] gray, float[][] kernel) {
        // TODO filter
    	float[][] filtered=new float[gray.length][gray[0].length];
    	for(int i=0;i<gray.length;++i){
    		for(int j=0;j<gray[0].length;++j){
    			if(i==0){
    				
    			}
    			
    			for(int n=0;n<kernel.length;++n){
    				for(int m=0;m<kernel.length;++m){
    					filtered[i][j]+=at(gray, i-1+n, j-1+m)*kernel[m][n];//FAUX
    				}
    			}
    		}
    	}
        return filtered;
    }

    /**
     * Smooth a single-channel image
     * @param gray a HxW float array
     * @return a HxW float array
     */
    public static float[][] smooth(float[][] gray) {
        // TODO smooth
    	float[][] smooth={{1/10.0f, 1/10.0f, 1/10.0f}, {1/10.0f, 1/5.0f, 1/10.0f}, {1/10.0f, 1/10.0f, 1/10.0f}};
        return filter(gray, smooth);
    }

    /**
     * Compute horizontal Sobel filter
     * @param gray a HxW float array
     * @return a HxW float array
     */
    public static float[][] sobelX(float[][] gray) {
        // TODO sobelX
    	float sobelX[][] = {{-1,0,1},{-2,0,2},{-1,0,1}};
        return filter(gray, sobelX);
    }

    /**
     * Compute vertical Sobel filter
     * @param gray a HxW float array
     * @return a HxW float array
     */
    public static float[][] sobelY(float[][] gray) {
        // TODO sobelY
    	float sobelY[][] = {{-1,-2,-1},{0,0,0},{1,2,1}};
        return filter(gray, sobelY);
    }

    /**
     * Compute the magnitude of combined Sobel filters
     * @param gray a HxW float array
     * @return a HxW float array
     */
    public static float[][] sobel(float[][] gray) {
        // TODO sobel
    	float[][] sobelX=sobelX(gray);
    	float[][] sobelY=sobelY(gray);
    	float[][] sobel= new float[gray.length][gray[0].length];
    	for(int i=0;i<gray.length;++i){
    		for(int j=0;j<gray[0].length;++j){
    			sobel[i][j]=(float)(Math.sqrt(Math.pow(sobelX[i][j], 2)+Math.pow(sobelY[i][j], 2)));
    		}
    	}
        return sobel;
    }

}
