package combiz.domain.user;



/**
 * Ibsgroupusers generated by MyEclipse - Hibernate Tools
 */

public class Ibsgroupusers  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String grpname;
     private String userid;


    // Constructors

    /** default constructor */
    public Ibsgroupusers() {
    }

    
    /** full constructor */
    public Ibsgroupusers(String grpname, String userid) {
        this.grpname = grpname;
        this.userid = userid;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getGrpname() {
        return this.grpname;
    }
    
    public void setGrpname(String grpname) {
        this.grpname = grpname;
    }

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
   








}