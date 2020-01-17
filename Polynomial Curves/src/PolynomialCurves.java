
public class PolynomialCurves {

	public static boolean onCurve(int[] coord, double[] coeff, double thick) {
		double y = 0;
		for(int i =0; i<coeff.length;i++) {
			y = (coeff[i])*(Math.pow(coord[0], coeff.length-1-i)) + y;
		}
		if (y < (coord[1] + thick) && y > (coord[1]-thick)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void verifyInput(double[] coeff, double thick) {
		if(coeff.length<1) {
			throw new IllegalArgumentException("Invalid input, must at least contain one element.");
		} if(!(thick>0)) {
			throw new IllegalArgumentException("Invalid input, Thickness must be a positive value.");
		}
	}
	
	public static void drawCurve(double[] coefficients,double thickness, char c){
	    
	    verifyInput(coefficients, thickness);
	    
	    int length = coefficients.length;
	    int higestPower = length-1;
	    int yInt = (int)coefficients[higestPower];
	    
	    int[] points = new int[2];
	    
	    int upperLimit = 10;
	    int lowerLimit = -10;
	    
	     if(yInt>5){  
	       upperLimit = yInt+5;
	     }
	     if(yInt<-5){
	       lowerLimit = yInt-5;
	     }
	    
	    for(int y=upperLimit; y>=lowerLimit; y--){
	      for(int x=-10; x<=10; x++){
	        
	        points[0]=x;
	        points[1]=y;
	        
	        if(onCurve(points,coefficients,thickness)){
	          System.out.print(c);
	        } else if (x==0 && y==0){
	          System.out.print('+');
	        } else if (x==0 && y==upperLimit){
	          System.out.print('^');
	        } else if (x==10 && y==0){
	          System.out.print('>');
	        } else if (y==0){
	          System.out.print('-');
	        } else if (x==0){
	          System.out.print('|');
	        }  else {
	          System.out.print(" ");
	        }   
	      }
	      System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		double[] line = {1.0, 2}; // y = x + 2
		double[] parabola = {0.1, -1, -8}; // y = 0.1x^2 - x - 8
		int[] pointOne = {0, 2};
		int[] pointTwo = {0, -8};
		int[] pointThree = {-5, -1};
		int[] pointFour = {3, 5};
		double lineThickness = 1;
		double parabolaThickness = 1.05;
		/*System.out.println(onCurve(pointOne, line, lineThickness));
		System.out.println(onCurve(pointTwo, line, lineThickness));
		System.out.println(onCurve(pointThree, line, lineThickness));
		System.out.println(onCurve(pointFour, line, lineThickness));
		System.out.println(onCurve(pointFour, parabola, parabolaThickness));
		System.out.println(onCurve(pointTwo, parabola, parabolaThickness));
		System.out.println(onCurve(pointThree, parabola, parabolaThickness));
		System.out.println(onCurve(pointFour, parabola, parabolaThickness));
		*/
		drawCurve(parabola,1,'*');
		
		
	}
}
