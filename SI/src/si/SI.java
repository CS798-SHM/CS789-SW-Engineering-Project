package si;


public class SI 
{
    // TO CUSTOMIZE THIS PSO CODE TO SOLVE UNCONSTRAINED OPTIMIZATION PROBLEMS, CHANGE THE PARAMETERS IN THIS SECTION ONLY:
    // THE FOLLOWING PARAMETERS MUST BE CHANGED.
    
    // Objective Function
    public static double objective_function(double[] x)
    {
        double y;
        y = 3*Math.pow((1-x[0]), 2)
                * Math.exp(-Math.pow(x[0], 2) - Math.pow(x[1]+1, 2))
                - 10*(x[0]/5 - Math.pow(x[0], 3) - Math.pow(x[1], 5))
                * Math.exp(-Math.pow(x[0], 2) - Math.pow(x[1], 2))
                - 1.0/3*Math.exp(-Math.pow(x[0]+1, 2) - Math.pow(x[1], 2));
        
        return y;
    }
    
    
    public static double[][] bounds = new double[][] {{-3, 3}, {-3, 3}};        // upper and lower bounds of variables
    public static int nv = 2;                                                   // number of variables
    public static int mm = -1;                                                  // if minimization problem, mm = -1;
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
