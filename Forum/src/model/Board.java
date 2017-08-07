package model;

import java.util.Date;
import java.util.List;

public class Board {
    private Integer id;

    private Date datecreated;

    private Boolean deleted;

    private Integer version;

    private String description;

    private String name;

    private Integer replycount;

    private Integer threadcount;

    private Integer categoryId;

    private Integer lastReplyId;

    private Integer lastThreadId;
    
	private Thread lastThread;
    
    private Reply lastReply;
    
    private Category category;
    
    private int[] AdminId;
    
    private List<Person> administrators;
    
    public int[] getAdminId() {
		return AdminId;
	}

	public void setAdminId(int[] adminId) {
		AdminId = adminId;
	}
    
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
    public List<Person> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<Person> administrators) {
		this.administrators = administrators;
	}

	public Thread getLastThread() {
		return lastThread;
	}

	public void setLastThread(Thread lastThread) {
		this.lastThread = lastThread;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public Integer getThreadcount() {
        return threadcount;
    }

    public void setThreadcount(Integer threadcount) {
        this.threadcount = threadcount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getLastReplyId() {
        return lastReplyId;
    }

    public void setLastReplyId(Integer lastReplyId) {
        this.lastReplyId = lastReplyId;
    }

    public Integer getLastThreadId() {
        return lastThreadId;
    }

    public void setLastThreadId(Integer lastThreadId) {
        this.lastThreadId = lastThreadId;
    }
}