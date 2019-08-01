package sef.module6.activity;


public class Point2DImpl implements Point2D {
	
	private double x;
	private double y;
	
	/**
	 * Creates a Point2D object at a default location (0,0)
	 */
	public Point2DImpl(){
		this(0, 0);
	}
	
	/**
	 * Create a Point2D object that represents a 2D coordinate specified 
	 * by the constructor parameters
	 * 
	 * @param x coordinate of the point along the x-axis
	 * @param y coordinate of the point along the y-axis
	 */
	public Point2DImpl(double x, double y){
		this.setX(x);
		this.setY(y);
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#move(double, double)
	 */
	public final void move(double x, double y){
		this.setX(x);
		this.setY(y);
	}
	
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#setX(double)
	 */
	public void setX(double x){
		this.x = x;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#setY(double)
	 */
	public void setY(double y){
		this.y = y;
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getX()
	 */
	public double getX(){
		return this.x;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getY()
	 */
	public double getY(){
		return this.y;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#translate(double, double)
	 */
	public final void translate(double dx, double dy){
		this.setX(getX()+dx);
		this.setY(getY()+dy);
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object p){
		if(p == this)
			return true;
		if(p == null)
			return false;
		if(!(getClass() == p.getClass()))
			return false;
		else
		{
			Point2D tmp = (Point2D) p;
			if(this.equals(tmp.getX(),tmp.getY()))
				return true;
			else
				return false;
		}
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#equals(double, double)
	 */
	public boolean equals(double x2, double y2){
		return (-0.00001 <= Math.abs(this.getX()-x2) && Math.abs(this.getY()-y2) <= 0.00001);
	}
	
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getDistance(sef.module5.activity.Point2D)
	 */
	public final double getDistance(Point2D p){
		return this.getDistance(p.getX(),p.getY());
	}
	
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point2D#getDistance(double, double)
	 */
	public final double getDistance(double x2, double y2){
		return Math.sqrt((this.getX()-x2)*(this.getX()-x2)+(this.getY()-y2)*(this.getY()-y2));
	}
	
	
	
}
