package zuoye;

/**
 * @author  Jack
 * @description  TODO
 * @date  2017年1月3日  下午7:01:24
 */
public class Account {
	private String id;
	private String name;
	private String account;
	private Integer  count;
	private double price;
	
	public Account(){
		
	}

	/**
	 * @param id
	 * @param name
	 * @param account
	 * @param count
	 * @param price
	 */
	public Account(String id, String name, String account, Integer count, double price) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.count = count;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void print(){
		System.out.println("基金编号："+this.id+",购买人"+this.name+",账户"+this.account+",购买数量"+this.count+",单价"+this.price);
	}

}
