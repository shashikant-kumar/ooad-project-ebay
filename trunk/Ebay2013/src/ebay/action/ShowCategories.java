package ebay.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import models.*;
/**
 * 
 * @author Satya Deepthi Bhagi
 */
public class ShowCategories extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private List<Category> allcats;
	private List<BooksSubCateg> book_categs;
	private List<MobilesSubCateg> Mobile_categs;
	private List<CosmeticsSubCateg> cosmetics_categs;
	private List<List> list=new ArrayList<List>();
	Category cat=new Category();
   User user = new User();
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		allcats=new ArrayList<Category>();
		allcats = Category.findallcategory();
		cat.setAllcats(allcats);
		book_categs=new ArrayList<BooksSubCateg>();
		book_categs=BooksSubCateg.getSubcategoryBooks();
		Mobile_categs=new ArrayList<MobilesSubCateg>();
		Mobile_categs=MobilesSubCateg.getSubcategoryMobiles();
		cosmetics_categs=new ArrayList<CosmeticsSubCateg>();
		cosmetics_categs=CosmeticsSubCateg.getSubcategoryCosmetics();
		
		list.add(allcats);
		list.add(Mobile_categs);
		list.add(book_categs);
		list.add(cosmetics_categs);
		
		return "success";
	}
	public List<Category> getAllcats() {
		return allcats;
	}
	public void setAllcats(List<Category> allcats) {
		this.allcats = allcats;
	}
	public List<BooksSubCateg> getBook_categs() {
		return book_categs;
	}
	public void setBook_categs(List<BooksSubCateg> book_categs) {
		this.book_categs = book_categs;
	}
	public List<MobilesSubCateg> getMobile_categs() {
		return Mobile_categs;
	}
	public void setMobile_categs(List<MobilesSubCateg> mobile_categs) {
		Mobile_categs = mobile_categs;
	}
	public List<CosmeticsSubCateg> getCosmetics_categs() {
		return cosmetics_categs;
	}
	public void setCosmetics_categs(List<CosmeticsSubCateg> cosmetics_categs) {
		this.cosmetics_categs = cosmetics_categs;
	}
	
	public List<List> getList() {
		return list;
	}
	public void setList(List<List> list) {
		this.list = list;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
