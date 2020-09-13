package common.dto.test;

public class FarmSearchCriteria {

	private String city1;
	private String city2;
	private String filter;
	private String item;
	
	
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return "FarmSearchCriteria [city1=" + city1 + ", city2=" + city2 + ", filter=" + filter + ", item=" + item
				+ "]";
	}
	
	
}
