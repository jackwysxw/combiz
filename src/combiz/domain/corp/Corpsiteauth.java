package combiz.domain.corp;



/**
 * Corpsiteauth generated by MyEclipse - Hibernate Tools
 */

public class Corpsiteauth  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String grpname;
     private String sitenum;
     private String corpnum;


    // Constructors

    /** default constructor */
    public Corpsiteauth() {
    }

    
    /** full constructor */
    public Corpsiteauth(String grpname, String sitenum, String corpnum) {
        this.grpname = grpname;
        this.sitenum = sitenum;
        this.corpnum = corpnum;
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

    public String getSitenum() {
        return this.sitenum;
    }
    
    public void setSitenum(String sitenum) {
        this.sitenum = sitenum;
    }

    public String getCorpnum() {
        return this.corpnum;
    }
    
    public void setCorpnum(String corpnum) {
        this.corpnum = corpnum;
    }
   








}