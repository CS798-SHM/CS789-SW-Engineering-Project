package si;


public class SI 
{
    // TO CUSTOMIZE THIS PSO CODE TO SOLVE UNCONSTRAINED OPTIMIZATION PROBLEMS, CHANGE THE PARAMETERS IN THIS SECTION ONLY:
    // THE FOLLOWING PARAMETERS MUST BE CHANGED.
    
    public static double objective_function(double[] x)
   {
	   double y = 0;
    	//EvaluationUtil evaluation = new EvaluationUtil(null);
    	//y= evaluation.getFscore();
	   //y= 0.25 * x[0] + 0.48 *x[1] + 0.78 *x[2] ;
	   EvaluationUtil evaluate =new EvaluationUtil();
	   y= evaluate.getFscore();
			   return y; 
    } 

    public static double[][] bounds = new double[][] {{0,1}, {0,1},{0,1}};
    public static int nv = 3;                                                   // number of variables
    public static int mm = 1;                                                  // if minimization problem, mm = -1;
                                                                                // if maximization problem, mm = 1
    
    public static double w = 0.85;                                              // inertia constant
    public static double c1 = 1;                                                // cognative constant
    public static double c2 = 2;                                                // social constant
    // END OF THE CUSTOMIZATION SECTION
    

    public static void main(String[] args) 
    {
        int particle_size = 100;                                // number of particles
        int iterations = 200;                                   // max number of iterations
        
        // Main PSO 
        PSO pso = new PSO(particle_size, iterations);
        pso.getOptimalSolution();
    }
    
}
