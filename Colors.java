
/**
 * @author John Doe
 */
public final class Color {

    /**
     * Returns red component from given packed color.
     * @param rgb 32-bits RGB color
     * @return a float between 0.0 and 1.0
     * @see #getGreen
     * @see #getBlue
     * @see #getRGB(float, float, float)
     */
    public static float getRed(int rgb) {
        // TODO getRed
    	int red = (rgb >>16) & 0b11111111;
        return red/255.0f;
    }

    /**
     * Returns green component from given packed color.
     * @param rgb 32-bits RGB color
     * @return a float between 0.0 and 1.0
     * @see #getRed
     * @see #getBlue
     * @see #getRGB(float, float, float)
     */
    public static float getGreen(int rgb) {
        // TODO getGreen
    	int green = (rgb >>8) & 0b11111111;
        return green/255.0f;
    }

    /**
     * Returns blue component from given packed color.
     * @param rgb 32-bits RGB color
     * @return a float between 0.0 and 1.0
     * @see #getRed
     * @see #getGreen
     * @see #getRGB(float, float, float)
     */
    public static float getBlue(int rgb) {
        // TODO getBlue
    	int blue = rgb & 0b11111111;
        return blue/255.0f;
    }
    
    /**
     * Returns the average of red, green and blue components from given packed color.
     * @param rgb 32-bits RGB color
     * @return a float between 0.0 and 1.0
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getRGB(float)
     */
    public static float getGray(int rgb) {
        // TODO getGray
        return (getRed(rgb)+getGreen(rgb)+getBlue(rgb))/3;
    }
    
    //Check if float x is in interval 0<=x<=1
    public static float checkFloat(float color){
    	if(color<0){
    		color=0;
    	}else if(color>1){
    		color=1;
    	}
    	return color;
    }
    
    /**
     * Returns packed RGB components from given red, green and blue components.
     * @param red a float between 0.0 and 1.0
     * @param green a float between 0.0 and 1.0
     * @param blue a float between 0.0 and 1.0
     * @return 32-bits RGB color
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     */
    public static int getRGB(float red, float green, float blue) {
        // TODO getRGB
    	blue = checkFloat(blue);
    	red = checkFloat(red);
    	green = checkFloat(green);

    	int rgb = (int)(red*255.0f);
    	rgb = (rgb << 8) + (int)(green*255.0f);
    	rgb = (rgb << 8) + (int)(blue*255.0f);
        return rgb;
    }
    
    /**
     * Returns packed RGB components from given grayscale value.
     * @param red a float between 0.0 and 1.0
     * @param green a float between 0.0 and 1.0
     * @param blue a float between 0.0 and 1.0
     * @return 32-bits RGB color
     * @see #getGray
     */
    public static int getRGB(float gray) {
        // TODO getRGB
    	gray=checkFloat(gray);
    	int rgb = (int)(gray*255.0f);
    	rgb = (rgb << 8) + (int)(gray*255.0f);
    	rgb = (rgb << 8) + (int)(gray*255.0f);
        return rgb;
    }

    /**
     * Converts packed RGB image to grayscale float image.
     * @param image a HxW int array
     * @return a HxW float array
     * @see #toRGB
     * @see #getGray
     */
    public static float[][] toGray(int[][] image) {
        // TODO toGray
    	float[][] gray = new float[image.length][image[0].length];
    	for(int i=0;i<image.length;++i){
    		for(int j=0;j<image[i].length;++j){
    			gray[i][j]=getGray(image[i][j]);
    		}
    	}
        return gray;
    }

    /**
     * Converts grayscale float image to packed RGB image.
     * @param channels a HxW float array
     * @return a HxW int array
     * @see #toGray
     * @see #getRGB(float)
     */
    public static int[][] toRGB(float[][] gray) {
        // TODO toRGB
    	int[][] rgb=new int[gray.length][gray[0].length];
    	for(int i=0;i<gray.length;++i){
    		for(int j=0;j<gray[i].length;++j){
    			rgb[i][j]=getRGB(gray[i][j]);
    		}
    	}
        return rgb;
    }

}
