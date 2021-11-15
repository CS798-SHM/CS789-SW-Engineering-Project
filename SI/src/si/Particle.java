package si;


public class Particle {
    double[] particle_position;                         // particle position
    double[] particle_velocity;                         // particle velocity
    double[] local_best_particle_position;              // best position of the particle
    double fitness_local_best_particle_position;        // initial objective function value of the best particle position
    double fitness_particle_position;                   // objective function value of the particle position
    
    public Particle()
    {
        particle_position = new double[SI.nv];
        particle_velocity = new double[SI.nv];
        local_best_particle_position = new double[SI.nv];
        
        for (int i = 0; i < SI.nv; i++) {
            particle_position[i] = (Math.random() * (SI.bounds[i][1] - SI.bounds[i][0])) + SI.bounds[i][0];
            particle_velocity[i] = (Math.random() * (-1 - 1)) + 1;
        }
    }
    
    
    public void evaluate()
    {
        fitness_particle_position = SI.objective_function(particle_position);
          
        if(SI.mm == -1)
        {
            if(fitness_particle_position < fitness_local_best_particle_position)
            {
                local_best_particle_position = particle_position;                       // update the local best
                fitness_local_best_particle_position = fitness_particle_position;       // update the fitness of the local best
            }
        }
        
        if(SI.mm == 1)
        {
            if(fitness_particle_position > fitness_local_best_particle_position)
            {
                local_best_particle_position = particle_position;                       // update the local best
                fitness_local_best_particle_position = fitness_particle_position;       // update the fitness of the local best
            }
        }
    }
    
    
    public void update_velocity(double[] global_best_particle_position)
    {
        for (int i = 0; i < SI.nv; i++) 
        {
            double c1 = SI.c1;
            double c2 = SI.c2;
            double w = SI.w;
            
            double r1 = Math.random();
            double r2 = Math.random();
            
            double cognitive_velocity = c1*r1*(local_best_particle_position[i] - particle_position[i]);
            double social_velocity = c2*r2*(global_best_particle_position[i] - particle_position[i]);
            particle_velocity[i] = w*particle_velocity[i] + cognitive_velocity + social_velocity;
        }
    }
    
    
    public void update_position()
    {
        for (int i = 0; i < SI.nv; i++) 
        {
            particle_position[i] = particle_position[i] + particle_velocity[i];
 
            // check and repair to satisfy the upper bounds
            if(particle_position[i] > SI.bounds[i][1])
            {
                particle_position[i] = SI.bounds[i][1];
            }
            
            // check and repair to satisfy the lower bounds
            if(particle_position[i] < SI.bounds[i][0])
            {
                particle_position[i] = SI.bounds[i][0];
            }
        }
       
    }
}
