package si;


public class PSO {
    double fitness_global_best_particle_position;
    double[] global_best_particle_position;
    Particle[] swarm_particle;
    int particle_size;
    int iterations;
    // set alpaha , beta and gama values 
    static double[] par = new double[3];
    public static  double  alpha = par[0] ;
	  public  static double beta= par[1];
	 public  static double gamma = par[2];
    
    
    public PSO(int particle_size, int iterations){
        global_best_particle_position = new double[SI.nv];
        swarm_particle = new Particle[particle_size];
        this.particle_size = particle_size;
        this.iterations = iterations;
        
        
        if(SI.mm == -1)
            fitness_global_best_particle_position = Double.POSITIVE_INFINITY;
        if(SI.mm == 1)
            fitness_global_best_particle_position = Double.NEGATIVE_INFINITY;
        
        
        for (int i = 0; i < particle_size; i++) 
        {
            swarm_particle[i] = new Particle();
        }
        
        
        for (int i = 0; i < iterations; i++) 
        {
            for (int j = 0; j < particle_size; j++) 
            {
                swarm_particle[j].evaluate();
                if(SI.mm == -1)
                {
                    if(swarm_particle[j].fitness_particle_position < fitness_global_best_particle_position)
                    {
                        for (int k = 0; k < SI.nv; k++) {
                            global_best_particle_position[k] = swarm_particle[j].particle_position[k];
                        }
                        
                        fitness_global_best_particle_position = swarm_particle[j].fitness_particle_position;
                    }
                }
                
                if(SI.mm == 1)
                {
                    if(swarm_particle[j].fitness_particle_position > fitness_global_best_particle_position)
                    {
                        for (int k = 0; k < SI.nv; k++) {
                            global_best_particle_position[k] = swarm_particle[j].particle_position[k];
                        }
                        fitness_global_best_particle_position = swarm_particle[j].fitness_particle_position;
                    }
                }     
            }
            
            
            for (int j = 0; j < particle_size; j++) 
            {
                swarm_particle[j].update_velocity(global_best_particle_position);
                swarm_particle[j].update_position();

            }
        }
    }
    
    
    public double[] getOptimalSolution()
    {
        System.out.println("Number of Particles: " + particle_size);
        System.out.println("Number of Iterations: " + iterations);
        System.out.println();
        
        System.out.println("Optimal Solution");
        for (int i = 0; i < SI.nv; i++) 
        {
            //System.out.println("x" + (i+1) + ": " + global_best_particle_position[i]);
             alpha = global_best_particle_position[0];
        beta =  global_best_particle_position[1];
        gamma= global_best_particle_position[2];
        }
        par[0] = alpha;
       par[1] = beta;
       par[2] = gamma;
        System.out.println("alpha : " + alpha + " beta : " + beta + " gamma : " +gamma);
        System.out.println();
        System.out.println("Objective Function Value: " + fitness_global_best_particle_position);
        return par;
    }
}
