public class pidloop {
	
	// initiate the PID variables
	public double kp;
	public double ki;
	public double kd;
	public long sample_time;
	public long current_time;
	public long last_time; 
	public double P = 0;
	public double I = 0;
	public double D = 0;
	public double clamp_I;
	public double SetPoint;
	public double last_measure;
			
	
	// initiate function
	public void init( double p, double i, double d) {
		kp = p;
		ki = i;
		kd = d;
		last_measure = 0.0;
		
		clamp_I = 1.0;
			
		sample_time = 0;
		current_time = System.currentTimeMillis() / 1000l;
		last_time = current_time;
	    System.out.print("Current time: " + current_time + "\nSample time: " + sample_time);
	}
	
	public double clamp_I_term(double I) {
		
		if (I > clamp_I) { return clamp_I; }
		else if (I < (-1)*clamp_I) { return (-1)*clamp_I; }
		else { return I; }
		
	}
	
	public double setpoint(double value) {
		SetPoint = value;
		I = 0.1;
	}
	
	public double update( double measure, double setpoint) {
		long now = System.currentTimeMillis() / 1000l;
		long delta_time = now - last_time;
		if ( now - last_time == 0 ) {
			delta_time = 0;
		}
		
		double error = setpoint - measure;
		
		P = error;
		I += error;
		I = clamp_I_term(I);
		D = ( measure - last_measure) / delta_time;
		
		last_measure = measure;
		last_time = now;
		
		return (kp * P) + (ki * I) + (kd * D); //update PID
		
	}
	
	
	
	
}