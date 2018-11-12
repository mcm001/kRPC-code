import pidloop;

void setup() {
	
	public double kp = 5;
	public double ki = 0;
	public double kd = 0;
	
	pidloop.init(kp, ki, kd);
	
}