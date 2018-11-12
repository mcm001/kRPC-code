import krpc.client.Connection;
import krpc.client.Event;
import krpc.client.RPCException;
import krpc.client.StreamException;
import krpc.client.services.KRPC;
import krpc.client.services.KRPC.Expression;
import krpc.client.services.SpaceCenter;
import krpc.client.services.SpaceCenter.Flight;
import krpc.client.services.SpaceCenter.Node;
import krpc.client.services.SpaceCenter.Resources;
import krpc.schema.KRPC.ProcedureCall;

public class pidloop {
	
	// initiate the PID variables
	public double kp;
	public double ki;
	public double kd;
	public long sample_time;
	public long current_time;
	public long last_time; 
	public long now;
	public long delta_time;
	public double error;
	
	// initiate function
	public void init( double p, double i, double d) {
		kp = p;
		ki = i;
		kd = d;
		
		p = 0;
		i = 0;
		d = 0;
			
		sample_time = 0;
		current_time = System.currentTimeMillis() / 1000l;
		last_time = current_time;
	    System.out.print("Current time: " + current_time + "\nSample time: " + sample_time);
	}
	
	public void update( double measure) {
		now = System.currentTimeMillis() / 1000l;
		delta_time = now - last_time;
		if ( now - last_time == 0 ) {
			delta_time = 0;
		}
		
		
		
	}
	
	
	
}