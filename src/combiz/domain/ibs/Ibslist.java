package combiz.domain.ibs;



/**
 * Ibslist generated by MyEclipse - Hibernate Tools
 */

public class Ibslist  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String listname;
     private String listtype;
     private String description;


    // Constructors

    /** default constructor */
    public Ibslist() {
    }

	/** minimal constructor */
    public Ibslist(String listname) {
        this.listname = listname;
    }
    
    /** full constructor */
    public Ibslist(String listname, String listtype, String description) {
        this.listname = listname;
        this.listtype = listtype;
        this.description = description;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getListname() {
        return this.listname;
    }
    
    public void setListname(String listname) {
        this.listname = listname;
    }
    
    public void setListtype(String listtype) {
        this.listtype = listtype;
    }
    
    public String getListtype() {
        return this.listtype;
    }    

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   








}