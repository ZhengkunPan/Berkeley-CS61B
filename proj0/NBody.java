public class NBody {

	/** Reads in the radius of the universe*/
	public static double readRadius(String address) {
		In in = new In(address);
		int firstItemInFile = in.readInt();
		double secondItemInFile = in.readDouble();
		return secondItemInFile;
	}

	/** Reads in the planets*/
	public static Planet[] readPlanets(String address) {
		In in = new In(address);
		int numberPlanets = in.readInt();
		double secondItemInFile = in.readDouble();
		Planet[] planetArray = new Planet[numberPlanets];
		int index = 0;
		while (numberPlanets > 0) {
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String planetName = in.readString();
			planetArray[index] = new Planet(xPos, yPos, xVel, yVel, mass, planetName);
			numberPlanets -= 1;
			index += 1;
		}
		return planetArray;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		Planet[] planets = readPlanets(filename);
		double universeRadius = readRadius(filename);

		StdDraw.enableDoubleBuffering();

		double time = 0;

		while (time < T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int i = 0; i < planets.length; i += 1) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < planets.length; i += 1) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			StdDraw.setScale(-1*universeRadius, universeRadius);
			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (Planet planet : planets) {
				planet.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			
			time += dt;
		}

		/** Prints out the resutls*/
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", universeRadius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}

}