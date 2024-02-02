
package entity;

public class Property {
    private String address;
    private String suburb;
    private String type;
    private int pricePerWeek;
    private boolean furnished;
    private int noOfBedrooms;
    private int noOfCarSpaces;
    private String state;
    private String publishDate;
    private String contact;
    private String agent;
    private int preferredRentCost;
    private String preferredSuburb;
    private String description;
    private String inspectionDateAndTime;
    private String rentalStatus;



    public Property(String address, String suburb, String type, int pricePerWeek, boolean furnished,
                    int noOfBedrooms, int noOfCarSpaces, String state, String publishDate, String contact,
                    String agent, int preferredRentCost, String preferredSuburb, String description,
                    String inspectionDateAndTime, String rentalStatus) {
        this.address = address;
        this.suburb = suburb;
        this.type = type;
        this.pricePerWeek = pricePerWeek;
        this.furnished = furnished;
        this.noOfBedrooms = noOfBedrooms;
        this.noOfCarSpaces = noOfCarSpaces;
        this.state = state;
        this.publishDate = publishDate;
        this.contact = contact;
        this.agent = agent;
        this.preferredRentCost = preferredRentCost;
        this.preferredSuburb = preferredSuburb;
        this.description = description;
        this.inspectionDateAndTime = inspectionDateAndTime;
        this.rentalStatus = rentalStatus;
    }

    public String getAddress()
    {
        return address;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public String getType()
    {
        return type;
    }

    public int getPricePerWeek()
    {
        return pricePerWeek;
    }

    public boolean getFurnished()
    {
        return furnished;
    }

    public int getNoOfBedrooms()
    {
        return noOfBedrooms;
    }

    public int getNoOfCarSpaces()
    {
        return noOfCarSpaces;
    }

    public String getState()
    {
        return state;
    }

    public String getPublishDate()
    {
        return publishDate;
    }

    public String getContact()
    {
        return contact;
    }

    public String getAgent()
    {
        return agent;
    }

    public int getPreferredRentCost()
    {
        return preferredRentCost;
    }

    public String getPreferredSuburb()
    {
        return preferredSuburb;
    }

    public String getDescription()
    {
        return description;
    }

    public String getInspectionDateAndTime()
    {
        return inspectionDateAndTime;
    }

    public String rentalStatus()
    {
        return rentalStatus;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setPricePerWeek(int pricePerWeek)
    {
        this.pricePerWeek = pricePerWeek;
    }

    public void setFurnished(boolean furnished)
    {
        this.furnished = furnished;
    }


    public void setNoOfBedrooms(int noOfBedrooms)
    {
        this.noOfBedrooms = noOfBedrooms;
    }

    public void setNoOfCarSpaces(int noOfCarSpaces)
    {
        this.noOfCarSpaces = noOfCarSpaces;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setPublishDate(String publishDate)
    {
        this.publishDate = publishDate;
    }
    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public void setAgent(String agent)
    {
        this.agent = agent;
    }

    public void setPreferredRentCost(int preferredRentCost)
    {
        this.preferredRentCost = preferredRentCost;
    }

    public void setPreferredSuburb(String preferredSuburb)
    {
        this.preferredSuburb = preferredSuburb;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setInspectionDateAndTime(String inspectionDateAndTime)
    {
        this.inspectionDateAndTime = inspectionDateAndTime;
    }



}
