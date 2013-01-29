package lp2.lab05;

/**
 * 
 * @author João Pedro Leôncio <joopeeds@gmail.com>
 * 
 */

public class Polygon {
	private Point[] vertices = new Point[0];
	private Line[] edges = new Line[0];

	/**
	 * @param vertices
	 */

	public Polygon(Point[] vertices) {

		this.vertices = vertices;
		this.edges = new Line[this.vertices.length];
		this.edges[0] = new Line(this.vertices[this.vertices.length - 1],
				this.vertices[0]);
		for (int i = 0; i < this.vertices.length - 1; i++) {
			this.edges[i + 1] = new Line(this.vertices[i], this.vertices[i + 1]);
		}

	}

	public boolean isInside(Point pt) {
		int intersections = 0;
		int in = 0;
		for (int i = 0; i < this.edges.length; i++) {
			if (edges[i].isLeft(pt))
				intersections++;
			if (edges[i].belongsToLine(pt) && !edges[i].isVertical()
					&& pt.getY() <= edges[i].upperLimit()
					&& pt.getY() >= edges[i].lowerLimit()
					&& pt.getX() <= edges[i].upperLimit()
					&& pt.getX() >= edges[i].lowerLimit()) {
				in++;
				
			}

		}
		if (intersections == 0 && in == 1) {
			return true;
		} else
			return intersections % 2 != 0;
	}

	public double perimeter() {

		double perimeter = 0;

		// This sums each line's perimeter that belongs to the polygon
		perimeter += Math
				.sqrt((this.vertices[this.vertices.length - 1].getX() - this.vertices[0]
						.getX())
						* (this.vertices[this.vertices.length - 1].getX() - this.vertices[0]
								.getX())
						+ (this.vertices[this.vertices.length - 1].getY() - this.vertices[0]
								.getY())
						* (this.vertices[this.vertices.length - 1].getY() - this.vertices[0]
								.getY()));

		for (int i = 0; i < this.vertices.length - 1; i++) {

			// This sums each line's perimeter that belongs to the polygon
			perimeter += Math
					.sqrt((this.vertices[i].getX() - this.vertices[i + 1]
							.getX())
							* (this.vertices[i].getX() - this.vertices[i + 1]
									.getX())
							+ (this.vertices[i].getY() - this.vertices[i + 1]
									.getY())
							* (this.vertices[i].getY() - this.vertices[i + 1]
									.getY()));
		}
		// OK. Now, we have a list of the edges and the perimeter of whole
		// polygon

		return perimeter;
	}

	public double area() {
		double area = 0;
		Point[] vert = new Point[this.vertices.length + 1];
		for (int i = this.vertices.length - 1; i >= 0; i--) {
			vert[this.vertices.length - 1 - i] = this.vertices[i];
		}
		vert[this.vertices.length] = this.vertices[0];
		for (int i = 0; i < vert.length - 1; i++) {
			area += vert[i].getX() * vert[i + 1].getY() - vert[i].getY()
					* vert[i + 1].getX();
		}

		/*
		 * double area = 0; for(int i=0; i < this.vertices.length -2; i++){
		 * Point a = vertices[i]; Point b = vertices[i+1]; Point c =
		 * vertices[i+2]; area += Math.abs( a.getX()*b.getY() -
		 * b.getX()*a.getY() + b.getX()*c.getY() - c.getX()*b.getY() +
		 * c.getX()*a.getY() - a.getX()*c.getY() ) / 2; }
		 */
		if (area < 0)
			return -area / 2;
		else
			return area / 2;

	}

}
