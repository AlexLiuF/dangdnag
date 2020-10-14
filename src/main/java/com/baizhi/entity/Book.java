package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
	private Integer id;
	private String name;
	private String author;
	private String cover;
	private String press;
	private Date press_date;
	private Integer edition;
	private Date printDate;
	private Integer impression;
	private String isbn;
	private Integer wordNum;
	private Integer pageNum;
	private String sizeB;
	private String paper;
	private String pack;
	private Double price;
	private Double dprice;
	private Date createDate;
	private String editorRecommend;
	private String contentAbstract;
	private String authorAbstract;
	private String director;
	private String mediaCommentary;
	private Integer sale;
	private Integer stock;
	private Date updateDate;
	private Integer categoryId;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String name, String author, String cover, String press, Date press_date, Integer edition,
			Date printDate, Integer impression, String isbn, Integer wordNum, Integer pageNum, String sizeB,
			String paper, String pack, Double price, Double dprice, Date createDate, String editorRecommend,
			String contentAbstract, String authorAbstract, String director, String mediaCommentary, Integer sale,
			Integer stock, Date updateDate, Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.press_date = press_date;
		this.edition = edition;
		this.printDate = printDate;
		this.impression = impression;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.pageNum = pageNum;
		this.sizeB = sizeB;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.createDate = createDate;
		this.editorRecommend = editorRecommend;
		this.contentAbstract = contentAbstract;
		this.authorAbstract = authorAbstract;
		this.director = director;
		this.mediaCommentary = mediaCommentary;
		this.sale = sale;
		this.stock = stock;
		this.updateDate = updateDate;
		this.categoryId = categoryId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPress_date() {
		return press_date;
	}
	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public Integer getImpression() {
		return impression;
	}
	public void setImpression(Integer impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWordNum() {
		return wordNum;
	}
	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getSizeB() {
		return sizeB;
	}
	public void setSizeB(String sizeB) {
		this.sizeB = sizeB;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEditorRecommend() {
		return editorRecommend;
	}
	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}
	public String getContentAbstract() {
		return contentAbstract;
	}
	public void setContentAbstract(String contentAbstract) {
		this.contentAbstract = contentAbstract;
	}
	public String getAuthorAbstract() {
		return authorAbstract;
	}
	public void setAuthorAbstract(String authorAbstract) {
		this.authorAbstract = authorAbstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMediaCommentary() {
		return mediaCommentary;
	}
	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", cover=" + cover + ", press=" + press
				+ ", press_date=" + press_date + ", edition=" + edition + ", printDate=" + printDate + ", impression="
				+ impression + ", isbn=" + isbn + ", wordNum=" + wordNum + ", pageNum=" + pageNum + ", sizeB=" + sizeB
				+ ", paper=" + paper + ", pack=" + pack + ", price=" + price + ", dprice=" + dprice + ", createDate="
				+ createDate + ", editorRecommend=" + editorRecommend + ", contentAbstract=" + contentAbstract
				+ ", authorAbstract=" + authorAbstract + ", director=" + director + ", mediaCommentary="
				+ mediaCommentary + ", sale=" + sale + ", stock=" + stock + ", updateDate=" + updateDate
				+ ", categoryId=" + categoryId + "]";
	}
	
	
	
}
