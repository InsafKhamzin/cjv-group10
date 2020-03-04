package coreJava.models;

public class Teaching
{
    private int teaching_id;
    private String course_name;
    private double minimun_gpa;
    private String full_name;
    private String email;
    
    /**
	 * 
	 */
	public Teaching() {
		this.teaching_id = 0;
		this.course_name = "";
		this.minimun_gpa = 0.0;
		this.full_name = "";
		this.email = "";
	}
	/**
	 * @param teaching_id
	 * @param course_name
	 * @param minimun_gpa
	 * @param full_name
	 * @param email
	 */
	public Teaching(int teaching_id, String course_name, double minimun_gpa, String full_name, String email) {
		this.teaching_id = teaching_id;
		this.course_name = course_name;
		this.minimun_gpa = minimun_gpa;
		this.full_name = full_name;
		this.email = email;
	}
	/**
     * @return the teaching_id
     */
    public int getTeaching_id()
    {
        return teaching_id;
    }
    /**
     * @param teaching_id the teaching_id to set
     */
    public void setTeaching_id(int teaching_id)
    {
        this.teaching_id = teaching_id;
    }
    /**
     * @return the course_name
     */
    public String getCourse_name()
    {
        return course_name;
    }
    /**
     * @param course_name the course_name to set
     */
    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }
    /**
     * @return the minimun_gpa
     */
    public double getMinimun_gpa()
    {
        return minimun_gpa;
    }
    /**
     * @param minimun_gpa the minimun_gpa to set
     */
    public void setMinimun_gpa(double minimun_gpa)
    {
        this.minimun_gpa = minimun_gpa;
    }
    /**
     * @return the full_name
     */
    public String getFull_name()
    {
        return full_name;
    }
    /**
     * @param full_name the full_name to set
     */
    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
}
