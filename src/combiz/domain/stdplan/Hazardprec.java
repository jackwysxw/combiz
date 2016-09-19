package combiz.domain.stdplan;



/**
 * Hazardprec generated by MyEclipse - Hibernate Tools
 */

public class Hazardprec  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String hazardid;
     private String hazardprec;
     private String description;


    // Constructors

    /** default constructor */
    public Hazardprec() {
    }

	/** minimal constructor */
    public Hazardprec(String hazardid, String hazardprec) {
        this.hazardid = hazardid;
        this.hazardprec = hazardprec;
    }
    
    /** full constructor */
    public Hazardprec(String hazardid, String hazardprec, String description) {
        this.hazardid = hazardid;
        this.hazardprec = hazardprec;
        this.description = description;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getHazardid() {
        return this.hazardid;
    }
    
    public void setHazardid(String hazardid) {
        this.hazardid = hazardid;
    }

    public String getHazardprec() {
        return this.hazardprec;
    }
    
    public void setHazardprec(String hazardprec) {
        this.hazardprec = hazardprec;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}