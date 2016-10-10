/**
 * Given an array of windows in the plane, we want to count how many overlapping and how many enclosing pairs of windows 
 * there are (without double counting).This class counts the Overlaps and Enclose for an Array of windows
 * @author vishal
 *
 */
public class Window {
	/*
	 * Initializing of fields
	 */
	protected double left;
	protected double right;
	protected double top;
	protected double bottom;
	protected static double OverLapCounter = 0;
	protected static double EncloseCounter = 0;	
	/*
	 * Default Constructor
	 * It takes users values and check whether its according to specifications or not and throws custom made exception for those fields
	 * @param left, right, bottom, top
	 */
	public Window(double left, double right, double bottom, double top) throws InvalidWindowException{
		if(top > bottom){
			this.top = top;
			this.bottom = bottom;
		}else{
			throw new InvalidWindowException("Top should be gretter than bottom");
		}

		if(right>left){
			this.right = right;
			this.left = left;
		}else{
			throw new InvalidWindowException("Right should be gretter that left");
		}
	}
    /*
     * Gets the value of left
     * @return left
     */
	public double getLeft() {
		return left;
	}

	/*
	 * Will set the value provided by users to this.left and also checks wheather the left is greater than right or not and in addtion also
	 * throws exceptions if the it required
	 * @param left
	 */
	public void setLeft(double left) throws InvalidWindowException {
		if(left>this.right)
			throw new InvalidWindowException("The left side of window should be smaller than right side");
		else
		this.left = left;
	}
	/*
	 * Gets the value of right
	 * @return right
	 */

	public double getRight() {
		return right;
	}

	/*
	 * Will set the value provided by users to this.right and also checks whether the right is greater than left or not and in addtion also
	 * throws exceptions if the it required
	 * @param right
	 */
	public void setRight(double right) throws InvalidWindowException {
		if(right>this.left)
			this.right = right;
		else
			throw new InvalidWindowException("The right side of window should be greater than left side");
	}

	/*
	 * 
	 */
	public static double getOverLapCounter() {
		return OverLapCounter;
	}

	public static double getEncloseCounter() {
		return EncloseCounter;
	}

	public double getTop() {
		return top;
	}

	public void setTop(double top) throws InvalidWindowException {
		if(top>this.bottom)
		this.top = top;
		else
			throw new InvalidWindowException("The  Top side of window should be greater than bottom side");
		
	}

	public double getBottom() {
		return bottom;
	}

	public void setBottom(double bottom) throws InvalidWindowException {
		if(bottom>this.top)
			throw new InvalidWindowException("The  Bottom side of window should be smaller than top side");
		
		this.bottom = bottom;
	}

	public boolean overlaps(Window w){
		if(this.top<=w.bottom){
			return false;
		}else if(this.left>=w.right){
			return false;
		}else if(this.right<=w.left){
			return false;
		}else if(this.bottom>=w.top){
			return false;
		}
		return true;
	}

	public boolean enclose(Window w){
		return (this.top>=w.top && this.bottom<=w.bottom && this.left<=w.left && this.right>=w.right) ?  true: false;
	}

	public static double overlapCount(Window[] window){
		for(int i=0;i<window.length;i++){
			for(int j = i+1; j<window.length;j++)
			if(window[i].overlaps(window[j])){
				OverLapCounter++;
			}
		}
		return OverLapCounter;
	}

	public static double enclosureCount(Window[] window){
		for(int i = 0; i<window.length; i++){
			for(int j = i+1; j<window.length; j++){
				if(window[i].enclose(window[j]) || window[j].enclose(window[i])){
					EncloseCounter++;
				}
			}
		}
		return EncloseCounter;
	}

	public static void main(String[] args) throws InvalidWindowException{
		Window w0 = new Window(8, 24, 4, 18);
		Window w1 = new Window(6, 11, 16, 19);
		Window w2 = new Window(6, 9, 13, 15);
		Window w3 = new Window(7, 11, 2, 5);
		Window w4 = new Window(14, 16, 3, 5);
		Window w5 = new Window(19, 21, 2, 4);
		Window w6 = new Window(23, 25, 3, 5);
		Window w7 = new Window(24, 26, 9, 11);
		Window w8 = new Window(23, 26, 13, 15);
		Window w9 = new Window(24, 25, 17, 19);
		Window w10 = new Window(15, 18, 17, 19);
		Window w11 = new Window(18, 21, 14, 16);
		Window w12 = new Window(3, 5, 9, 11);
		
		System.out.println("Does w0 overlaps w1: " + w0.overlaps(w1));
		System.out.println("Does w0 overlaps w2: " + w0.overlaps(w2));
		System.out.println("Does w0 overlaps w3: " + w0.overlaps(w3));
		System.out.println("Does w0 overlaps w4: " + w0.overlaps(w4));
		System.out.println("Does w0 overlaps w5: " + w0.overlaps(w5));
		System.out.println("Does w0 overlaps w6: " + w0.overlaps(w6));
		System.out.println("Does w0 overlaps w7: " + w0.overlaps(w7));
		System.out.println("Does w0 overlaps w8: " + w0.overlaps(w8));
		System.out.println("Does w0 overlaps w9: " + w0.overlaps(w9));
		System.out.println("Does w0 overlaps w10: " + w0.overlaps(w10));
		System.out.println("Does w0 overlaps w11: " + w0.overlaps(w11));
		System.out.println("Does w0 overlaps w12: " + w0.overlaps(w12));
		
		Window[] windows = new Window[13];	
		windows[0] = w0;
		windows[1] = w1;
		windows[2] = w2;
		windows[3] = w3;
		windows[4] = w4;
		windows[5] = w5;
		windows[6] = w6;
		windows[7] = w7;
		windows[8] = w8;
		windows[9] = w9;
		windows[10] = w10;
		windows[11] = w11;
		windows[12] = w12;
	
		System.out.println(Window.overlapCount(windows));
		System.out.println(Window.enclosureCount(windows));
	}
} 