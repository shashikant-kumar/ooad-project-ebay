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
	User user =new User();
  	ArrayList<SubCategory> allsubcategs=new ArrayList<SubCategory>();
  	private List<Category> allcats;
  	private String username="";
	  
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if (user == null) {
			user = new User();
		}
		username=user.getUsername();
		allcats = new ArrayList<Category>();
		allcats = Category.findallcategory();
		System.out.println("size display"+allcats.size());
		
		for (int i = 0; i < allcats.size(); i++){
        	Category cat_list = allcats.get(i);
        	int categ_id=cat_list.getCateg_id();
        	String categ_name=cat_list.getCateg_name();
        	allsubcategs = 	SubCategory.fetchSubCategory(categ_id);
        	allcats.get(i).setSubcats(allsubcategs);
        }
		
		for (int k = 0; k < allcats.size(); k++){
        	Category cat_list = allcats.get(k);
        	List<SubCategory> test=cat_list.getSubcats();
        	System.out.println("size of each item details"+test.size());
        	if(test.size()!=0){
        	for(int j = 0; j < test.size(); j++)
        	{
        		SubCategory ite=test.get(j);
        		System.out.println("item name"+ite.getSubcateg_name());
        	}
        	}		
        }
		System.out.println("first value"+allcats.get(0).getSubcats().get(0).getSubcateg_name());

		return "success";

	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<SubCategory> getAllsubcategs() {
		return allsubcategs;
	}

	public void setAllsubcategs(ArrayList<SubCategory> allsubcategs) {
		this.allsubcategs = allsubcategs;
	}

	public List<Category> getallcats() {
		return allcats;
	}

	public void setallcats(List<Category> allcats) {
		this.allcats = allcats;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
