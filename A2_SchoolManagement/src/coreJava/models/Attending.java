package coreJava.models;

public class Attending
{
    private int attending_id;
    private String course_name;
    private String full_name;
    private String email;
    
    /**
	 * 
	 */
	public Attending() {
		this.attending_id = 0;
		this.course_name = "";
		this.full_name = "";
		this.email = "";
	}

	/**
	 * @param attending_id
	 * @param course_name
	 * @param full_name
	 * @param email
	 */
	public Attending(int attending_id, String course_name, String full_name, String email) {
		this.attending_id = attending_id;
		this.course_name = course_name;
		this.full_name = full_name;
		this.email = email;
	}

	/**
     * @return the attending_id
     */
    public int getAttending_id()
    {
        return attending_id;
    }

    /**
     * @param attending_id
     *            the attending_id to set
     */
    public void setAttending_id(int attending_id)
    {
        this.attending_id = attending_id;
    }

    /**
     * @return the course_name
     */
    public String getCourse_name()
    {
        return course_name;
    }

    /**
     * @param course_name
     *            the course_name to set
     */
    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }

    /**
     * @return the full_name
     */
    public String getFull_name()
    {
        return full_name;
    }

    /**
     * @param full_name
     *            the full_name to set
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
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
}
