public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	final static double gravity = 6.67e-11;

	/** Constructor of Planet class*/
	public Planet(double xP, double yP, double xV,
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Copy Planet class*/
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/** Calculates the distance between two Planets*/
	public double calcDistance(Planet p) {
		double distance = Math.pow((Math.pow((this.xxPos - p.xxPos), 2)
			+ Math.pow((this.yyPos - p.yyPos), 2)), 0.5);
		return distance;
	}

	/** Calculates the force exerted on this planet by the given planet*/
	public double calcForceExertedBy(Planet p) {
		double force = gravity*(this.mass)*(p.mass) / Math.pow(this.calcDistance(p),2);
		return force;
	}

	/** Calculates the force exerted in the X*/
	public double calcForceExertedByX(Planet p) {
		double forceNet = this.calcForceExertedBy(p);
		double forceX = forceNet*(p.xxPos-this.xxPos)/this.calcDistance(p);
		return forceX;
	}

	/** Calculates the force exerted in the Y*/
	public double calcForceExertedByY(Planet p) {
		double forceNet = this.calcForceExertedBy(p);
		double forceY = forceNet*(p.yyPos-this.yyPos)/this.calcDistance(p);
		return forceY;
	}

	/** Calculates the net X force exerted by all planets*/
	public double calcNetForceExertedByX(Planet[] planetArray) {
		double netForceX = 0;
		for (Planet p : planetArray) {
			if (p.equal(this)) {
				continue;
			} else {
				netForceX += this.calcForceExertedByX(p);
			}
		}
		return netForceX;
	}

	/** Calculates the net Y force exerted by all planets*/
	public double calcNetForceExertedByY(Planet[] planetArray) {
		double netForceY = 0;
		for (Planet p : planetArray) {
			if (p.equal(this)) {
				continue;
			} else {
				netForceY += this.calcForceExertedByY(p);
			}
		}
		return netForceY;
	}

	/** Compares two planets*/
	public boolean equal(Planet p) {
		if (this.xxPos == p.xxPos &&
			this.yyPos == p.yyPos &&
			this.xxVel == p.xxVel &&
			this.yyVel == p.yyVel &&
			this.mass == p.mass &&
			this.imgFileName == p.imgFileName) {
			return true;
		}
		return false;
	}

	/** Changes the planet’s velocity and position in a small period of time dt*/
	public void update(double duration, double xforce, double yforce) {
		double accelerationX = xforce / mass;
		double accelerationY = yforce / mass;
		xxVel = (xxVel + duration * accelerationX);
		yyVel = (yyVel + duration * accelerationY);
		xxPos = (xxPos + duration * xxVel);
		yyPos = (yyPos + duration * yyVel);
	}

}



