package model;

import java.util.Date;

public class Thread {
    private Integer id;

    private Date datecreated;

    private Boolean deleted;

    private Integer version;

    private Date datelastreplied;

    private Integer hit;

    private String ipcreated;

    private Boolean readonly;

    private Integer replycount;

    private String title;

    private Boolean topped;

    private Integer authorId;

    private Integer authorLastRepliedId;

    private Integer boardId;

    private String content;
    
    private Person author;
    
    private Person authorLastReplied;
    
    private Board board;
    
    public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Person getAuthorLastReplied() {
		return authorLastReplied;
	}

	public void setAuthorLastReplied(Person authorLastReplied) {
		this.authorLastReplied = authorLastReplied;
	}
    
    public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
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

    public Date getDatelastreplied() {
        return datelastreplied;
    }

    public void setDatelastreplied(Date datelastreplied) {
        this.datelastreplied = datelastreplied;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public String getIpcreated() {
        return ipcreated;
    }

    public void setIpcreated(String ipcreated) {
        this.ipcreated = ipcreated;
    }

    public Boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
    }

    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getTopped() {
        return topped;
    }

    public void setTopped(Boolean topped) {
        this.topped = topped;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAuthorLastRepliedId() {
        return authorLastRepliedId;
    }

    public void setAuthorLastRepliedId(Integer authorLastRepliedId) {
        this.authorLastRepliedId = authorLastRepliedId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}